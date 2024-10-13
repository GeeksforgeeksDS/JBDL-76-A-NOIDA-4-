class sharedResource{

    private int data;
    public boolean isData=false;

    public synchronized void producer(int value){

        if (isData==true){// if data is already produced then wait
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        data=value;
        isData= true;
        System.out.println("Produced : " + data+" executed by : "+ Thread.currentThread().getName());
        notify();
    }

    public synchronized int consumer(){

        if (isData==false) { //if data not produce do not consume..i
            // n this case data is not produced then with
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isData=false;
        System.out.println("Consumer : " + data + " executed by : "+ Thread.currentThread().getName());
        notify();
        return data;
    }


}

class Producer implements  Runnable{
    private sharedResource resource;

    public Producer(sharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.producer(i);
        }
    }
}

class Consumer implements  Runnable{
    private sharedResource resource;

    public Consumer(sharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value= resource.consumer();

        }
    }
}
public class ProducerConsumerProblem {
    public static void main(String[] args) {

        sharedResource sharedResource= new sharedResource();
        Thread thread1= new Thread(new Producer(sharedResource));
        Thread thread2= new Thread(new Consumer(sharedResource));

        thread1.start();
        thread2.start();

    }
}

