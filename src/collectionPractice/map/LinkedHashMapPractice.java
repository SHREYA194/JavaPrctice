package collectionPractice.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * put
 * remove
 * user defined
 */

public class LinkedHashMapPractice {
    public static void main(String[] args) {
        basicLinkedHashMapPractice();
    }

    private static void basicLinkedHashMapPractice() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true );
        linkedHashMap.put(1, "one");
        linkedHashMap.put(5, "five");
        linkedHashMap.put(3, "three");
        linkedHashMap.put(8, "eight");
        linkedHashMap.put(10, "ten");
        linkedHashMap.put(7, "seven");
        linkedHashMap.get(3);
        System.out.println(linkedHashMap);

        linkedHashMap.remove(7);
        System.out.println("\n after removal :- " + linkedHashMap);

        System.out.println(linkedHashMap.keySet());
        System.out.println(linkedHashMap.values());
        System.out.println(linkedHashMap.entrySet());


        Map<Integer, Book> bookMap = new LinkedHashMap<>();
        Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3=new Book(103,"Operating System","Galvin","Wiley",6);

        bookMap.put(2,b2);
        bookMap.put(1,b1);
        bookMap.put(3,b3);

        for (Map.Entry<Integer, Book> entry : bookMap.entrySet()) {
            int key=entry.getKey();
            Book b=entry.getValue();
            System.out.println(key+" Details:");
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
