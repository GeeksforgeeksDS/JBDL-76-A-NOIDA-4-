package ExceptionalHandling;

import java.sql.SQLException;

public class FinallyExample {
    public static void main(String[] args)  {

        System.out.println(" before try block ");
       /* try
        {
        System.out.println(" code stats");
            System.out.println(100/0);
            try {
                String name ;

            }catch (Exception e){}


        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
            try {

            }catch (Exception ew){

            }
        }
    finally {

            System.out.println(" finally execute");
        }
        System.out.println(" code stats");


    }*/

    try{
        System.out.println(100/0);
       // System.out.println(" 100/29");

        return;

    }
  //  catch (ArithmeticException |Exception E){
    catch (RuntimeException E){
  //  catch (ArithmeticException | NullPointerException | NumberFormatException E){
        E.printStackTrace();
        System.out.println("after catch ");
        System.exit(0);
    }
    finally{
        System.out.println(" finally executed ");
    }



}}
