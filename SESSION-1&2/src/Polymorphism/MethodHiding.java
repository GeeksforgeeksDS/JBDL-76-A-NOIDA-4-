package Polymorphism;

// What is Method Hiding --> this happens only in case of static
class Parent1{
    public static  void m1(){
        System.out.println(" parent class m1 will");
    }

}
class Child1 extends Parent1{


    public static  void m1(){
        System.out.println(" Child class m1 will");
    }
}

public class MethodHiding {
    public static void main(String[] args) {

       Parent1 parent1 = new Child1();
       parent1.m1();// print parent class methods
        Child1.m1();//calling child class static method

    }
}
