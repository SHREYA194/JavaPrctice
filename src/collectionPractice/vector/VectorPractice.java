package collectionPractice.vector;

import java.util.ArrayList;
import java.util.Vector;

/**
 * default capacity
 * add
 * iterator
 * capacity
 * index of
 * remove
 * remove element
 * hashcode
 * get
 */

public class VectorPractice {
    public static void main(String[] args) {
        basicVector();
        withCapacity();
        removeEx();
        withThreadEx();
    }

    private static void withThreadEx() {
//        ArrayList<Integer> elements = new ArrayList<>();
        Vector<Integer> elements = new Vector<>();

        Thread t1 = new Thread(() -> {
           for (int i=0; i<1000; i++) {
               elements.add(i);
           }
        });
        Thread t2 = new Thread(() -> {
           for (int i=0; i<1000; i++) {
               elements.add(i);
           }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size of collection :- " + elements.size());
    }


    private static void removeEx() {
        Vector<Integer> in = new Vector<>();
        in.add(100);
        in.add(200);
        in.add(300);
        in.add(200);
        in.add(400);
        in.add(500);
        in.add(600);
        in.add(700);

        System.out.println(in);
        System.out.println(in.remove(1));
        System.out.println(in);

        System.out.println(in.removeElement(500));
        System.out.println(in);

        System.out.println(in.hashCode());
        System.out.println(in.get(4));
    }

    private static void withCapacity() {
        Vector<String> vector = new Vector<>(4);
        System.out.println("\n capacity :- " + vector.capacity());
        vector.add("first");
        vector.add("second");
        vector.add("third");
        System.out.println(vector);
        vector.add("fourth");
        vector.add("fifth");
        vector.add("sixth");
        System.out.println("\n capacity :- " + vector.capacity());
        System.out.println(vector);
        System.out.println(vector.indexOf("fourth"));
    }

    private static void basicVector() {
        Vector<String> vector = new Vector<>();
        System.out.println("default capacity :- " + vector.capacity());
        vector.add("one");
        vector.add("two");
        vector.add("three");
        System.out.println("size :- " + vector.size() + " , capacity :- " + vector.capacity());
        System.out.println(vector);


    }
}
