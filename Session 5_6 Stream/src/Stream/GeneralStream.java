package Stream;

import java.util.Arrays;
import java.util.List;

public class GeneralStream {

    /*task:
    * 1-> odd numbers
    * 2-> square the odd
    * 3-> sum of total
    * */
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9,10);

        //iterative approach

        int sum=0;
        for (int i = 0; i <10 ; i++) {
           int curr=  list.get(i);
           if(curr%2==1){//odd value
              int val= curr*curr;
              sum+=val;
           }
        }
        System.out.println("total sum is : "+ sum);


        //declarative approach

        Integer reduce = list.stream().filter(x -> x % 2 == 1)
                .map(x -> x * x)
                .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(reduce);


    }
}
