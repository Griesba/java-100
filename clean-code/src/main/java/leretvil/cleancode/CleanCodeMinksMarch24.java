package leretvil.cleancode;

import java.io.*;

interface MyInterface {
    default void defaultMethod() {
        privateMethod();
        System.out.println("default method call");
    }

    private void privateMethod() {
        System.out.println(" ");
    }
}
public class CleanCodeMinksMarch24 {

    static void  readFileBeforeJava9(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try (BufferedReader reader2 = reader) {
            String line;
            while ((line = reader2.readLine()) != null) {
                System.out.println(line);
            }
        }
    }


    static void readFileWithJava9(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try ( reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {
        try {
            readFileBeforeJava9("");

            readFileWithJava9("");

            // read file with java9 with clean code
            new FileInputStream("/tmp/hello").transferTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
