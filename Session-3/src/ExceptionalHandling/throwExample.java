package ExceptionalHandling;

class CheckAgeException1 extends RuntimeException {

    public CheckAgeException1(String msg) {
        super(msg);
    }
}

class CheckAgeException2 extends Exception {

    public CheckAgeException2(String msg) {
        super(msg);
    }
}




public class throwExample {

    public static void main(String[] args) {

      //  System.out.println(100/0);
        System.out.println("execution starts  ");
        try {
        checkAge(9);

        }catch (CheckAgeException1 | CheckAgeException2 e){
            System.out.println("exception is handled here : "+ e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("execution end   ");

    }
    //static void checkAge(int age ) throws Exception{
    static void checkAge(int age ) throws CheckAgeException2 {

        if (age<18){
            //unchecked exception
           /* throw  new ArithmeticException("your age is below then 18 so you are not" +
                    " eligible for voting in election");
            */
            //checked exception
            //throw new Exception(" eligible for voting in election");

         //   throw new CheckAgeException1("not eligible for voting in election");

            throw new CheckAgeException2("not eligible for voting in election");
        }
        else {
            System.out.println("you are eligible for voting ");
        }

    }
}
