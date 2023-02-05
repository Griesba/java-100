package leretvil.cleancode.typespecificfunctionality.clean;


import org.mockito.Mockito;

/*
 * what if we add new type in the enum ? risk that we forget the logic
 * we can add function in the enum to be sure every new type will implement its functionality.
 * But is it the right logic ? What if the constant or some other info need to be taken from the database ?
 */
class Movie {

    enum Type {
        REGULAR ,
        NEW_RELEASE ,
        CHILDREN
    }

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
}

public class TypeSpecificFunctionality {

    public static void main(String[] args) {
        FactorRepo repo = Mockito.mock(FactorRepo.class);
        Mockito.when(repo.getFactor()).thenReturn(2d);
        PriceService priceService = new PriceService(repo);
        System.out.println(priceService.computeRegularPrice(2));
        System.out.println(priceService.computeNewRelease(2));
        System.out.println(priceService.computeChildrenPrice(2));
        System.out.println("Commit now");
    }
}