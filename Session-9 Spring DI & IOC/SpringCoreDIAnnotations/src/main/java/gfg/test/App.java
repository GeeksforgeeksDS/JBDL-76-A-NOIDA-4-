package gfg.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext("gfg.test");
       Traveler traveler = context.getBean(Traveler.class);
       traveler.travel();

       Car car1 = context.getBean(Car.class);
        System.out.println(car1);

        Car car2 = context.getBean(Car.class);
        System.out.println(car2);



    }
}
