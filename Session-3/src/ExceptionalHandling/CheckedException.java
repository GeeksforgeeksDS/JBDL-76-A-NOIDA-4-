package ExceptionalHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.PriorityQueue;

public class CheckedException {
    public static void main(String[] args) {

      //  PrintStream printStream= new PrintStream("knjn");

        try {

            FileInputStream fileInputStream= new FileInputStream("bac.txt");

        } catch (FileNotFoundException e) {
            System.out.println(" handled here ");
        }


    }
}
