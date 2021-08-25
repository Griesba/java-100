package com.java100.hourglass;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class HourGlass {
    public static void main(String[] args) throws IOException {


        File file = new File("hourglass_in.txt");

        //InputStream is = HourGlass.class.getClassLoader().getResourceAsStream("hourglass_in.txt");


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())));

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
