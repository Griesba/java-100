package nio;

import java.io.IOException;

public class GeszioneAutomezzo {

    public static void combine(String string) {

        for (int i = 0, j=1; i < string.length(); i++, j++) {
            if (i+1 == string.length()) j = string.length();
            combine(string.substring(i,j), string.substring(0,i)+string.substring(j));
        }
        //combine(string.substring(0,1), string.substring(1));
    }

    public static void combine(String res, String string) {
        if (string == null || string.length() <= 0) {
            System.out.println(res + " and null string");
            return;
        } else if (string.length() == 1) {
            System.out.println(res.concat(string));
            return;
        }
        for (int i = 0, j=1; i < string.length(); i++, j++) {
            if (i+1 == string.length()) j = string.length();
            combine(res+string.substring(i,j), string.substring(0,i)+string.substring(j));
        }
    }

    public static void main(String[] args) throws IOException {
        /*Path path = Paths.get("automezzi.txt");
        List<String> lines = Files.readAllLines(path);
        for (String line: lines) {
            Scanner scanner = new Scanner(line);

            System.out.println("Ma"+scanner.next());
        }*/
        combine("ABCD");
    }
}
