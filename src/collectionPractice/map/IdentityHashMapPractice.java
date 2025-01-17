package collectionPractice.map;

import java.util.IdentityHashMap;

/**
 * identity hash code
 * == instead of equals
 */

public class IdentityHashMapPractice {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> integerIdentityHashMap = new IdentityHashMap<>();
        integerIdentityHashMap.put(new String("key"), 1);
        integerIdentityHashMap.put(new String("key"), 2);
        integerIdentityHashMap.put("keySame", 3);
        integerIdentityHashMap.put("keySame", 4);
        System.out.println(integerIdentityHashMap);
    }
}
