package Polymorphism;

//   upcasting  --> means when child object try to store in parent reference(possible)
// Parent p= new Child();
//it prints the override value of child class because binding happens at run time which child class object
//—---------------------------------------------------
//Down casting --> means when parent class object try to store in child class reference
// 1--> Trying to Down casting Implicitly:  Child c = new Parent(); - > compile time error
//2-->Down casting Explicitly: Child c = (Child)p; or  Cat cat1= (Cat) new Animal();
// Cat cat1= (Cat) new Animal();// this results the class cast exception
        /*
        * You must ensure that the object you are casting (animal) is actually an instance of the
        *  child class (Cat), otherwise a ClassCastException will be thrown.
        *  example:
        * Animal animal1= new Cat();
          Cat cat1=(Cat) animal1
        * */
// co-varient return type = is such type of return type  which present in parent and child relationship

class Animal{

    final String age= null;

    Animal sound(){
        System.out.println(" animal sound ");
        return null;
    }

    public void run(){
        System.out.println(" animal run");
    }

    void sleep(){
        System.out.println(" every animal sleep");
    }

}
class Dog extends  Animal{

    @Override
    Dog  sound(){
        System.out.println(" dog sound");
        return new Dog();
    }
    public void run(){
        System.out.println(" dog runs fast");
    }


    //it is a cat class method
    void eat(){
        System.out.println(" dog eats ");
    }
}

public class Overriding {
    public static void main(String[] args) {

        Animal animal= new Animal();
        animal.run();
        animal.sound();

        System.out.println("---------------");
        Dog dog= new Dog();
        dog.run();
        dog.sound();

        System.out.println("--------------------");


       Animal animal1=  new Dog();//upcasting mean when we create object child class and store in parent reference
       animal1.sound();
       animal1.run();
//      animal1.eat(); -- CE

        // DOWN-CASTING== Child c= new Parent ();//

       //Dog dog1= (Dog) new Animal(); // class cast exception
        System.out.println("--------------------");
        Animal animal2=  new Dog();//upcasting
        Dog dog1= (Dog) animal2;//down-casting
       dog1.sound();
       dog1.eat();
       dog1.run();



    }
}
