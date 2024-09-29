package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamONumbers {
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 23, 445, 43, 23, 44, 56,56,46,79, 67, 87, 23, 46, 79, 87, 44, 55, 67, 86);

        //even numbers

        List<Integer> IsEven = list.stream()
                .filter((x) -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(" even numbers : " + IsEven);

        //divide /2


        List<Integer> map = list.stream().filter((x) -> x % 2 == 0)
                .map((x) -> x / 2)
                .collect(Collectors.toList());
        System.out.println(map);


        List<Integer> collect = list.stream().filter((x) -> x % 2 == 0)
                .map((x) -> x / 2)
                .distinct()//removes the duplicates
                .collect(Collectors.toList());
        System.out.println("no duplicates values :"+collect);

        List<Integer> collect1 = list.stream().filter((x) -> x % 2 == 0)
                .map((x) -> x / 2)
                .distinct()//removes the duplicates
                .sorted()
                .sorted(Comparator.reverseOrder())// reverse
                .collect(Collectors.toList());
        System.out.println("sorted order : "+collect1);

        System.out.println("------------");
        Optional<Integer> res = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2)
                .distinct()
                .sorted()
                .max((o1, o2) -> o2 - o1);
                //.collect(Collectors.toList());

        System.out.println(res);

//
//        System.out.println("--------------------------------------------------");
//        List<Integer> list1 = new ArrayList<>();
//
//        for (int i = 0; i < 100000; i++) {
//            list1.add(i);
//        }
//
//
//        long starts= System.currentTimeMillis();
//
//        List<Integer> seqStream = list1.stream().filter(x -> x % 2 == 0)
//                .collect(Collectors.toList());
//
//        long end = System.currentTimeMillis();
//
//        long time = end - starts;
//        System.out.println("seq stream: "+ seqStream);
//        System.out.println(" time taken in ms : "+time);
//
//        System.out.println("------------------------------------------------------------");
//
//        long starts1= System.currentTimeMillis();
//        List<Integer> prStream = list1.parallelStream().filter(x -> x % 2 == 0).
//                collect(Collectors.toList());
//
//
//        long end1 = System.currentTimeMillis();
//
//        long time1 = end1 - starts1;
//
//        System.out.println("parallel stream: "+ prStream);
//        System.out.println(" time  parallel stream taken in ms : "+time1);
//

    }
}
