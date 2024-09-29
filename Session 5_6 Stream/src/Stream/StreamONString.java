package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamONString {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "orange", "grapes", "watermelon", "pineapple", "kivi");

        Set<String> collect = list.stream()
                .filter(x -> x.length() > 5)
                .map(y -> y.toUpperCase())
                .sorted()

                .collect(Collectors.toSet());
        System.out.println(collect);


    }
}
