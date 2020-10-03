package event;

import java.util.List;

public class BasketValidated {
    private static List<String> productIds;

    private BasketValidated(List<String> productIds) {
        this.productIds = productIds;
    }

    public List<String> getProductIds() {
        return productIds;
    }

}
