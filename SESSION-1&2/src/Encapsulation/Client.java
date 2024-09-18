package Encapsulation;

public class Client {
    public static void main(String[] args) {

        Person person= new Person();

        person.display();

        person.setId(18);
        person.setName("java 8");
        person.setAddress("amazon");
        System.out.println(person.getAddress());
        System.out.println(person.getId());
        System.out.println(person.getName());

    }
}
