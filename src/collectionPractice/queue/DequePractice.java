package collectionPractice.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * add
 * pop
 * remove
 * iterate
 * add first
 * add last
 * remove last
 * size
 */

public class DequePractice {
    public static void main(String[] args) {
        basicDequeEx();
    }

    private static void basicDequeEx() {
        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println(deque.size());
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.add(6);
        System.out.println(deque);
        deque.pop();
        System.out.println(deque);
        deque.remove();
        System.out.println(deque);
        deque.remove(5);
        deque.removeLast();
        System.out.println(deque);
        System.out.println(deque.size());

    }
}
