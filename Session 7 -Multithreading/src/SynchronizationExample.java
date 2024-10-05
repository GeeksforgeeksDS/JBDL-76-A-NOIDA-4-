

class Bank{

    private int balance=1000;

   // public static  synchronized void withdraw(int amount){
    public  void withdraw(int amount){

        synchronized (this){

            if(balance>=amount){
                System.out.println(Thread.currentThread().getName()+ " is going to withdraw amount : "+ amount);
                balance-=amount;
                System.out.println(Thread.currentThread().getName()+" is done successfully and left amount is :"+balance);
            }
            else {
                System.out.println(Thread.currentThread().getName()+" insufficient amount ");
            }
        }

//        if(balance>=amount){
//            System.out.println(Thread.currentThread().getName()+ " is going to withdraw amount : "+ amount);
//            balance-=amount;
//            System.out.println(Thread.currentThread().getName()+" is done successfully and left amount is :"+balance);
//        }
//        else {
//            System.out.println(Thread.currentThread().getName()+" insufficient amount ");
//        }

    }

    int getBalance(){
        return balance;
    }


}

public class SynchronizationExample {
    public static void main(String[] args) {


        Bank bank= new Bank();

        Runnable withdraw= ()->{

            for (int i = 0; i < 4; i++) {
                bank.withdraw(200);

                if (bank.getBalance()<0){
                    System.out.println(" overdrawn ");
                }
            }
        } ;

        Thread t1= new Thread(withdraw,"Thread 1");
        Thread t2= new Thread(withdraw,"Thread 2");

        t1.start();
        t2.start();


    }
}
