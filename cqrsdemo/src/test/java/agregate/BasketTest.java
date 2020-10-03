package agregate;

import command.AddProduct;
import command.Command;
import event.Event;
import event.ProductAdded;
import event.ProductRemoved;
import event.ProductRemovedBuilder;
import model.Product;
import org.junit.Test;
import repository.EventStore;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static command.Command.builder;
import static org.junit.Assert.*;

public class BasketTest {
    EventStore eventStore = new EventStore();
    Basket basket = new Basket(eventStore);

    @Test
    public void addProduct() {

        AddProduct addProduct = AddProduct
                .builder()
                .setProductId("uuids")
                .setQuantity(2)
                .createAddProduct();

        Command<AddProduct> addProductCommand = Command.builder()
                .setUuid(UUID.randomUUID())
                .setPublishedTime(Instant.now())
                .setAggregateId("aggregateId1")
                .setType(AddProduct.class)
                .setData(addProduct)
                .createCommand();

        basket.addProduct(addProductCommand);

        List<Event> events = eventStore.history(addProductCommand.getAggregateId());
        int indexOf = events.indexOf(addProductCommand);
        if (indexOf < 0) {
            fail();
        }
        Event<AddProduct> expected = events.get(indexOf);
        assertEquals(expected.getType(), addProductCommand.getType());
        assertEquals(expected.getData(), addProductCommand.getData());
    }

    @Test
    public void removeProduct() {
        ProductRemovedBuilder builder = new ProductRemovedBuilder();
        builder.setProductId("product1");
        ProductRemoved pr = builder.createProductRemoved();
    }

    @Test
    public void validate() {


    }

    @Test
    public void deletePanier() {
    }
}