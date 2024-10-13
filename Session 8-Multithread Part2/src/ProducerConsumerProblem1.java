class SharedResource1 {

    private int data;
    public boolean isData = false;

    // Producer produces data
    public synchronized void producer(int value) {
        data = value;
        isData = true;
        System.out.println("Produced: " + data + " executed by: " + Thread.currentThread().getName());
    }

    // Consumer consumes data
    public synchronized int consumer() {
        System.out.println("Consumer: " + data + " executed by: " + Thread.currentThread().getName());
        isData = false;
        return data;
    }
}

class Producer1 implements Runnable {
    private SharedResource1 resource;

    public Producer1(SharedResource1 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.producer(i);
        }
    }
}

class Consumer1 implements Runnable {
    private SharedResource1 resource;
    public Consumer1(SharedResource1 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = resource.consumer();
        }
    }
}

public class ProducerConsumerProblem1 {
    public static void main(String[] args) {
        SharedResource1 sharedResource = new SharedResource1();
        Thread thread1 = new Thread(new Producer1(sharedResource));
        Thread thread2 = new Thread(new Consumer1(sharedResource));

        thread1.start();
        thread2.start();
    }
}
