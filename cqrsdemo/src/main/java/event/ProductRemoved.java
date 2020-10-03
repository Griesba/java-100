package event;

public class ProductRemoved {

    private final String productId;

    ProductRemoved(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }


}
