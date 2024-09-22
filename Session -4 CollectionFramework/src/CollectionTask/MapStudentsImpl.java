package CollectionTask;

import java.util.*;

public class MapStudentsImpl implements IStudentDoubt {

    public Map<String ,Integer> students;

    public MapStudentsImpl() {

        students= new HashMap<>();
//        students= new LinkedHashMap<>();
//        students= new TreeMap<>();

    }

    @Override
    public void saveStudent(String name) {

        if(students.containsKey(name)){
            Integer countFreq = students.get(name);
            students.put(name,countFreq+1);
        }
        //for first time user
        else
            students.put(name,1);

    }

    @Override
    public List<String> returnListStudent() {
        return null;
    }

    @Override
    public int noOfStudents() {
        return students.size();
    }

    @Override
    public Map<String, Integer> getNameFreq() {
        return students;
    }
}
