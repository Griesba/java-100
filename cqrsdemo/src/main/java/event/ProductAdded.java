package event;

import java.time.LocalDate;
import java.util.Date;

public class ProductAdded<T> {

    private final String productId;
    private final int quantity;


    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static Builder builder() {
        return new Builder();
    }

    ProductAdded(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static class Builder {
        private String productId;
        private int quantity;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }


        public ProductAdded create() {
            return new ProductAdded(productId, quantity);
        }
    }

}
