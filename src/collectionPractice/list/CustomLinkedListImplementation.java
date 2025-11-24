package collectionPractice.list;

import java.util.NoSuchElementException;

public class CustomLinkedListImplementation<E> {

    private Node<E> head;
    private int size = 0;

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;

        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Linked list is empty.");
        }

        Node<E> temp = head;
        head = head.next;
        size--;

        return temp.value;
    }

    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException("Linked list is empty.");
        }

        if (size == 1) {
            head = head.next;
//            return ;
        }

        Node<E> temp = head;
        Node<E> prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        size--;

        return temp.value;
    }

    public boolean remove(E element) {
        // TODO

        if (head == null) {
            return false;
        }

        if (head.value.equals(element)) {
            head = head.next;
            return true;
        }

        Node<E> temp = head.next;
        Node<E> prev = head;

        while (temp != null) {
            if (temp.value.equals(element)) {
                prev.next = temp.next;
                temp.next = null;

                return true;
            }
            prev = temp;
            temp = temp.next;
        }

        return false;
    }

    public E set(int index, E element) {
        int i=0;

        if (head == null) {
            return null;
        }

        Node<E> temp = head;
        while (i < index) {
            temp = temp.next;
            i++;
        }

        E oldVal = temp.value;
        temp.value = element;

        return oldVal;
    }

    public E getHead() {
        return head.value;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
