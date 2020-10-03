package agregate;

import com.google.common.collect.Maps;
import command.AddProduct;
import command.Command;
import event.Event;
import event.ProductAdded;
import repository.EventStore;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Basket {

    private EventStore eventStore;

    Basket(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    void addProduct(Command addProductCommand) {

        ProductAdded productAdded = ProductAdded
                .builder()
                .setProductId(((AddProduct) addProductCommand.getData()).getProductId())
                .setQuantity(((AddProduct) addProductCommand.getData()).getQuantity())
                .create();

        Event<ProductAdded> event = Event.
                builder()
                .setAggregateId(addProductCommand.getAggregateId())
                .setTriggeredTime(Instant.now())
                .setCommandId(addProductCommand.getUuid())
                .setUuid(UUID.randomUUID())
                .setData(productAdded)
                .createEvent();

        eventStore.save(event);
    }

    void removeProduct() {

    }

    void validate() {

    }

    void deleteBasket() {

    }

    class Decision {
        private Map<String, Integer> quantity= Maps.newConcurrentMap();

        private Decision(final List<Event> history) {
            for (Event e: history) {
                apply(e);
            }
        }

        void apply(Event event) {

            if (event.getType().equals(ProductAdded.class)) {
                ProductAdded data = (ProductAdded) event.getData();
                quantity.compute(data.getProductId(), (key, value) -> value != null ? data.getQuantity() + value : data.getQuantity());
            }
        }

        public boolean canValidate () {
            return !quantity.isEmpty();
        }
    }
}
