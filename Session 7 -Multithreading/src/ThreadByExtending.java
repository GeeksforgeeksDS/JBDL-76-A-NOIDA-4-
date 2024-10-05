
class MyThread extends Thread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("this is child task and executing by: "+Thread.currentThread().getName());
        }
    }

    public void run(int a) {
            System.out.println("this is child task and executing by: "+Thread.currentThread().getName());
    }

//    @Override
//    public synchronized void start() {
//        System.out.println(" overrided start");
//    }

}

public class ThreadByExtending {
    public static void main(String[] args) {

        //1 thread-- main
        MyThread thread1= new MyThread();
        MyThread thread2= new MyThread();
        MyThread thread3= new MyThread();

       thread1.start();

       thread1.setName("shivam");

//        thread2.start();
//        thread3.start();

       // thread1.run();

        //2 - thread 0, main

        for (int i = 0; i < 5; i++) {
            System.out.println("this is main task and executing by: "+Thread.currentThread().getName());
        }

    }
}
