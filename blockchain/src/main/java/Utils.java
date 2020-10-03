public class Utils {

    public static String zero(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
