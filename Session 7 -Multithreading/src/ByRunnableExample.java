
class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
        //System.out.println(" this task "+Thread.currentThread().getName());
        System.out.println(" this task "+Thread.currentThread());

        }
    }

}

public class ByRunnableExample {
    public static void main(String[] args) {

        MyThread2 myThread2= new MyThread2();

        Thread thread1= new Thread(myThread2);
        Thread thread2= new Thread(myThread2);

        thread1.setPriority(10);
//        thread2.setPriority(1);
        thread1.start();
//        thread2.start();

//        System.out.println("Thread 1 priority has "+thread1.getPriority());
//        System.out.println("Thread 2 priority has "+thread2.getPriority());


      // Thread.currentThread().setPriority(1);
        System.out.println("main thread :"+ Thread.currentThread());





    }
}
