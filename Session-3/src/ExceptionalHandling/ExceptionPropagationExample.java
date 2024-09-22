package ExceptionalHandling;

public class ExceptionPropagationExample {
    public static void main(String[] args) {
        System.out.println("starts");

    try {
        m1();
    }catch (NullPointerException e){
    System.out.println("handled here ");
    }

        System.out.println("end ");

    }
    static  void m1(){
        m2();
    }
    static  void m2(){
        try {
        m3();

        }
        catch (ArithmeticException ee){
        System.out.println("handled :"+ ee.getMessage());
        }
    }
    static  void m3(){
        m4();
    }
    static  void m4() {
        System.out.println(100/0);
    }
}
