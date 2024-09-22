package ExceptionalHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class tryWithResource {
    public static void main(String[] args) throws Exception {
        System.out.println(" starts");
       // m1();
      //  m2();

        m3();
    }

   /* static void m1() throws IOException {

        FileInputStream fileInputStream= null;
        try {
            fileInputStream= new FileInputStream("abc");

        } catch (FileNotFoundException e) {
            System.out.println("exception handled here : "+ e.getMessage());
        }
        finally {
            if (fileInputStream!= null){
                fileInputStream.close();
                System.out.println("closed here");
            }
            else {
                System.out.println("resource not found ");
            }
        }
*/
    //    System.out.println("-----------------------------------");

        //try with resource
       /* static void m2()  {

        try ( FileInputStream fileInputStream= new FileInputStream("abc");){

        } catch (IOException e) {
            System.out.println("exception handled here : "+ e.getMessage());
        }
        finally {
            System.out.println("simple final ");
        }
        */

    //--------------------------------------//

    static void m3() throws Exception {

        try(CustomResource customResource= new CustomResource()){
            System.out.println(customResource.g);
        }catch (Exception e){
            System.out.println(" exception caught here ");
        }
        finally {

            System.out.println("code execution stops ");
        }


    }
}

class CustomResource implements AutoCloseable{

    int g=100;

    public CustomResource(){
        System.out.println("resource created ");
    }

    @Override
    public void close() throws Exception {
        System.out.println(" resource closed ");
    }
}
