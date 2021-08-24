package java-2d-array-hourglass;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class HourGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int height = arr.size();
        int max= 0, sum = 0;


        for(int j = 0; j < (arr.size() - 3); j++) {
            for(int i = 0; i < (arr.get(j).size() - 3); i++) {
                sum +=arr.get(j).get(i) + arr.get(j).get(i+1) + arr.get(j).get(i+2);
                sum +=arr.get(j+1).get(i+1);
                sum +=arr.get(j+2).get(i) + arr.get(j+2).get(i+1) + arr.get(j+2).get(i+2);
                if(sum > max) {
                    max = sum;
                }
                sum = 0;
            }
        }

        System.out.println(max);

        bufferedReader.close();
    }
}
