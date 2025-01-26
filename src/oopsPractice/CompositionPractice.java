package oopsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * both entities are related to each other
 * an object contains composed object and the composed object cannot exist without another entity
 * multiple inheritance by composition
 */

public class CompositionPractice {
    public static void main(String[] args) {
        College college1 = new College("one", "add one");
        College college2 = new College("two", "add two");
        College college3 = new College("three", "add three");

        List<College> colleges = Arrays.asList(college1,college2,college3);

        University university = new University(colleges);

        System.out.println(university);
    }
}

class College {
    public String name;
    public String address;

    public College(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class University {
    private final List<College> colleges;

    public University(List<College> colleges) {
        this.colleges = colleges;
    }

    @Override
    public String toString() {
        return "University{" +
                "colleges=" + colleges +
                '}';
    }
}