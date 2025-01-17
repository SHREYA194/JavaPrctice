package collectionPractice.stack;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

/**
 * push
 * pop
 * peek
 * search
 * iterate through
 * iterator
 * forEach
 * list iterator
 * empty
 */

public class StackPractice {
    public static void main(String[] args) {
        basicStackEx();
    }

    private static void basicStackEx() {
        Stack<Integer> stack = new Stack<>();
        System.out.println("default capacity :- " + stack.capacity());

        stack.push(1);
        stack.push(6);
        stack.push(4);
        stack.push(9);
        stack.push(8);
        stack.push(2);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.search(4));
        System.out.println(stack.size());
        System.out.println(stack.empty());

        System.out.println("\n iterate through iterator :- ");
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n iterate through forEach :- ");
        stack.forEach(n -> System.out.println(n));

        System.out.println("\n iterate through list iterator top to bottom :- ");
        ListIterator listIterator = stack.listIterator(stack.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
