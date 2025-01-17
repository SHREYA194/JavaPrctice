package collectionPractice.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * add
 * duplicate add but adds ones only
 * remove
 * iterate
 * with another class
 */

public class LinkedHashSetPractice {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("first");
        linkedHashSet.add("second");
        linkedHashSet.add("third");
        linkedHashSet.add("fourth");
        linkedHashSet.add("second");
        System.out.println("LinkedHashSet :- " + linkedHashSet);

        linkedHashSet.removeIf(a -> a.contains("first"));
        System.out.println("after removing :- " + linkedHashSet);

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        LinkedHashSet<Book> bookLinkedHashSet = new LinkedHashSet<>();
        Book b1 = new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2 = new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3 = new Book(103,"Operating System","Galvin","Wiley",6);
        Book b4 = new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);

        bookLinkedHashSet.add(b1);
        bookLinkedHashSet.add(b2);
        bookLinkedHashSet.add(b3);
        bookLinkedHashSet.add(b4);

        System.out.println(bookLinkedHashSet);

        for (Book b : bookLinkedHashSet) {
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}

class Book {
    int id;
    String name,author,publisher;
    int quantity;
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}
