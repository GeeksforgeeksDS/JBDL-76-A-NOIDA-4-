package CollectionTask;

import java.util.List;
import java.util.Map;

public interface IStudentDoubt {

    void saveStudent(String name);

    List<String> returnListStudent();

    int noOfStudents();

   default Map<String,Integer> getNameFreq(){
       return null;
   }


}
