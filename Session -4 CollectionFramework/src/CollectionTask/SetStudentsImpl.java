package CollectionTask;

import java.util.*;

public class SetStudentsImpl implements IStudentDoubt {

    Set<String> std;

    public SetStudentsImpl() {
        std= new HashSet<>();//order of insertion not maintain
        std= new LinkedHashSet<>();//order of insertion here
        std= new TreeSet<>();//natural order-->sort
        std= new TreeSet<>(Comparator.reverseOrder());

    }


    @Override
    public void saveStudent(String name) {
        std.add(name);
    }

    @Override
    public List<String> returnListStudent() {
        return new ArrayList<>(std);
    }

    @Override
    public int noOfStudents() {
        return std.size();
    }
}
