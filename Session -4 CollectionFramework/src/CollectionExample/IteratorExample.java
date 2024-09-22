package CollectionExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class IteratorExample {
    public static void main(String[] args) {

                List list= new ArrayList();
                for (int i = 1; i < 10; i++) {
                    list.add(i);
                }

                // Getting the ListIterator
                ListIterator listIterator = list.listIterator();

                // Iterating forward
                System.out.println("Forward iteration:");
                while (listIterator.hasNext()) {
                    System.out.println(listIterator.next());
                }

                // Iterating backward
                System.out.println("Backward iteration:");
                while (listIterator.hasPrevious()) {
                    System.out.println(listIterator.previous());
                }
            }
        }

