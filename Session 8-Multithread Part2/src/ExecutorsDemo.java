import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class  GeneralTask implements Runnable{
    @Override
    public void run() {
        System.out.println("this is a task performed by : "+Thread.currentThread().getName());

    }
}


public class ExecutorsDemo {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service1 = Executors.newFixedThreadPool(4);
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        ExecutorService service3 = Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(3);




        GeneralTask task= new GeneralTask();

//        for (int i = 0; i <20 ; i++) {
//       // service1.submit(task);
//        //service2.submit(task);
//       // service3.submit(task);
//        }
        //service2.shutdown();

        Runnable runnable= ()->{
            System.out.println("this simple task "+Thread.currentThread().getName());
        };
        service2.submit(runnable);


        service2.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("this is a main task executed by : "+ Thread.currentThread().getName());



    }
}
