package griesba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;



class Greedy {
    List<String> out = new ArrayList<>();

    void generate(String input, String pattern, int index, int depth, Character[] tempRes, int[] path) {
        if (depth >= pattern.length()) {
            String str = Arrays.stream(tempRes).map(Object::toString).collect(Collectors.joining());
            if (str.equals(pattern)) {
                out.add(Arrays.toString(path));
            }
        } else
        for (int i = index; i < input.length(); i++) {
            tempRes[depth] = input.charAt(i);
            path[depth] = i;
            generate(input, pattern, i +1, depth +1, tempRes, path);
        }
    }
}

public class SubStringIndex {

    public static void main(String[] args) {
        String mainStr = "ABCDABC";
        String sub = "ABC";

        Greedy greedy = new Greedy();

        greedy.generate(mainStr, sub, 0, 0, new Character[sub.length()], new int[sub.length()]);

        Consumer<String> cusuemr = (x) -> System.out.println(x);
        greedy.out.stream().forEach(cusuemr);

    }
}
