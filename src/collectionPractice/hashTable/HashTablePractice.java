package collectionPractice.hashTable;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * constructor
 * put
 * null key and value check
 * for each
 * remove
 * get or default
 * put if absent
 * enumeration
 * user defined
 * thread
 */

public class HashTablePractice {
    public static void main(String[] args) {
//        basicHashTable();
        multiThreadEx();
    }

    private static void multiThreadEx() {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        Thread thread1 = new Thread(() -> {
           for (int i=0; i<1000; i++) {
               hashtable.put(i, "thread 1");
           }
        });
        Thread thread2 = new Thread(() -> {
           for (int i=1000; i<2000; i++) {
               hashtable.put(i, "thread 2");
           }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hashtable size :- " + hashtable.size());
    }

    private static void basicHashTable() {
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "one");
        map.put(102, "two");
        map.put(103, "three");

        Hashtable<Integer, String> hashtable = new Hashtable<>(map);
        System.out.println(hashtable);

        hashtable.put(105, "five");
        hashtable.put(104, "four");
//        hashtable.put(null, "ex");  // throws null pointer exception
//        hashtable.put(111, null);  // throws null pointer exception
        System.out.println(hashtable);

        for (Map.Entry entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        hashtable.remove(103);
        System.out.println(hashtable);

        System.out.println(hashtable.get(104));
        System.out.println(hashtable.getOrDefault(104, "not present"));
        System.out.println(hashtable.getOrDefault(103, "not present"));

        hashtable.putIfAbsent(105, "six");
        hashtable.putIfAbsent(103, "three");
        System.out.println(hashtable);

        Enumeration<String> enumeration = hashtable.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        Enumeration<Integer> enumeration1 = hashtable.keys();
        while (enumeration1.hasMoreElements()) {
            Integer key = Integer.valueOf(enumeration1.nextElement());
            System.out.println(key + " : " + hashtable.get(key));
        }
        System.out.println("\n");


        Hashtable<Integer, Book> bookHashtable = new Hashtable<>();
        Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3=new Book(103,"Operating System","Galvin","Wiley",6);

        bookHashtable.put(1,b1);
        bookHashtable.put(2,b2);
        bookHashtable.put(3,b3);

        for (Map.Entry<Integer, Book> entry : bookHashtable.entrySet()) {
            int key = entry.getKey();
            Book value = entry.getValue();

            System.out.println("key :- " + key);
            System.out.println("value :- " + value.id+" "+ value.name+" "+ value.author+" "+ value.publisher+" "+ value.quantity);
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
