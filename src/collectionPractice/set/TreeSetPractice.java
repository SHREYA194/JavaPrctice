package collectionPractice.set;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.*;

/**
 * add
 * descending iterator
 * remove
 * first and last element
 * initial and reverse
 * head subset and tail
 * comparable
 */
public class TreeSetPractice {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("three");
        treeSet.add("four");
        treeSet.add("five");
        treeSet.add("six");

        System.out.println("tree set in asc :- ");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("tree set in desc :- ");
        Iterator iterator1 = treeSet.descendingIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("lowest value :- " + treeSet.pollFirst());
        System.out.println("highest value :- " + treeSet.pollLast());

        System.out.println("initial set :- " + treeSet);
        System.out.println("reverse set :- " + treeSet.descendingSet());
        System.out.println("head set :- " + treeSet.headSet("four", false));
        System.out.println("sub set :- " + treeSet.subSet("six", false, "two", true));
        System.out.println("tail set :- " + treeSet.tailSet("one", false));


        System.out.println("book ex :- ");
        Set<Book1> set = new TreeSet<Book1>();
        //Creating Books
        Book1 b1=new Book1(121,"Let us C","Yashwant Kanetkar","BPB",8);
        Book1 b2=new Book1(233,"Operating System","Galvin","Wiley",6);
        Book1 b3=new Book1(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);

        set.add(b1);
        set.add(b2);
        set.add(b3);
        for (Book1 b : set) {
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}
class Book1 implements Comparable<Book1> {
    int id;
    String name,author,publisher;
    int quantity;

    public Book1(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }


    @Override
    public int compareTo(Book1 b) {
        if (id > b.id)
            return 1;
        else if (id < b.id)
            return -1;
        else
            return 0;
    }
}