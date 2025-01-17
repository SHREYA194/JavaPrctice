package collectionPractice.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * create caching using default capacity of 3
 */

public class LRUCacheLinkedHashMapEx<K, V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LRUCacheLinkedHashMapEx(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMapEx<String, Integer> lruCache = new LRUCacheLinkedHashMapEx<>(3);
        lruCache.put("first", 1);
        lruCache.put("second", 2);
        lruCache.put("third", 3);
        lruCache.get("first");
        lruCache.put("fourth",4);

        System.out.println(lruCache);
    }
}
