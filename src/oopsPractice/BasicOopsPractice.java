package oopsPractice;

/**
 * abstraction - abstract class, interface
 * encapsulation - private data members, public methods
 * inheritance - subclass , extends, is-a
 * polymorphism - compile time (overloading), run time (overriding)
 */

public class BasicOopsPractice {
    public static void main(String[] args) {
        CallBasicOopsPractice callBasicOopsPractice = new CallBasicOopsPractice("parent class practice");
        callBasicOopsPractice.basicOopsEx();
        callBasicOopsPractice.basicOopsEx(4);
        System.out.println(callBasicOopsPractice.getName());

        ChildCall1BasicOopsPractice childCall1BasicOopsPractice = new ChildCall1BasicOopsPractice("child class 1 practice");
        System.out.println(childCall1BasicOopsPractice.getName());
        callBasicOopsPractice.basicOopsEx();

        ChildCall2BasicOopsPractice childCall2BasicOopsPractice = new ChildCall2BasicOopsPractice("child class 2 practice");
        System.out.println(childCall2BasicOopsPractice.getName());
        callBasicOopsPractice.basicOopsEx(10);


        CallBasicOopsPractice callBasicOopsPractice1 = new ChildCall2BasicOopsPractice("parent with child class");
        System.out.println(callBasicOopsPractice1.getName());
        callBasicOopsPractice1.basicOopsEx(19);

    }
}

class CallBasicOopsPractice implements BasicOopsInterfacePractice {
    private String name;

    public CallBasicOopsPractice(String name) {
        this.name = name;
    }

    // encapsulation - getter
    public String getName() {
        return name;
    }


    @Override
    public void basicOopsEx() {
        System.out.println("call basic oops :- " + name);
    }


    // method overloading - compile time polymorphism
    public void basicOopsEx(int a) {
        System.out.println("call basic oops :- " + a);
    }
}

// derived class - inheritance
class ChildCall1BasicOopsPractice extends CallBasicOopsPractice {
    public ChildCall1BasicOopsPractice(String name) {
        super(name);
    }

    // method overriding - run time polymorphism
    @Override
    public void basicOopsEx() {
        System.out.println("child class 1 basic oops.");
    }
}

// inheritance
class ChildCall2BasicOopsPractice extends CallBasicOopsPractice {
    public ChildCall2BasicOopsPractice(String name) {
        super(name);
    }

    @Override
    public void basicOopsEx() {
        System.out.println("child class 2 basic oops.");
    }
}


