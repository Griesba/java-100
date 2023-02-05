package leretvil.cleancode.typespecificfunctionality.dirty;


/*
* what if we add new type in the enum ? risk that we forget the logic
 */
class Movie {


    enum Type {
        REGULAR, NEW_RELEASE, CHILDREN, ELDER
    }

    private final Type type;

    Movie(Type type) {
        this.type = type;
    }

    public int computePrice(int days) {
        switch (type) {
            case REGULAR :  return days + 1;
            case NEW_RELEASE: return days * 2;
            case CHILDREN: return 5;
            default: throw new IllegalArgumentException();
        }
    }
}

public class TypeSpecificFunctionality {

    public static void main(String[] args) {
        System.out.println(new Movie(Movie.Type.REGULAR).computePrice(2));
        System.out.println(new Movie(Movie.Type.NEW_RELEASE).computePrice(2));
        System.out.println(new Movie(Movie.Type.CHILDREN).computePrice(2));
        System.out.println("Commit now");
    }
}