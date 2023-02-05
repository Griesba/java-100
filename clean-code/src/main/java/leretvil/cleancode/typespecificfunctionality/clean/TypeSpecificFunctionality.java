package leretvil.cleancode.typespecificfunctionality.clean;


/*
 * what if we add new type in the enum ? risk that we forget the logic
 * we can add function in the enum to be sure every new type will implement its functionality
 */
class Movie {


    enum Type {
        REGULAR () {
            public int computePrice(int days) {
               return days + 1;
            }
        },
        NEW_RELEASE () {
            public int computePrice(int days) {
                return days * 2;
            }
        },
        CHILDREN () {
            public int computePrice(int days) {
                return 5;
            }
        };

        public abstract int computePrice(int days);
    }

    private final Type type;

    Movie(Type type) {
        this.type = type;
    }

    public int computePrice(int days) {
        return type.computePrice(days);
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