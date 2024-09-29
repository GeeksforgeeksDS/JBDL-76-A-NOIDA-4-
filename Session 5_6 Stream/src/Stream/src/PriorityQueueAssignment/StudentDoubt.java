package Stream.src.PriorityQueueAssignment;

public class StudentDoubt {
    String name;
    Integer noOfDoubt;

    public StudentDoubt(){

    };

    public StudentDoubt(String name, Integer noOfDoubt) {
        this.name = name;
        this.noOfDoubt = noOfDoubt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfDoubt() {
        return noOfDoubt;
    }

    public void setNoOfDoubt(Integer noOfDoubt) {
        this.noOfDoubt = noOfDoubt;
    }

    @Override
    public String toString() {
        return "StudentDoubt{" +
                "name='" + name + '\'' +
                ", noOfDoubt=" + noOfDoubt +
                '}';
    }

}
