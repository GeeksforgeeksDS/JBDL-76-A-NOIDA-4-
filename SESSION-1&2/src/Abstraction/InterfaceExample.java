package Abstraction;

interface Vehicle{

    // by default all method present in interface is Abstract  and public --> METHODS
    // variables--> public,final , static

    int id=8383;

    void getNoWheels();
    public abstract  void colour();


    // after java 8 we can provide the body for any method in interface with static and default
    default void defaultMethod(){
        System.out.println("started ");
    }

    static void staticMethod(){
        System.out.println(" static have body");
    }

}
interface Vehicle2{
    default void defaultMethod(){
        System.out.println("started hh");
    }
}

class child3 implements Vehicle2,Vehicle{

    @Override
    public void getNoWheels() {

    }

    @Override
    public void colour() {

    }


    @Override
    public void defaultMethod() {
        Vehicle2.super.defaultMethod();
    }
}
/*interface v3 extends Vehicle, Vehicle2{

}*/

class Auto implements Vehicle{
    //public abstract class Auto extends Vehicle{ // in-case we do not want to give body to particular method

    final String name1="name";


     String name;

    @Override
    public void getNoWheels() {
        System.out.println(" auto have 3 wheels ");
    }

    @Override
    public void colour() {
        System.out.println("colour is yellow ");
    }

    @Override
    public void defaultMethod() {
        System.out.println(" child class default");
    }


}

class Car extends Auto implements Vehicle, Vehicle2{

    @Override
    public void getNoWheels() {

    }

    @Override
    public void colour() {

    }
}

public class InterfaceExample {
    public static void main(String[] args) {

       Vehicle vehicle=  new Auto();
       vehicle.colour();
       vehicle.getNoWheels();
       vehicle.defaultMethod();
       Vehicle.staticMethod();

     //  vehicle.staticMethod();
       System.out.println(Vehicle.id);



    }
}
