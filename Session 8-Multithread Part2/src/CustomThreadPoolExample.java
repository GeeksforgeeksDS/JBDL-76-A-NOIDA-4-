import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExample {
    public static void main(String[] args) {

        ThreadPoolExecutor executor= new ThreadPoolExecutor(4,6,
                60 , TimeUnit.SECONDS,new LinkedBlockingQueue<>(Integer.MAX_VALUE));

        for (int i = 1; i < 200; i++) {
            int i1=i;
            Runnable runnable= ()->{
                System.out.println("this is task "+i1+ " performed by : "+Thread.currentThread().getName());
            };
            executor.submit(runnable);
        }
        System.out.println("this is main task "+ Thread.currentThread().getName());
    }
}
