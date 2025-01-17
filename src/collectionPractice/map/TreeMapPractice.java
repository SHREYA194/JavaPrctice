package collectionPractice.map;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * put
 * remove
 * descending order
 * head map
 * tail map
 * sub map
 * user defined
 * sorted map
 * navigable map
 */

public class TreeMapPractice {
    public static void main(String[] args) {
        basicTreeMapEx();
        sortedTreeMapEx();
        navigableTreeMapEx();
    }

    private static void navigableTreeMapEx() {
        System.out.println("\n\n navigable map :- ");
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(7, "seven");
        map.put(5, "five");
        System.out.println(map);
        System.out.println(map.lowerEntry(4));
        System.out.println(map.higherKey(5));
        System.out.println(map.ceilingKey(5));
        System.out.println(map.descendingMap());
    }

    private static void sortedTreeMapEx() {
        System.out.println("\n\n sorted map :- ");
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(4, "four");
        map.put(2, "two");
        map.put(8, "eight");
        map.put(5, "five");
        map.put(4, "four");
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap((4)));
        System.out.println(map.tailMap(5));
        System.out.println(map.subMap(3,9));
    }

    private static void basicTreeMapEx() {
        System.out.println("tree map :- ");
        TreeMap<Integer ,String> map=new TreeMap<>();
        map.put(100,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");
        System.out.println(map);

        map.remove(102);
        System.out.println(map);

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println("descendingMap: "+map.descendingMap());
        System.out.println("first key :- " + map.firstKey());
        //Returns key-value pairs whose keys are less than or equal to the specified key.
        System.out.println("headMap: "+map.headMap(102,true));
        //Returns key-value pairs whose keys are greater than or equal to the specified key.
        System.out.println("tailMap: "+map.tailMap(102,true));
        //Returns key-value pairs exists in between the specified key.
        System.out.println("subMap: "+map.subMap(100, false, 102, true));


    }
}
