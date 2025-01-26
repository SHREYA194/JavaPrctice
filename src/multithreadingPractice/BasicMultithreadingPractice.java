package multithreadingPractice;

/**
 * Runnable interface
 * Thread class
 * sleep
 */

public class BasicMultithreadingPractice {
    public static void main(String[] args) {
//        basicMultiThreadEx();
//        threadSleepEx();
        threadJoinEx();
    }

    private static void threadJoinEx() {
        ThreadExClass t1 = new ThreadExClass();
        ThreadExClass t2 = new ThreadExClass();
        ThreadExClass t3 = new ThreadExClass();

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        t2.start();
        t3.start();

    }

    private static void threadSleepEx() {
        Thread t1 = new Thread(() -> {
           for (int i=0; i<10; i++) {
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   System.out.println(e);
               }
               System.out.println(i);
           }
        });
        t1.start();
//        t1.start();  // illegal thread exception
    }

    private static void basicMultiThreadEx() {
        MultiThreadClass1 thread1 = new MultiThreadClass1();
        thread1.start();
        System.out.println("outside thread 1");

        System.out.println();
        MultiThreadClass2 threadRunnableClass2 = new MultiThreadClass2();
        Thread thread2 = new Thread(threadRunnableClass2);
        thread2.start();
        while(thread2.isAlive()) {
            System.out.println("Waiting...");
        }
        System.out.println("outside thread 2");
    }
}

class MultiThreadClass1 extends Thread {
    public void run() {
        System.out.println("by thread class");
    }
}

class MultiThreadClass2 implements Runnable {

    @Override
    public void run() {
        System.out.println("by runnable interface");
    }
}

class ThreadExClass extends Thread {
    public void run() {
        for (int i=0; i<2; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
