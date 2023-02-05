package leretvil.cleancode.streamwrecks.dirty;

import leretvil.cleancode.tools.Order;
import leretvil.cleancode.tools.OrderLine;
import leretvil.cleancode.tools.Product;
import leretvil.cleancode.tools.ProductRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class StreamWreck {
    private ProductRepo productRepo;

    public List<Product> getFrequentOrderedProducts(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getCreationDate().isAfter(LocalDate.now().minusYears(1)))
                .flatMap(o -> o.getOrderLines().stream())
                .collect(groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 10)
                .map(Map.Entry::getKey)
                .filter(p -> !p.isDeleted())
                .filter(p -> !productRepo.getHiddenProductIds().contains(p.getId()))
                .collect(toList());
    }
}
