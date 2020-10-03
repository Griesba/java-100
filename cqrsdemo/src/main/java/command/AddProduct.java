package command;

public class AddProduct {
    private final String productId;
    private final int quantity;

    AddProduct(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static AddProductBuilder builder() {
        return new AddProductBuilder();
    }

    public static class AddProductBuilder {
        private String productId;
        private int quantity;

        private AddProductBuilder() {}

        public AddProductBuilder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public AddProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public AddProduct createAddProduct() {
            return new AddProduct(productId, quantity);
        }
    }
}
