package collectionPractice.set;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;

/**
 * hash set internal working
 */

public class HashSet<E> extends AbstractSet<E> {
    private transient HashMap<E, Object> map;

    private static final Object PRESENT = new Object();

    public HashSet() {
        map = new HashMap<>();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
