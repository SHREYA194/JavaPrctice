package collectionPractice.list;

import java.util.Collection;
import java.util.Objects;

public class CustomLL<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    public CustomLL() {
    }

    public CustomLL(E element) {
        addFirst(element);
    }

    public CustomLL(E... elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public CustomLL(Collection<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
    }


    public E head() {
        return head != null ? head.value : null;
    }

    public E tail() {
        return tail != null ? tail.value : null;
    }

    public int size() {
        return size;
    }

    private boolean isProperIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkProperIndex(int index) {
        if (!isProperIndex(index)) {
            throw new IndexOutOfBoundsException("Index is not proper, Index : " + index + " , size : " + size);
        }
    }

    private boolean isProperIndexEle(int index) {
        return index >= 0 && index < size;
    }

    private void checkProperIndexEle(int index) {
        if (!isProperIndexEle(index)) {
            throw new IndexOutOfBoundsException("Index is not proper, Index : " + index + " , size : " + size);
        }
    }

    public E insert(int index, E element) {
        checkProperIndex(index);
        var node = new Node<E>(element);
        if (size == 1) {
            tail.next = node;
            tail = node;

        } else if (index == 0) {
            node.next = head;
            head = node;

            if (size == 0)
                tail = node;

        } else if (index == size - 1) {
            tail.next = node;
            tail = node;

        } else {
            var prev = nodeAt(index-1);
            node.next = prev.next;
            prev.next = node;
        }

        size++;
        return node.value;
    }

    private Node<E> nodeAt(int index) {
        var temp = head;
        for (int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void add(E element) {
        if (size == 0)
            insert(0, element);
        else
            insert(size - 1, element);
    }

    public void addFirst(E element) {
        insert(0, element);
    }

    public void add(int index, E element) {
        insert(index, element);
    }

    public E get(int index) {
        checkProperIndexEle(index);
        if (index == 0) {
            return head.value;
        }
        if (index == size - 1) {
            return tail.value;
        }

        int i = 0;
        var temp = nodeAt(index);
        return temp.value;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E element) {
        var temp = head;

        if (Objects.equals(element, head.value)) {
            return true;
        }
        temp = temp.next;
        while (temp != null) {
            if (Objects.equals(element, temp.value)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public E remove(int index) {
        checkProperIndexEle(index);
        var temp = head;

        if (index == 0) {
            head = head.next;

            if (size == 1)
                tail = null;

        } else {
            var prev = nodeAt(index-1);
            temp = prev.next;
            prev.next = temp.next;

            if (index == size-1) tail = prev;
        }
        E retVal = temp.value;
        temp.value = null;
        temp.next = null;
        size--;
        return retVal;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean remove(E element) {
        Node<E> temp = head;
        Node<E> prev = null;

        while (temp != null) {
            if (Objects.equals(temp.value, element)) {
                if (prev == null) {
                    head = head.next;
                    if (size == 1) tail = null;
                } else {
                    prev.next = temp.next;
                    if (temp.next == null) tail = prev;
                }

                temp.value = null;
                temp.next = null;
                size--;
                return true;
            }

            prev = temp;
            temp = temp.next;
        }

        return false;
    }

    public boolean clear() {
        for (var x = head; x != null; ) {
            var next = x.next;
            x.value = null;
            x.next = null;
            x = next;
        }
        head = tail = null;
        size = 0;
        return true;
    }

    public void printLL() {
        System.out.print("Linked List :- ");
        if (head != null) {
            var temp = head;
            while (temp.next != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println(temp.value);
        }
    }
}
