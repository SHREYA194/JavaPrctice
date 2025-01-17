package collectionPractice.queue;

import java.util.concurrent.*;

/**
 * array blocking queue
 * producer consumer ex
 * linked blocking queue
 * priority blocking queue
 */

public class BlockingQueuePractice {
    public static void main(String[] args) {
        basicEx();
    }

    private static void basicEx() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> queue2 = new PriorityBlockingQueue<>();
    }
}

class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    private int value  = 0;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Producer produced :- " + value);
                queue.add(value++);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("producer interrupted");
            }
        }
    }
}


class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer consumed :- " + queue.take());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("consumer interrupted");
            }
        }
    }
}