package collectionPractice;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Collection addAll method used for normal elements add
 * also used for another collection
 * max()
 * min()
 * list
 * set
 * concurrent linked queue
 * retain all
 */

public class CollectionBasic {
    public static void main(String[] args) {
        listEx();
        setEx();
        concurrentLinkedQueueEx();
    }
    private static void concurrentLinkedQueueEx() {
        System.out.println("\n\n ConcurrentLikedQueue ex :- ");

        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
         Set<Integer> set = new HashSet<>();
          for (int i = 1; i < 11; i++) {
            int j = i *5;
            set.add(j);
          }
        System.out.println(set);
          for (int i=1;i<21;i++){
            concurrentLinkedQueue.add(i);
         }
        System.out.println(concurrentLinkedQueue);
        concurrentLinkedQueue.retainAll(set);
        System.out.println(concurrentLinkedQueue);
    }

    private static void setEx() {
        System.out.println("\n\n Set ex :- ");
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(5);
        set.add(8);
        System.out.println(set);

        Collections.addAll(set, 11, 12,13,15);
        System.out.println(set);

        System.out.println(set.size());
        System.out.println(set.contains(5));
        set.clear();
        System.out.println(set);
    }

    private static void listEx() {
        List<String> exList = new ArrayList<String>();
        exList.add("gujarati");
        exList.add("hindi");

        System.out.println("List :- " + exList);

        Collections.addAll(exList, "english", "punjabi");

        System.out.println("after adding elements in list :- " + exList);

        String[] strArr = {"C", "java", "python"};

        Collections.addAll(exList, strArr);

        System.out.println("after adding array in list :- " + exList);


        // max() method
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(5);
        integerList.add(9);
        integerList.add(3);
        integerList.add(4);

        System.out.println("\n max :- " + Collections.max(integerList));

        System.out.println("\n min :- " + Collections.min(integerList));
    }
}