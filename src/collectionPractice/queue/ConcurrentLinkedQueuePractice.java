package collectionPractice.queue;

import java.util.Spliterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;

/**
 * add
 * offer
 * spliterator - split and iterate the split parts in parallel
 * tryAdvance - if element exists tryAdvance() will perform action
 * forEachRemaining - performs the action for each remaining element
 * user defined
 * remove if - predicate
 * producer consumer ex
 */

public class ConcurrentLinkedQueuePractice {
    public static void main(String[] args) {
        basicConcurrentLinkedQueueEx();
        userDefinedConcurrentLinkedQueueEx();
        removeIfPredicateEx();
        producerCondumerEx();
    }

    private static void producerCondumerEx() {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(() -> {
           while (true) {
                queue.add("task :- " + System.currentTimeMillis());
           }
        });

        Thread consumer = new Thread(() -> {
           while (true) {
               String task = queue.poll();
               System.out.println("processing :- " + task);
           }
        });
        producer.start();
        consumer.start();
    }


    private static void basicConcurrentLinkedQueueEx() {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.add("one");
        concurrentLinkedQueue.add("two");
        concurrentLinkedQueue.offer("three");
        concurrentLinkedQueue.add("four");

        System.out.println(concurrentLinkedQueue);

        System.out.println("\n spliterator :- ");

        System.out.println("\n tryAdvance :- ");
        tryAdvanceEx(concurrentLinkedQueue);

        System.out.println("\n\n forEachRemaining :- ");
        forEachRemainingEx(concurrentLinkedQueue);
    }

    private static void forEachRemainingEx(ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
        Spliterator<String> spliterator = concurrentLinkedQueue.spliterator();
        spliterator.forEachRemaining(
                (n) -> {
                    String up = n.toUpperCase();
                    System.out.println(up);
                }
        );
    }

    private static void tryAdvanceEx(ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
        Spliterator<String> spliterator = concurrentLinkedQueue.spliterator();
        while (spliterator.tryAdvance((n) -> System.out.print(n + " ")));
    }

    private static void userDefinedConcurrentLinkedQueueEx() {
        System.out.println("\n Info :- ");
        ConcurrentLinkedQueue<Information> queue = new ConcurrentLinkedQueue();
        Information val1 = new Information("15cs1029","Reema panda",21);
        Information val2 = new Information("15cs1012","Geetanjali Sharma",21);
        Information val3 = new Information("15cs1011","Himanshu Bhardwaj",21);
        queue.add(val1);
        queue.add(val2);
        queue.add(val3);

        System.out.println("\n tryAdvance :- ");
        tryAdvanceUserDefinedEx(queue);

        System.out.println("\n\n forEachRemaining :- ");
        forEachRemainingUserDefinedEx(queue);
    }

    private static void forEachRemainingUserDefinedEx(ConcurrentLinkedQueue<Information> queue) {
        Spliterator<Information> spliterator = queue.spliterator();
        spliterator.forEachRemaining((n) -> {
            System.out.println(n.rollNo + " " + n.name + " " + n.age);
        });
    }

    private static void tryAdvanceUserDefinedEx(ConcurrentLinkedQueue<Information> queue) {
        Spliterator<Information> spliterator = queue.spliterator();
        while (spliterator.tryAdvance((n) ->
            System.out.println(n.rollNo + " " + n.name + " " + n.age)
        ));
    }

    private static void removeIfPredicateEx() {
        System.out.println("\n\n Remove if example :- ");

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        for (int i=1;i<21;i++) {
            queue.add(i);
        }
        System.out.println(queue);

        Predicate<Integer> pr = a -> (a > 10);
        queue.removeIf(pr);
        System.out.println(queue);


        System.out.println("\n user defined remove if :- ");
        ConcurrentLinkedQueue<IsVoter> queue1 = new ConcurrentLinkedQueue<IsVoter>();
        IsVoter isVoter1 = new IsVoter("Reema",18);
        IsVoter isVoter2 = new IsVoter("Raj",7);
        IsVoter isVoter3 = new IsVoter("Kajol",37);
        IsVoter isVoter4 = new IsVoter("Ravi",47);
        IsVoter isVoter5 = new IsVoter("Varun",17);
        queue1.add(isVoter1);
        queue1.add(isVoter2);
        queue1.add(isVoter3);
        queue1.add(isVoter4);
        queue1.add(isVoter5);

        System.out.println(queue1);

        Predicate<IsVoter> pr1 = (IsVoter it) -> (it.age < 18);
        queue1.removeIf(pr1);
        System.out.println(queue1);
    }
}


class Information {
    String rollNo, name;
    int age;
    public Information(String rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }
}

class IsVoter {
    String name;
    int age;
    public IsVoter(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "Name = " + this.name + "  Age = " + this.age;
    }
}

