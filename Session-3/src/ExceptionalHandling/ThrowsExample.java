package ExceptionalHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsExample {
    public static void main(String[] args) throws /*ArithmeticException, */FileNotFoundException {

       // FileInputStream fileInputStream= new FileInputStream(" gfg");

        try {
            m1();
        }catch (Exception e){

        }
        //System.out.println(100/0); //runtime
    }
    static  void m1() throws FileNotFoundException {

        FileInputStream fileInputStream= new
                FileInputStream(" gfg");

    }
}
