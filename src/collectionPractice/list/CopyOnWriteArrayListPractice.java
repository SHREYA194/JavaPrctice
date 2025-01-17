package collectionPractice.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * add while loop
 * thread
 */

public class CopyOnWriteArrayListPractice {
    public static void main(String[] args) {
        basicCopyOnWriteArrayListEx();
        copyOnWriteArrayListWithThreadEx();
    }

    private static void copyOnWriteArrayListWithThreadEx() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("six");

        Thread readerThread = new Thread(() -> {
           while (true) {
               for (String a : list) {
                   System.out.println("read :- " + a);
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       System.out.println("reader exception :- " + e);
                   }
               }
           }
        });

        Thread writerThread = new Thread(() -> {
           while (true) {
               for (String a : list) {
                   try {
                       Thread.sleep(500);
                       list.add("ten");
                       System.out.println("added ten");

                       Thread.sleep(500);
                       list.remove("two");
                       System.out.println("removed two");

                   } catch (InterruptedException e) {
                       System.out.println("writer exception :- " + e);
                   }
               }
           }

        });

        readerThread.start();
        writerThread.start();

    }

    private static void basicCopyOnWriteArrayListEx() {
//        List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("six");

        for (String s : list) {
            System.out.println(s);
            if (s.equals("four")) {
                list.add("five");  // ConcurrentModificationException  while array list
                System.out.println("added");
            }
        }
        System.out.println(list);
    }
}