package collectionPractice.list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * add
 * iterator to traverse list sequentially
 * capacity
 * removing elements during iteration
 * trim to size
 * for-each loop
 * get() and set()
 * list iterator
 * for loop
 * foreach remaining
 * user-defined class
 * serialization and deserialization
 * add all with index
 * remove
 * retain all
 * isEmpty
 * size and capacity
 * ensureCapacity(int minCapacity) - ArrayList instance has at least a specified number of elements
 *
 * interger remove example
 * contains
 * to array
 * sort
 */

public class ArrayListPractice {
    public static void main(String[] args) throws Exception {
//        basicArraListEx();
        integerRemoveEx();
    }

    private static void integerRemoveEx() {
        System.out.println("\n\n Interger remove example:- ");

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(5);

        System.out.println(arrayList);

        arrayList.remove(2);
        System.out.println(arrayList);

        arrayList.remove(Integer.valueOf(5));
        System.out.println(arrayList);

        System.out.println(arrayList.contains(4));

        Object[] array = arrayList.toArray();
        Integer[] array1 = arrayList.toArray(new Integer[0]);

        for (Integer a : array1) {
            System.out.println(a);
        }

        System.out.println("\n sort :- ");
        Collections.sort(arrayList);
        System.out.println(arrayList);

        List<String> list = Arrays.asList("banana","apple","date");
        list.sort(null);
        System.out.println(list);

    }

    private static void basicArraListEx() throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");
        arrayList.add("fourth");
        arrayList.add("five");

        System.out.println("Iterator :- ");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        arrayList.add(3, "three");
        arrayList.set(3, "four");

        System.out.println("\n for-each :- ");
        for (String a : arrayList) {
            System.out.println(a);
        }

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(arrayList);
        System.out.println("capacity using reflection = " + elementData.length);

        arrayList.trimToSize();
        Object[] elementData1 = (Object[]) field.get(arrayList);
        System.out.println("after trim to size capacity using reflection = " + elementData1.length);


        System.out.println("\n get and set :- ");
        System.out.println(arrayList.get(0));
        arrayList.set(0, "nine");
        System.out.println(arrayList.get(0));

        System.out.println("\n list iterator :- ");
        ListIterator<String> listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        System.out.println("\n for loop :- ");
        for (int i=0; i<arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("\n forEachRemaining method :- ");
        Iterator<String> iterator1 = arrayList.iterator();
        iterator1.forEachRemaining(a -> {
            System.out.println(a);
        });

        System.out.println("\n user-defied class objects in arraylist :- ");
        Student s1 = new Student(1, "first student");
        Student s2 = new Student(2, "second student");
        Student s3 = new Student(3, "third student");
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.forEach(System.out::println);

        System.out.println("\n serialization and deserialization :- ");
        ArrayList<String> serDesArrayList1 = new ArrayList<>();
        serDesArrayList1.add("first ele");
        serDesArrayList1.add("second ele");
        serDesArrayList1.add("third ele");
        try {
            // serialization
            FileOutputStream fileOutputStream = new FileOutputStream("file");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serDesArrayList1);
            objectOutputStream.close();
            fileOutputStream.close();

            // deserialization
            FileInputStream fileInputStream = new FileInputStream("file");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<String> desserArrayList1 = (ArrayList<String>) objectInputStream.readObject();
            System.out.println(desserArrayList1);
            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n addAll(Collection<? extends E> c) and with index addAll(int index, Collection<? extends E> c) :- ");
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("one");
        arrayList1.add("two");
        System.out.println("arrayList1 :- " + arrayList1);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("three");
        arrayList2.add("four");
        System.out.println("arrayList2 :- " + arrayList2);
        arrayList1.addAll(arrayList2);
        System.out.println("after add all :- " + arrayList1);
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("five");
        arrayList3.add("six");
        arrayList1.addAll(2, arrayList3);
        System.out.println("after indexed add all :- " + arrayList1);

        System.out.println("\n remove element :- ");
        ArrayList<String> intArrayList = new ArrayList<String>();
        intArrayList.add("check1");
        intArrayList.add("check2");
        intArrayList.add("check3");
        intArrayList.add("check4");
        intArrayList.add("check5");
        intArrayList.add("check6");
        System.out.println("int arraylist :- " + intArrayList);
        intArrayList.remove("check2");
        System.out.println("after remove object :- " + intArrayList);
        intArrayList.remove(3);
        System.out.println("after remove from index :- " + intArrayList);
        ArrayList<String> removeAList = new ArrayList<>();
        removeAList.add("check4");
        removeAList.add("check6");
        intArrayList.removeAll(removeAList);
        System.out.println("after remove with collection :- " + intArrayList);
        intArrayList.removeIf(a -> a.contains("check5"));
        System.out.println("after remove if :- " + intArrayList);
        intArrayList.clear();
        System.out.println("after clear :- " + intArrayList);

        System.out.println("\n retain all :- ");
        ArrayList<String> listOne = new ArrayList<>();
        listOne.add("test1");
        listOne.add("test2");
        listOne.add("test3");
        listOne.add("test4");
        listOne.add("test5");
        System.out.println("list one :- " + listOne);
        ArrayList<String> listTwo = new ArrayList<>();
        listTwo.add("test3");
        listTwo.add("test5");
        listTwo.add("test6");
        listTwo.add("test7");
        System.out.println("list two :- " + listTwo);
        listOne.retainAll(listTwo);
        System.out.println("after retain :- " + listOne);

        System.out.println("\n isEmpty() :- ");
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        System.out.println("check list is empty :- " + integerArrayList.isEmpty());
        integerArrayList.add(1);
        System.out.println("check list is empty after insertion :- " + integerArrayList.isEmpty());

        System.out.println("\n size and capacity :- ");
        ArrayList<String> list = new ArrayList<>();
        System.out.println("list size :- " + list.size() + " , capacity :- 0");
        ArrayList<String> list1 = new ArrayList<>(20);
        System.out.println("list1 size :- " + list1.size() + " , capacity :- 20");
    }


}

// user-defined class
class Student {
    int rollNo;
    String name;

    Student (int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String toString() {
        return "Roll No :- " + this.rollNo + " , Name :- " + this.name;
    }
}
