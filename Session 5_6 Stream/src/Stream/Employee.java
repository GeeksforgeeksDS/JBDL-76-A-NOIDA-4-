package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    String name;
    int age;
    String company;

    public Employee(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Employee e1= new Employee("xyz",12,"gfg");
        Employee e2= new Employee("qwe",74,"tcs");
        Employee e3= new Employee("edv",24,"infosys");
        Employee e4= new Employee("itf",19,"apple");
        Employee e5= new Employee("hfg",55,"blackrock");
        Employee e6= new Employee("ldj",13,"microsoft");

        List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5, e6);

        List<String> above20 = list.stream()
                .filter(age -> age.getAge() > 20)
                .map(x->x.getName().toUpperCase())
              .collect(Collectors.toList());
        System.out.println(above20);

        //store in employee not in string
        List<Employee> above21 = list.stream()
                .filter(age -> age.getAge() > 20)
                .map(emp-> {
                    emp.setName(emp.getName().toUpperCase());
                    return emp;
                }).collect(Collectors.toList());

        System.out.println(above21);


        System.out.println("age greater the 20 "+ above20);

        List<String> nameUpperCase = list.stream()
                .filter(age -> age.getAge() > 20)
                .map(name->name.getName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("name in uppercase "+ nameUpperCase);


        //Find the Employee with the Highest age:
        Optional<Employee> max = list.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println("High age : "+ max);


        //Group Employees by Company
        Map<String, List<Employee>> collect1 = list.stream()
                .collect(Collectors.groupingBy(Employee::getCompany));
        // .collect(Collectors.groupingBy(employee -> employee.getCompany()));
        System.out.println("employees with company : "+ collect1);




    }
}
