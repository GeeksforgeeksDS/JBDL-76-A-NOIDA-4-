import java.util.concurrent.*;

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("this is task is performed by callable "+Thread.currentThread().getName());


        return "i am in callable task "+ Thread.currentThread().getName();
    }
}

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService service = Executors.newSingleThreadExecutor();

        MyCallable myCallable= new MyCallable();


        service.submit(myCallable);

     //   Future<String> submit = service.submit(myCallable);

//        String res = submit.get();
//
//        System.out.println(" callable returns : "+ res);
        System.out.println("this is main task "+ Thread.currentThread().getName());


    }
}
