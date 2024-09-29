package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    public static void main(String[] args) {

        Predicate<Integer> predicate= (x)->x%2==0; //checking the value is even or not

        System.out.println(predicate.test(23));//false
        System.out.println(predicate.test(56));
        System.out.println(predicate.test(89));
        System.out.println(predicate.test(58));
        System.out.println(predicate.test(84));
        System.out.println(predicate.test(34));

        System.out.println("----------------------");
        Predicate<String> predicate1= (str)->str.length()>5;

        System.out.println(predicate1.test("buubhuhi"));
        System.out.println(predicate1.test("buubhi"));
        System.out.println(predicate1.test("buhi"));
        System.out.println(predicate1.test("buubhi"));
        System.out.println(predicate1.test("buui"));

        List<Integer> list = Arrays.asList(23, 34, 553, 345, 6674, 67654, 74, 665);

        Predicate<Integer> predicate3= (x)->x%2==0;

        List<Integer> collect = list.stream().
                filter(predicate3)
                .collect(Collectors.toList());

        System.out.println(collect);

    }
}
