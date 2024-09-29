package Stream;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

        Supplier <Integer>supplier= ()->5858585; // specific to Integer
      //  Supplier <?>supplier= ()->5858585;// wild card return type

        System.out.println(supplier.get());


        Supplier<String> supplier1= () -> "hello java ";
        System.out.println(supplier1.get());

    }
}
