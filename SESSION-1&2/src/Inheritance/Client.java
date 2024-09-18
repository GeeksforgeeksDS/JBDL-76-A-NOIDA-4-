package Inheritance;

public class Client {
    public static void main(String[] args) {


        Vehicle vechile= new Vehicle();
        vechile.m1();

        System.out.println("--------------");
        Bike bike= new Bike();
        bike.m1();
        bike.m2();

        System.out.println("------------");

        Vehicle vechile1= new Bike();
        vechile1.m1();
       // vechile1.m2();





    }
}
