package CollectionTask;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//class Employee {
class Employee implements Comparable<Employee>{
    int id;
    String name;
    String company;

    public Employee(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

   @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id,o.id);
       // return this.name.compareTo(o.name);
    }
}

class CompanyCompare implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getCompany().compareTo(o1.getCompany());
    }
}
class NameCompare implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getName().compareTo(o1.getName());
    }
}

public class ComparableExample {
    public static void main(String[] args) {

        //Set<Employee> set= new TreeSet<>();
        //Set<Employee> set= new TreeSet<>(new CompanyCompare());
        Set<Employee> set= new TreeSet<>(new NameCompare());

        set.add(new Employee(102,"ram","tcs"));
        set.add(new Employee(109,"amit","gfg"));
        set.add(new Employee(103,"punit","infosys"));

       // System.out.println(set);
        for (Employee employee:set){
            System.out.println(employee);
        }

    }

}
