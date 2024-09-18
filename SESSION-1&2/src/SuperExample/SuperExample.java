package SuperExample;


class Parent{

    int age;

    public  Parent(){
        super();
     //   this(3);
        System.out.println(" parent class default const");
    }

    public Parent(int age) {
        this();
        System.out.println("this parent class param const.");
        this.age = age;
    }
}

class Child extends Parent{
    public Child() {
        super(4);
        System.out.println(" this is child class default constructor ");
    }
}
class Child2 extends Child{
    public Child2() {
        System.out.println("child 2");
    }
}

public class SuperExample {
    public static void main(String[] args) {

        Child child= new Child();

    }
}
