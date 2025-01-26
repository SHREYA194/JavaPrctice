package oopsPractice;

/**
 * abstraction provide 1 - 100 % abstraction
 */

public class AbstractClassPractice {
    public static void main(String[] args) {
        FinalDerivedClass finalDerivedClass = new FinalDerivedClass();
        System.out.println(finalDerivedClass.doEx());
        System.out.println(finalDerivedClass.strEx());
        System.out.println(finalDerivedClass.methodAbstractEx());
    }
}

abstract class ExampleAbstracClass {
    abstract int methodAbstractEx();
    String strEx() {
        return "demo";
    }
}

abstract class DerivedClass extends ExampleAbstracClass {
    @Override
    int methodAbstractEx() {
        return 4;
    }

    abstract double doEx();
}

class FinalDerivedClass extends DerivedClass {
    @Override
    double doEx() {
        return 14.8;
    }

//    @Override
//    int methodAbstractEx() {
//        return 6;
//    }
}

