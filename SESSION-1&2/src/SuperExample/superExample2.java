package SuperExample;

class Car{

    //int model =2008;
    private int model =2008;
    void  res(){
        System.out.println(" car model : "+ model);
       // return model;

    }

}
class Alto extends  Car{
    int model= 2022;
    void display(){

        System.out.println(" car class model : "+ model); //2022
        //System.out.println(" car class model : "+ super.model); //2008--> calling the parent class filed
        super.res();
        System.out.println(" Alto class model : "+ model); //2022
    }
}
public class superExample2 {
    public static void main(String[] args) {

        Alto alto= new Alto();
        alto.display();
    }
}
