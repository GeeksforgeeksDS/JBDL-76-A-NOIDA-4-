package Abstraction;

abstract class Parent {
    int age;

    // concrete method(which have body/implementation ) due to this abstract class
    // not able to provide the 100% abstraction

    void sleep()
    {
        System.out.println("parent sleep");
    }

    //if any abstract method is present then need to declare the class also as abstract

    abstract void sound();// abstract method
    abstract void eat();// abstract method

}
abstract class Child extends  Parent{

    @Override
    void sound() {
        System.out.println(" child have different sound");
    }

    // eat and sleep both are inherited from parent class

}
class Child2 extends Child{

    @Override
    void eat() {
        System.out.println(" child eats ");
    }
}


public class AbstractClassExample {
    public static void main(String[] args) {


    }
}
