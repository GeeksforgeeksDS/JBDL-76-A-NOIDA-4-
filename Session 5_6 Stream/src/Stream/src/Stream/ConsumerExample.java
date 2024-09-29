package Stream.src.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        Consumer<String> consumer= (str)-> System.out.println(str) ;
        consumer.accept("hello java ");


        List<String> list = Arrays.asList("shivam,amit, rahul,sohan, mohan");

        Consumer<String> consumer1= (names)-> System.out.println(names);

        list.forEach(consumer1);//forEach internally take consumer



    }
}
