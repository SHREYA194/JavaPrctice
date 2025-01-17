package collectionPractice.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * add
 * offer
 * offer first
 * offer last
 * poll
 * poll first
 * poll last
 * iterate
 * user defined type
 */

public class ArrayDequePractice {
    public static void main(String[] args) {
        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("one");
        arrayDeque.add("two");
        arrayDeque.offer("three");
        arrayDeque.offerFirst("four");
        arrayDeque.offerLast("five");

        System.out.println("array deque :- " + arrayDeque);

        arrayDeque.poll();
        System.out.println("after poll :- " + arrayDeque);

        arrayDeque.pollFirst();
        System.out.println("after poll first :- " + arrayDeque);

        arrayDeque.pollLast();
        System.out.println("after poll last :- " + arrayDeque);

        Iterator<String> iterator = arrayDeque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Deque<Book3> deque = new ArrayDeque<Book3>();
        Book3 b1=new Book3(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book3 b2=new Book3(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book3 b3=new Book3(103,"Operating System","Galvin","Wiley",6);

        deque.add(b1);
        deque.add(b2);
        deque.add(b3);

        for(Book3 b:deque){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}

class Book3 {
    int id;
    String name,author,publisher;
    int quantity;
    public Book3(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}
