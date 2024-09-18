package Encapsulation;

public class Person {
    private  int id;
    private String name;
    private String address;

    public Person() {
    }

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    void display(){
        System.out.println("name is "+ name +" with version is "+ id
        +" owned by "+ address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id>=10){
            this.id=20;
        }
        else {
            this.id=id ;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

