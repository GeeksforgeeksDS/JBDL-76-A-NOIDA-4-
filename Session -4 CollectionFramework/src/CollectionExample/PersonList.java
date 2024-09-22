package CollectionExample;

import java.util.LinkedList;
import java.util.List;

public class PersonList {

    public static void main(String[] args) {
        List<Person> list= new LinkedList<>();

        list.add(new Person(1,"amit",31));
        list.add(new Person(2,"punit",33));
        list.add(new Person(3,"pankaj",32));
        list.add(new Person(4,"rohan",21));

        System.out.println(list);

        for(Person p:list){
            System.out.println(p);
        }

    }
}
