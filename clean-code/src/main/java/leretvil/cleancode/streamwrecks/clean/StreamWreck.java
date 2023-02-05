package leretvil.cleancode.streamwrecks.clean;

import leretvil.cleancode.tools.Order;
import leretvil.cleancode.tools.OrderLine;
import leretvil.cleancode.tools.Product;
import leretvil.cleancode.tools.ProductRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamWreck {
    private ProductRepo productRepo;


    public List<Product> getFrequentOrderedProducts(List<Order> orders) {

        Map<Product, Integer> productCounts = orders.stream()
                .filter(this::orderWasCreatedDuringThePreviousYear)
                .flatMap(o -> o.getOrderLines().stream())
                .collect(groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)));

        Predicate<Product> productIsNotHidden =  p -> !productRepo.getHiddenProductIds().contains(p.getId());

        return getFrequentProductOverTheLastYear(productCounts)
                .filter(Product::isNotDeleted)
                .filter(productIsNotHidden)
                .collect(toList());
    }

    private Stream<Product> getFrequentProductOverTheLastYear(Map<Product, Integer> productCounts) {
        return productCounts.entrySet().stream()
                .filter(e -> e.getValue() >= 10)
                .map(Map.Entry::getKey);
    }


    private boolean orderWasCreatedDuringThePreviousYear(Order o) {
        return o.getCreationDate().isAfter(LocalDate.now().minusYears(1));
    }
}
