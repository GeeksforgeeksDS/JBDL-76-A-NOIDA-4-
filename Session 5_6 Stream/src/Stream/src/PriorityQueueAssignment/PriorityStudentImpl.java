package Stream.src.PriorityQueueAssignment;

import java.util.*;

public class PriorityStudentImpl implements IStudentDoubt {

    Map<String, StudentDoubt> stdMap;
    Queue<StudentDoubt> queue;
    Comparator<StudentDoubt> studentDoubtComparator= new Comparator<StudentDoubt>() {
        @Override
        public int compare(StudentDoubt o1, StudentDoubt o2) {
            return o2.getNoOfDoubt().compareTo(o1.getNoOfDoubt());
        }
    };

    public PriorityStudentImpl(){
        stdMap=new TreeMap<>();
        queue=new PriorityQueue<>(studentDoubtComparator);
    }


    @Override
    public void saveStudent(String name) {

        if(stdMap.containsKey(name)){

            StudentDoubt currentObj = stdMap.get(name);
            queue.remove(currentObj);
            currentObj.noOfDoubt++;
            queue.add(currentObj);
        }
        else {

            // adding first time user
            StudentDoubt studentDoubt= new StudentDoubt(name,1);
            queue.add(studentDoubt);
            stdMap.put(name,studentDoubt);

        }
    }

    @Override
    public List<String> returnListStudent() {
        return null;
    }

    @Override
    public int noOfStudents() {
        return 0;
    }


    @Override
    public Map<String, Integer> getNameFreq() {
        Map<String,Integer> topStds= new LinkedHashMap<>();
        for (int i = 0; i < 4; i++) {
            StudentDoubt poll = queue.poll();
            topStds.put(poll.getName(), poll.getNoOfDoubt());
        }

        return topStds;
}
}
