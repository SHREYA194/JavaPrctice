package collectionPractice.map;

import java.util.EnumMap;
import java.util.Map;

/**
 * put
 * iterator
 * ordinal
 * user defined
 */

public class EnumMapPractice {

    enum Days {
        Monday, Tuesday, Wednesday, Thursday
    }

    enum Key {
        One, Two, Three
    }

    public static void main(String[] args) {
        basicEnumMap();
    }

    private static void basicEnumMap() {
        EnumMap<Days, String> enumMap = new EnumMap<>(Days.class);
        enumMap.put(Days.Monday, "1");
        enumMap.put(Days.Thursday, "4");
        enumMap.put(Days.Tuesday, "2");
        enumMap.put(Days.Wednesday, "3");

        System.out.println(Days.Monday.ordinal());

        System.out.println(enumMap);

        for (Map.Entry entry : enumMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        EnumMap<Key, Book> enumMap1 = new EnumMap<>(Key.class);
        Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3=new Book(103,"Operating System","Galvin","Wiley",6);

        enumMap1.put(Key.One, b1);
        enumMap1.put(Key.Two, b2);
        enumMap1.put(Key.Three, b3);

        for (Map.Entry<Key, Book> entry : enumMap1.entrySet()) {
            Book b = entry.getValue();
            System.out.println(entry.getKey() + " , " + b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity );
        }
    }
}
