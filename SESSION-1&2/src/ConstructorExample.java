
class Student {
    int id;//0
    String name;//null

    public Student(){
        this(2,"java17");
        System.out.println(" this default constructor");
    }

    public Student(int id, String name) {
        //this();
        this.id = id;
        this.name = name;
        System.out.println(" param. constr.");
    }
}

public class ConstructorExample {
    public static void main(String[] args) {


        Student student = new Student();

       // Student student1= new Student(2,"java");


    }
}
