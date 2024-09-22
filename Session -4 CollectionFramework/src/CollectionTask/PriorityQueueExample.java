package CollectionTask;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {


       // Queue<Integer> num= new PriorityQueue<>();//
        Queue<Integer> num= new PriorityQueue<>(Comparator.reverseOrder());//max heap
        num.add(32);
        num.add(12);
        num.add(3);
        num.add(92);
        num.add(4);
        num.add(9);

        //System.out.println(num);
        System.out.println(num.poll());
        System.out.println(num.poll());
        System.out.println(num.poll());
        System.out.println(num.poll());
        System.out.println(num.poll());
        System.out.println(num.poll());
    }
}
