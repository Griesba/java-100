package event;

public class ProductRemovedBuilder {
    private String productId;

    public ProductRemovedBuilder setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public ProductRemoved createProductRemoved() {
        return new ProductRemoved(productId);
    }
}