package gfg.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

     //   ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

       BeanFactory context = new ClassPathXmlApplicationContext("beans.xml");
        Traveler traveler = (Traveler) context.getBean("traveler");
        traveler.travel();


    }
}
