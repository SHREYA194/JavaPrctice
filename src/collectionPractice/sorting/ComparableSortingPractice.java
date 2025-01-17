package collectionPractice.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * compareTo(Object)
 * reverse order
 */

public class ComparableSortingPractice {
    public static void main(String[] args) {
        comparableEx();
    }

    private static void comparableEx() {
        ArrayList<StudentComparable> al = new ArrayList<StudentComparable>();
        al.add(new StudentComparable(101,"Vijay",23));
        al.add(new StudentComparable(106,"Ajay",27));
        al.add(new StudentComparable(105,"Jai",21));

        printStudentList(al);

        Collections.sort(al);
        System.out.println("\n after sort by age :- ");
        printStudentList(al);

        Collections.sort(al, Collections.reverseOrder());
        System.out.println("\n after reverse sort by age :- ");
        printStudentList(al);
    }

    private static void printStudentList(ArrayList<StudentComparable> al) {
        for (StudentComparable s : al) {
            System.out.println(s.rollno + " , " + s.name + " , " + s.age);
        }
    }
}

class StudentComparable implements Comparable<StudentComparable> {
    int rollno;
    String name;
    int age;
    StudentComparable(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }

    @Override
    public int compareTo(StudentComparable stu) {
        if (age == stu.age)
            return 0;
        else if (age > stu.age)
            return 1;
        else
            return -1;
    }
}
