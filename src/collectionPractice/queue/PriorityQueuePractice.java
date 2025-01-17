package collectionPractice.queue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * add
 * head
 * element
 * peek
 * iterate
 * remove
 * poll
 * user defined class
 * example
 * min priority queue
 * max priority queue
 */

public class PriorityQueuePractice {
    private static List<Integer> randomNumbers;

    public static void main(String[] args) {

        otherExamples();

        minMaxPriorityQueueExample();
    }

    private static void minMaxPriorityQueueExample() {
        System.out.println("find maximum and minimum 5 elements from 50 random elements example :- ");

        List<Integer> randomNumbers = new Random()
                .ints(50, 0, 100)
                .boxed().collect(Collectors.toList());

        System.out.println("list :- " + randomNumbers);

        PriorityQueue minPriorityQueue = new PriorityQueue();
        PriorityQueue maxPriorityQueue = new PriorityQueue(Collections.reverseOrder());
        int limit = 5;

        for (Integer randomNo : randomNumbers) {
            minPriorityQueue.offer(randomNo);
            maxPriorityQueue.offer(randomNo);
            if (minPriorityQueue.size() > limit || maxPriorityQueue.size() > limit) {
                minPriorityQueue.poll();
                maxPriorityQueue.poll();
            }
            System.out.println("random no :- " + randomNo + " , min priority queue :- "
                    + minPriorityQueue + " , max priority queue :- " + maxPriorityQueue);
        }
    }

    private static void otherExamples() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("one");
        priorityQueue.add("two");
        priorityQueue.add("three");
        priorityQueue.add("four");
        priorityQueue.add("five");
        System.out.println("queue :- " + priorityQueue);

        System.out.println("head by element method :- " + priorityQueue.element());
        System.out.println("head by peek method :- " + priorityQueue.peek());

        Iterator<String> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        priorityQueue.remove();
        priorityQueue.poll();

        System.out.println("after removing :- " + priorityQueue);

        priorityQueue.clear();
        System.out.println("after clear :- " + priorityQueue);


        System.out.println("\n\n ordering ex :- ");
        PriorityQueue<Integer> queueP = new PriorityQueue<>();
        queueP.add(15);
        queueP.add(10);
        queueP.add(30);
        queueP.add(5);
        System.out.println(queueP);

        while (!queueP.isEmpty()) {
            System.out.println(queueP.poll());
        }
        System.out.println("\n\n");


        Queue<Book2> queue = new PriorityQueue<Book2>();
        Book2 b1 = new Book2(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book2 b2 = new Book2(233, "Operating System", "Galvin", "Wiley", 6);
        Book2 b3 = new Book2(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);

        queue.add(b1);
        queue.add(b2);
        queue.add(b3);

        System.out.println("queue :- ");
        for (Book2 book2 : queue) {
            System.out.println(book2.id + " " + book2.name + " " + book2.author + " " + book2.publisher + " " + book2.quantity);
        }

        queue.poll();
        System.out.println("after poll :- ");
        for (Book2 book2 : queue) {
            System.out.println(book2.id + " " + book2.name + " " + book2.author + " " + book2.publisher + " " + book2.quantity);
        }
    }
}

class Book2 implements Comparable<Book2> {
    int id;
    String name, author, publisher;
    int quantity;
    // Constructor to initialize Book object
    public Book2(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Book2 b) {
        if (id > b.id) {
            return 1;
        } else if (id < b.id) {
            return -1;
        } else {
            return 0;
        }
    }
}
