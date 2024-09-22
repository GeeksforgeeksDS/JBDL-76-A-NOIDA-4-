package CollectionTask;

import java.util.Iterator;
import java.util.Map;

public class Client {

    public static void main(String[] args) {


        //  IStudentDoubt studentDoubt= new ListStudentImpl();
        // IStudentDoubt studentDoubt= new SetStudentsImpl();
        IStudentDoubt studentDoubt= new MapStudentsImpl();

        studentDoubt.saveStudent("amit");
        studentDoubt.saveStudent("shivam");
        studentDoubt.saveStudent("shivam");
        studentDoubt.saveStudent("amit");
        studentDoubt.saveStudent("rohan");
        studentDoubt.saveStudent("punit");
        studentDoubt.saveStudent("ram");
        studentDoubt.saveStudent("ram");
        studentDoubt.saveStudent("ram");
        studentDoubt.saveStudent("ram");
        studentDoubt.saveStudent("ram");
        studentDoubt.saveStudent("shyam");
        studentDoubt.saveStudent("punit");

        //  System.out.println("list of students: "+ studentDoubt.returnListStudent());

        Map<String, Integer> nameFreq = studentDoubt.getNameFreq();
        Iterator<Map.Entry<String, Integer>> iterator = nameFreq.entrySet().iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



        System.out.println("list of students: "+ studentDoubt.getNameFreq());



        System.out.println("total no of students: "+ studentDoubt.noOfStudents());



    }
}
