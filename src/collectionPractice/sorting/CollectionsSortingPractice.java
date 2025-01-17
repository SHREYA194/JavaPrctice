package collectionPractice.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * sort method
 * String objets
 * Wrapper Class
 * User defined  -> need to implement with Comparable
 * reverse order
 */

public class CollectionsSortingPractice {
    public static void main(String[] args) {
        stringSortEx();
        wrapperSortEx();
        userDefinedSortEx();
    }

    private static void userDefinedSortEx() {
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student("Viru"));
        al.add(new Student("Saurav"));
        al.add(new Student("Mukesh"));
        al.add(new Student("Tahir"));

        System.out.println("\n student :- ");
        al.stream().map(s -> s.name).forEach(System.out::println);

        Collections.sort(al);
        System.out.println("\n after sorting :- ");
        al.stream().map(s -> s.name).forEach(System.out::println);

        Collections.sort(al, Collections.reverseOrder());
        System.out.println("\n after reverse sorting :- ");
        al.stream().map(s -> s.name).forEach(System.out::println);
    }

    private static void wrapperSortEx() {
        ArrayList<Integer> al=new ArrayList<>();
        al.add(Integer.valueOf(201));
        al.add(Integer.valueOf(101));
        al.add(230);//internally will be converted into objects as Integer.valueOf(230)

        Collections.sort(al);
        System.out.println(al);
        Collections.sort(al, Collections.reverseOrder());
        System.out.println(al);
    }

    private static void stringSortEx() {
        ArrayList<String> al=new ArrayList<String>();
        al.add("Viru");
        al.add("Saurav");
        al.add("Mukesh");
        al.add("Tahir");

        Collections.sort(al);
        System.out.println(al);
        Collections.sort(al, Collections.reverseOrder());
        System.out.println(al);
    }
}

class Student implements Comparable<Student> {
    String name;
    Student(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
