package collectionPractice.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

/**
 * unmodifiable map
 */

public class ImmutableMapPractice {
    public static void main(String[] args) {
        basicImmutableMapEx();
    }

    private static void basicImmutableMapEx() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println(map);
        Map<String, Integer> map1 = Collections.unmodifiableMap(map);
        System.out.println(map1);
//        map1.put("three", 3);  // throws UnsupportedOperationException

        Map<String, Integer> map2 = Map.of("three", 3, "four", 4, "five", 5);
//        map2.put("six", 6);  // throws UnsupportedOperationException
        System.out.println(map2);

        Map<String, Integer> map3 = Map.ofEntries(Map.entry("seven", 7), Map.entry("eight", 8));
        System.out.println(map3);
    }
}
