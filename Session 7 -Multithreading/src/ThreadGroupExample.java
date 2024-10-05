public class ThreadGroupExample {
    public static void main(String[] args) {


        ThreadGroup group= new ThreadGroup("myThread");


        Thread thread1 = new Thread(group,()->{
            System.out.println(" this is using the runnable interface "+Thread.currentThread());
        });

        Thread thread2 = new Thread(group,()->{
            System.out.println(" this is using the runnable interface "+Thread.currentThread());
        });

        thread2.start();
        thread1.start();

        System.out.println("main thread : "+ Thread.currentThread());

        group.activeCount();
        System.out.println(group.activeCount());



    }
}
