package CollectionExample;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {


      //  List <Integer> l= new ArrayList<>();
       List <Integer> l= new LinkedList<>();
       /* l.add(1);
        l.add(2);
        l.add(3);
        l.add(333);*/

        for (int i = 1; i < 10; i++) {
            l.add(i);
        }

        Iterator iterator= l.iterator();
        while (iterator.hasNext()){
            Integer i = (Integer) iterator.next();
            if(i%2==0){
                System.out.println(i);
            }
            else
                iterator.remove();

        }
        System.out.println(l);
    }
}
