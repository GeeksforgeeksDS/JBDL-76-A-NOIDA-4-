package FunctionalInterface;

//sam - single abstract method

@FunctionalInterface
interface FunctionalDemo{
    int calculate(int a , int b);

    default  void prints(){
        System.out.println("default inside the functional interface ");
    }
}

public class FunctionalInterfaceExample  {

    public static void main(String[] args) {


        FunctionalDemo functionalDemo= new FunctionalDemo() {
            @Override
            public int calculate(int a, int b) {
                int res = a+b;
                return res;
            }
        };

        System.out.println(functionalDemo.calculate(34,2));

        //(args)->{body}

        FunctionalDemo add=(int x,int y)->{
            int i = x + y;
            return i;
        };
        System.out.println(add.calculate(12,34));

        FunctionalDemo add1= (x,y)->x+y;

        FunctionalDemo sub=(int x,int y)->{
            int i = x - y;
            return i;
        };
        System.out.println(sub.calculate(63,34));

        FunctionalDemo mul=(int x,int y)->{
            int i = x * y;
            return i;
        };
        System.out.println(mul.calculate(12,34));
        System.out.println("----------------");
        add.prints();



    }


}
