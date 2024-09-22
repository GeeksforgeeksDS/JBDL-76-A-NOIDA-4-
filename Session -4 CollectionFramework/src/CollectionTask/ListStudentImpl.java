package CollectionTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListStudentImpl implements IStudentDoubt {

    List<String> students;

    //lazy
    public ListStudentImpl() {
        students= new ArrayList<>();
        students= new LinkedList<>();
    }

    @Override
    public void saveStudent(String name) {
        students.add(name);
    }

    @Override
    public List<String> returnListStudent() {
        return students;
    }

    @Override
    public int noOfStudents() {
        return students.size();
    }
}
