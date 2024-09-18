package Polymorphism;

/*
 * while overloading method name should be same and does not depend on
 * return type of method , so we can do change return type
 *
 * */

class Person{

    int id;
    String name;
    String address;

    public Person() {
    }

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public  void work(){
        System.out.println(" Person id performing some work");
    }

    public  String work(String task){
        System.out.println(" Person is  performing some task"+ task);
        return task;
    }

    public  void work(int id ,String task){
        System.out.println(" Person is  performing some task"+ task +" with "+ id );
    }

    public  void work(String task1, String task2){
        System.out.println(" Person is  performing some task"+ task1 +" and "+ task2);
    }
     public  void work(String name1, int age, int id){
        System.out.println(" Person is  performing some task");
    }



}

public class Overloading {
    public static void main(String[] args) {

        Person person= new Person();

        person.work();
        String res= person.work("java coding");
        System.out.println(res);
        person.work("java coding", " development ");
        person.work(2882,"something");
        person.work("shivam", 92,88339);
    }
}
