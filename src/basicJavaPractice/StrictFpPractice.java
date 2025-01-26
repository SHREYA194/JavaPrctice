package basicJavaPractice;

/**
 * ensures to get same result on every platform for floating point variable
 */

public class StrictFpPractice {
    public static void main(String[] args) {
        basicStrictFpEx();
    }

    private static void basicStrictFpEx() {
        System.out.println("allowed with :- class, interface and methods.");
        System.out.println("not allowed with :- abstract methods, variables or constructor");
    }
}

strictfp class A {
    // allowed
}
strictfp interface B {
    // allowed
}

class C {
    strictfp void x(){}  // allowed

//    strictfp abstract void y() {}  // not allowed

//    strictfp int z = 10;  // not allowed

//    strictfp B() {}  // not allowed

}
