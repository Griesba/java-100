package collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollectors {

    private static final BinaryOperator NOOP_COMBINER = (l,r) -> {
        throw new RuntimeException("Runtime exception not supported");
    };

    @SuppressWarnings("unchecked")
    public static <T, R> Collector<T, R, R> of(Supplier<R> container, BiConsumer<R, T> accumulator) {
        return Collector.of(container, accumulator, NOOP_COMBINER);
    }

    public static <T> Collector<Optional<T>, List<T>, List<T>> optionalToList() {
        return optionalValuesList((l,v) -> v.ifPresent(l::add));
    }


    private static <T> Collector<Optional<T>, List<T>, List<T>> optionalValuesList(
            BiConsumer<List<T>, Optional<T>> accumulator) {
        Supplier<List<T>> supplier = ArrayList::new;
        BinaryOperator<List<T>> combiner = (l,m) -> {
            l.addAll(m);
            return l;
        };
        Function<List<T>,List<T>> finisher = l1 -> l1;
        return Collector.of(supplier,accumulator, combiner, finisher);
    }


}
