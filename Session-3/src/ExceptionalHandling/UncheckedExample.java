package ExceptionalHandling;

public class UncheckedExample {

    public static void main(String[] args) {

        System.out.println(" code starts");
        try{
            //risky code
       // System.out.println(100/0);
            String name=null;
            System.out.println(name.length());

        }catch (NullPointerException e){
           // System.out.println(" exception caught here "+ e.toString());
            System.out.println(" exception caught here "+ e.getMessage());
            //System.out.println(" exception caught here ");
           // e.printStackTrace();

        }
        catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

       // System.out.println(10/0);

        System.out.println(" code executes ");

    }
}
