package Stream;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        Function<String,String> function= (x)->x.toUpperCase();

       // Function<Integer,String> function1= (x)->x.;

        System.out.println(function.apply("uhujbj"));
        System.out.println(function.apply("jnjnbj"));
        System.out.println(function.apply("hyguh"));
        System.out.println(function.apply("jbgygu"));


    }
}
