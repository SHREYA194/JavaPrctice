package collectionPractice.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * generic
 * java 8
 * lambda
 * nullsFirst
 * nullsLast
 */

public class GenericComparatorSortingPractice {
    public static void main(String[] args) {
        genericComparatorEx();
        java8ComparatorEx();
        nullsFirstLastEx();
    }

    private static void nullsFirstLastEx() {
        System.out.println("\n\n nulls first , last :- ");
        ArrayList<StudentGenericComparator> al=new ArrayList<StudentGenericComparator>();
        al.add(new StudentGenericComparator(101,"Vijay",23));
        al.add(new StudentGenericComparator(106,"Ajay",27));
        al.add(new StudentGenericComparator(105,null,21));
        printStudentGeneric(al);

        System.out.println("\n by name nulls first :- ");
        Comparator<StudentGenericComparator> comparator = Comparator.comparing(StudentGenericComparator::getName, Comparator.nullsFirst(String::compareTo));
        Collections.sort(al, comparator);
        printStudentGeneric(al);

        System.out.println("\n by name nulls last :- ");
        Comparator<StudentGenericComparator> comparator1 = Comparator.comparing(StudentGenericComparator::getName, Comparator.nullsLast(String::compareTo));
        Collections.sort(al, comparator1);
        printStudentGeneric(al);
    }

    private static void java8ComparatorEx() {
        System.out.println("\n\n java8 comparator :- ");
        ArrayList<StudentGenericComparator> al=new ArrayList<StudentGenericComparator>();
        al.add(new StudentGenericComparator(101,"Vijay",23));
        al.add(new StudentGenericComparator(106,"Ajay",27));
        al.add(new StudentGenericComparator(109,"Ajay",28));
        al.add(new StudentGenericComparator(105,"Jai",21));
        printStudentGeneric(al);

        System.out.println("\n sort by name :- ");
        Comparator<StudentGenericComparator> comp = Comparator.comparing(StudentGenericComparator::getName);
        Collections.sort(al, comp);
        printStudentGeneric(al);

        System.out.println("\n sort by age :- ");
        Comparator<StudentGenericComparator> compa = Comparator.comparing(StudentGenericComparator::getAge);
        Collections.sort(al, compa);
        printStudentGeneric(al);

        System.out.println("\n sort by name and then age :- ");
        Comparator<StudentGenericComparator> compb = Comparator.comparing(StudentGenericComparator::getName)
                .thenComparing(StudentGenericComparator::getAge);
        Collections.sort(al, compb);
        printStudentGeneric(al);

        System.out.println("\n sort by lambda :- ");
        al.sort((a, b) -> b.rollno - a.rollno);
        printStudentGeneric(al);
    }

    private static void genericComparatorEx() {
        ArrayList<StudentGenericComparator> al=new ArrayList<StudentGenericComparator>();
        al.add(new StudentGenericComparator(101,"Vijay",23));
        al.add(new StudentGenericComparator(106,"Ajay",27));
        al.add(new StudentGenericComparator(105,"Jai",21));

        System.out.println("Sorting by Name");
        Collections.sort(al, new NameComparatorGeneric());
        printStudentGeneric(al);

        System.out.println("\n Sorting by age");
        Collections.sort(al, new AgeComparatorGeneric());
        printStudentGeneric(al);
    }

    private static void printStudentGeneric(ArrayList<StudentGenericComparator> al) {
        for(StudentGenericComparator st: al){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
    }
}

class StudentGenericComparator {
    int rollno;
    String name;
    int age;
    StudentGenericComparator(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class AgeComparatorGeneric implements Comparator<StudentGenericComparator> {

    @Override
    public int compare(StudentGenericComparator s1, StudentGenericComparator s2) {
        if (s1.age == s2.age)
            return 0;
        else if (s1.age > s2.age)
            return 1;
        else
            return -1;
    }
}

class NameComparatorGeneric implements Comparator<StudentGenericComparator> {

    @Override
    public int compare(StudentGenericComparator s1, StudentGenericComparator s2) {
        return s1.name.compareTo(s2.name);
    }
}
