package collectionPractice.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * non-generic old style
 */

public class ComparatorSortingPractice {
    public static void main(String[] args) {
        comaparatorStudentEx();
    }

    private static void comaparatorStudentEx() {
        ArrayList al=new ArrayList();
        al.add(new StudentComparator(101,"Vijay",23));
        al.add(new StudentComparator(106,"Ajay",27));
        al.add(new StudentComparator(105,"Jai",21));

        System.out.println("Sorting by name :- ");
        Collections.sort(al, new NameComparator());
        printStudentList(al);

        System.out.println("\n Sorting by age :- ");
        Collections.sort(al, new AgeComparator());
        printStudentList(al);
    }

    private static void printStudentList(ArrayList<StudentComparator> al) {
        Iterator iterator =al.iterator();
        while (iterator.hasNext()) {
            StudentComparator st = (StudentComparator) iterator.next();
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
    }
}

class StudentComparator {
    int rollno;
    String name;
    int age;

    StudentComparator(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }
}

class AgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        StudentComparator s1 = (StudentComparator) o1;
        StudentComparator s2 = (StudentComparator) o2;

        if (s1.age == s2.age)
            return 0;
        else if (s1.age > s2.age)
            return 1;
        else
            return -1;
    }
}

class NameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        StudentComparator s1 = (StudentComparator) o1;
        StudentComparator s2 = (StudentComparator) o2;

        return s1.name.compareTo(s2.name);
    }
}
