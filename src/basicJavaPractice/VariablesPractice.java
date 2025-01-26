package basicJavaPractice;

/**
 * local
 * instance
 * static
 * widening
 * narrowing / type casting
 * overflow
 */

public class VariablesPractice {
    public static void main(String[] args) {
        variablesEx();
        wideningNarrowingEx();
    }

    private static void wideningNarrowingEx() {
        System.out.println("\n widening ex :- ");
        int a = 20;
        float b = a;
        System.out.println("int value = " + a + " , float value = " + b);

        System.out.println("\n narrowing / type casting ex :- ");
        double d = 56.7;
        int e = (int) d;
        System.out.println("double value = " + d + " , int value = " + e);

        System.out.println("\n overflow ex :- ");
        int x = 130;
        byte y = (byte) x;
        System.out.println(" int value = " + x + " , byte value :- " + y);

        System.out.println("\n adding lower type ex :- ");
        byte h = 20;
        byte g = 10;
        byte r = (byte) (h + g);
        System.out.println(r);
    }

    private static void variablesEx() {
        System.out.println("Local Variable Ex :- ");
        int a = 10;
        System.out.println("local var a = " + a);

        System.out.println("\n Instance Variable Ex :- ");
        InstanceVariableClass variableClass = new InstanceVariableClass();
        System.out.println("name = " + variableClass.name + " , age = " + variableClass.age);

        System.out.println("\n Static Variable Ex :- ");
        StaticVariableClass s1 = new StaticVariableClass();
        StaticVariableClass s2 = new StaticVariableClass();
        s1.age = 21;
        s2.age = 25;
        StaticVariableClass.age = 24;
        System.out.println("s1 age = " + s1.age + " , s2 age = " + s2.age);
    }
}

class InstanceVariableClass {
    public String name;
    public int age = 18;

    public InstanceVariableClass() {
        this.name = "Example Name";
    }
}

class StaticVariableClass {
    static int age;
}
