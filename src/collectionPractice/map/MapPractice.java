package collectionPractice.map;

import java.util.*;

/**
 * ex non-generic - old style
 * generic
 * comparing by key
 * get and contains
 */

public class MapPractice {
    public static void main(String[] args) {
        System.out.println("non-generic map :- ");
        nonGenericMapEx();

        System.out.println("\n generic map :- ");
        genericMapEx();

        System.out.println("\n comparing by key :- ");
        comparingByKeyEx();

        System.out.println("\n get and contains :- ");
        getAndContainsEx();
    }

    private static void getAndContainsEx() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        map.put(4, "four");

        String value = map.get(4);
        if (value != null) {
            System.out.println("value :- " + value);
        } else {
            System.out.println("value not there");
        }

        boolean exists = map.containsKey(2);
        System.out.println("exist record :- " + exists);
    }

    private static void comparingByKeyEx() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        map.put(4, "four");

        System.out.println("asc order :- ");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        System.out.println("\n desc order :- ");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
    }

    private static void genericMapEx() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        map.put(4, "four");

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void nonGenericMapEx() {
        Map map = new HashMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put("3", "three");
        map.put(4, "four");

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
