package leretvil.cleancode.typespecificfunctionality.clean;


import lombok.AllArgsConstructor;
import org.mockito.Mockito;

import java.util.function.BiFunction;

/*
 * what if we add new type in the enum ? risk that we forget the logic
 * we can add function in the enum to be sure every new type will implement its functionality.
 * But is it the right logic ? What if the constant or some other info need to be taken from the database ?
 * The solution here is to use BiFunction function attribute to assign to each type its functionality
 * this help for easy testing and more flexibility adding new type
 */


@AllArgsConstructor
enum Type {
    REGULAR (PriceService::computeNewRelease),
    NEW_RELEASE (PriceService::computeNewRelease),
    CHILDREN (PriceService::computeChildrenPrice);


    public final BiFunction<PriceService, Integer, Integer> priceAlgo;

}

class Movie {


    private final Type type;

    Movie(Type type) {
        this.type = type;
    }
}

interface FactorRepo {
    Double getFactor();
}

class PriceService {
    private FactorRepo repo;

    public PriceService(FactorRepo repo) {
        this.repo = repo;
    }

    protected Integer computeNewRelease(int days) {
        return (int) (days *  repo.getFactor());
    }

    protected Integer computeRegularPrice(int days) {
        return (int)(days + repo.getFactor());
    }

    protected Integer computeChildrenPrice(int days) {
        return repo.getFactor().intValue();
    }

    public Integer computePrice( Type type, int days) {
        return type.priceAlgo.apply(this, days);
    }
}

public class TypeSpecificFunctionality {

    public static void main(String[] args) {
        FactorRepo repo = Mockito.mock(FactorRepo.class);
        Mockito.when(repo.getFactor()).thenReturn(2d);
        PriceService priceService = new PriceService(repo);
        System.out.println(priceService.computePrice(Type.REGULAR, 2));
        System.out.println(priceService.computePrice(Type.NEW_RELEASE, 2));
        System.out.println(priceService.computePrice(Type.CHILDREN, 2));
        System.out.println("Commit now");
    }
}