package collectionPractice.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * add
 * add all
 * add first
 * add last
 * remove by object
 * remove by index
 * remove first
 * remove first and last occurence
 * clear
 * reverse traversal
 *
 * implement
 */

public class LinkedListPractice {
    public static void main(String[] args) {
        basicLinkedListFunEx();
        implementSinglyLinkedList();
    }

    private static void basicLinkedListFunEx() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        linkedList.add("five");
        linkedList.add("six");
        linkedList.add("seven");
        linkedList.add("eight");
        linkedList.add("five");
        linkedList.add("five");
        linkedList.add("six");
        System.out.println("linked list :- " + linkedList);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("arr1");
        arrayList.add("arr2");

        linkedList.addAll(arrayList);
        System.out.println("after adding through addAll Collection :- " + linkedList);

        linkedList.addFirst("four");
        linkedList.addLast("ten");
        System.out.println("after add first and last :- " + linkedList);

        linkedList.remove();
        linkedList.remove("three");
        linkedList.remove(3);
        System.out.println("after removes :- " + linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("after remove first and last :- " + linkedList);

        linkedList.removeFirstOccurrence("six");
        linkedList.removeLastOccurrence("five");
        System.out.println("after remove first and last occurrence :- " + linkedList);

        System.out.println("iterate in descending order :- ");
        Iterator iterator = linkedList.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void implementSinglyLinkedList() {
        Node n1 = new Node();
        Node n2 = new Node();
        n1.value = 1;
        n1.next = n2;
        n2.value = 2;
        n2.next = null;
    }
}

class Node {
    public int value;
    public Node next;
}