class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("this is child thread  and executing by: "+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }}
    public class JoinExample {
    public static void main(String[] args) throws InterruptedException {


        MyThread1 myThread2 = new MyThread1();// main thread

        myThread2.start();//maIN

        myThread2.join(5000);// MAIN

        System.out.println(" heelo world ");



        for (int i = 0; i < 5; i++) {
            System.out.println("this is main thread  and executing by: "+Thread.currentThread().getName());
        }
    }
}
