package collectionPractice.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * with producer consumer ex
 */

public class SynchronousQueuePractice {
    public static void main(String[] args) {
        producerConsumerEx();
    }

    private static void producerConsumerEx() {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("producer waiting to transfer...");
                queue.put("hello from producer !");
                System.out.println("producer transferred message.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("producer interrupted");
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("consumer waiting to receive...");
                String msg = queue.take();
                System.out.println("consumer receive :- " + msg);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("consumer interrupted");
            }
        });

        producer.start();
        consumer.start();
    }
}
