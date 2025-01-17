package collectionPractice.map;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * put
 * iteration
 * compute if absent
 * contains value
 * equals and hashCode methods
 * compute if present
 * compute
 * contains key
 * contains
 * contains value
 * enumeration
 * entry set
 * for each
 * clear
 * thread
 */

public class ConcurrentHashMapPractice {
    public static void main(String[] args) {
        basicConHashMapEx();
        threadEx();
    }

    private static void threadEx() {
        ConcurrentSkipListMap<Integer,String > map = new ConcurrentSkipListMap<>();
    }

    private static void basicConHashMapEx() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("one", 1);
        concurrentHashMap.put("two", 2);
        concurrentHashMap.put("three", 3);
        concurrentHashMap.put("four", 4);
        System.out.println(concurrentHashMap);

        concurrentHashMap.computeIfAbsent("five", k -> 4+1);
        concurrentHashMap.computeIfAbsent("six", a -> 6*1);
        System.out.println(concurrentHashMap);

        System.out.println(concurrentHashMap.containsValue(6));

        ConcurrentHashMap<String, Integer> concurrentHashMap1 = concurrentHashMap;
        concurrentHashMap.put("seven", 7);
        concurrentHashMap.put("eight", 8);
        System.out.println(concurrentHashMap);
        System.out.println(concurrentHashMap1);
        System.out.println(concurrentHashMap1.equals(concurrentHashMap));
        System.out.println(concurrentHashMap.hashCode());
        System.out.println(concurrentHashMap1.hashCode());

        concurrentHashMap.computeIfPresent("four", (k,v) -> v=10);
        System.out.println(concurrentHashMap);

        concurrentHashMap.compute("six", (k,v) -> v+100);
        System.out.println(concurrentHashMap);

        System.out.println(concurrentHashMap.containsKey("three"));

        System.out.println(concurrentHashMap.contains(20));

        System.out.println(concurrentHashMap.containsValue(3));

        System.out.println("\n enumeration :- ");
        Enumeration enumeration = concurrentHashMap.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        System.out.println("\n entry set :- ");
        System.out.println(concurrentHashMap.entrySet());

        System.out.println("\n for each :- ");
        concurrentHashMap.forEach((k,v) -> System.out.println(k + " , " + v));

        System.out.println(concurrentHashMap.getOrDefault("nine", 9));

        concurrentHashMap1.clear();
        System.out.println(concurrentHashMap1);
        System.out.println(concurrentHashMap);

    }
}
