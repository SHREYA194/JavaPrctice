package collectionPractice.map;

import java.util.HashMap;
import java.util.Objects;

/**
 * put, putIfAbsent, putAll
 * get or default
 * remove
 * replace
 * iterate
 * replace all
 * contains key value
 * null allows
 * clear
 *
 * user defined
 * equals and hashcode
 */

public class HashMapPractice {
    public static void main(String[] args) {
        basicHashMap();
        equalsHashCodeEx();
        multiThreadEx();
    }

    private static void multiThreadEx() {
        HashMap<Integer, String> map = new HashMap<>();
        Thread thread1 = new Thread(() -> {
            for (int i=0; i<1000; i++) {
                map.put(i, "thred 1");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i=1000; i<2000; i++) {
                map.put(i, "thread 2");
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("map size :- " + map.size());
    }

    private static void basicHashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "first");
        hashMap.put(2, "second");
        hashMap.put(5, "fifth");
        hashMap.put(3, "third");
        hashMap.put(4, "fourth");
        System.out.println(hashMap);

        hashMap.putIfAbsent(6, "sixth");
        hashMap.putIfAbsent(4, "fourth");
        System.out.println(hashMap);

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(10, "tenth");
        hm.put(11, "eleventh");
        System.out.println(hm);
        System.out.println(hm.getOrDefault(12, "twelve"));

        hashMap.putAll(hm);
        System.out.println(hashMap);

        hashMap.remove(5);
        System.out.println(hashMap);

        hashMap.remove(10, "tenth");
        hashMap.remove(11, "tenth");
        System.out.println(hashMap);

        hashMap.replace(3, "three");
        hashMap.replace(2, "second", "two");
        System.out.println(hashMap);

        System.out.println("\n iterate map :- ");
        hashMap.entrySet().stream().forEach(System.out::println);

        System.out.println("\n replace all :- ");
        hashMap.replaceAll((k,v) -> "final string");
        System.out.println(hashMap);

        System.out.println("\n contains :- ");
        System.out.println(hashMap.containsKey(3));
        System.out.println(hashMap.containsValue("final string"));

        hashMap.clear();
        System.out.println(hashMap);
    }

    private static void equalsHashCodeEx() {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("one", 1);
        Person p2 = new Person("two", 2);
        Person p3 = new Person("one", 1);

        map.put(p1, "first");
        map.put(p2, "second");
        map.put(p3, "third");

        System.out.println(map);

        System.out.println("size :- " + map.size());
        System.out.println("get one :- " + map.get(p1));
        System.out.println("get third :- " + map.get(p3));
    }
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
