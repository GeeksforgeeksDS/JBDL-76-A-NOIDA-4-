
public class Main {

    int id;// instance var

    static  String  name; // class var/ static var
    public Main(){

    }

    void m1(){

        int id;//local var
        System.out.println(" m1 is called ");
    }
    public static void main(String[] args) {

        Main main1=  new Main();

        System.out.print("Hello and welcome!");
    }
}