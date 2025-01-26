package basicJavaPractice;

import java.util.Scanner;

/**
 * short - 2 byte
 * long - 8 byte
 * boolean - 1 bit
 * byte - 8 bit
 * char - 2 byte
 * string value of
 * Integer get system property
 * package class
 */

public class DataTypePractice {
    public static void main(String[] args) {
//        sbortPractice();
//        longPractice();
//        stringEx();
//        sysPropEx();
//        packageClassEx();
//        booleanAndByteEx();
        charEx();
    }

    private static void charEx() {
        System.out.println("\n char ex :- ");
        char a = 'a';
        char b = 87;
        System.out.println(a + " , " + b);
    }

    private static void booleanAndByteEx() {
        System.out.println("\n boolean and byte ex :- ");
        boolean a = true;
        System.out.println(a);
        a = false;
        System.out.println(a);
        byte b = 127;
        byte c = -128;
        System.out.println("byte min = " + c + " , max = " + b);
    }

    private static void packageClassEx() {
        System.out.println("\n package class :- ");

        Package p = Package.getPackage("java.util");
        System.out.println(p.getSpecificationTitle());
        System.out.println(p.getSpecificationVendor());
        System.out.println(p.getSpecificationVersion());
        System.out.println(p.getImplementationTitle());
        System.out.println(p.getImplementationVendor());
        System.out.println(p.getImplementationVersion());
        System.out.println(p.isSealed());
    }

    private static void sysPropEx() {
        System.out.println("\n system property :- ");
        System.out.println("system property value = " + Integer.getInteger("sun.arch.data.model"));
        System.out.println("other value = " + Integer.getInteger("java"));
        System.setProperty("test.value", "46");
        System.out.println("custom property = " + Integer.getInteger("test.value"));
        System.out.print("enter string :- ");
        Scanner sc = new Scanner(System.in);
        System.out.println("entered input = " + sc.next());
    }

    private static void stringEx() {
        System.out.println("\n\n string ex :- ");

        // Primitive types
        boolean myBoolean = true;    // Example boolean value
        char myChar = 'A';           // Example char value
        int myInt = 42;              // Example int value
        long myLong = 123456789L;    // Example long value
        float myFloat = 123.45f;     // Example float value
        double myDouble = 987.654;   // Example double value
        // Objects
        Object myObject = new Object();          // Example Object
        Integer myIntegerObject = 123;           // Example Integer object
        Double myDoubleObject = 456.789;         // Example Double object
        // Using valueOf() to convert various types to String
        String booleanString = String.valueOf(myBoolean);          // Convert boolean to String
        String charString = String.valueOf(myChar);               // Convert char to String
        String intString = String.valueOf(myInt);                 // Convert int to String
        String longString = String.valueOf(myLong);               // Convert long to String
        String floatString = String.valueOf(myFloat);             // Convert float to String
        String doubleString = String.valueOf(myDouble);           // Convert double to String
        String integerObjectString = String.valueOf(myIntegerObject); // Convert Integer object to String
        String doubleObjectString = String.valueOf(myDoubleObject);  // Convert Double object to String
        // Displaying the results
        System.out.println("Boolean: " + booleanString);
        System.out.println("Char: " + charString);
        System.out.println("Int: " + intString);
        System.out.println("Long: " + longString);
        System.out.println("Float: " + floatString);
        System.out.println("Double: " + doubleString);
        System.out.println("Integer Object: " + integerObjectString);
        System.out.println("Double Object: " + doubleObjectString);
    }

    private static void longPractice() {
        System.out.println("\n\n long ex :- ");
        long n1 =  10L;
        long n2 = -10L;

//        long n3 = 10.4; // error incompatible type : double found
//        long n4 = 10f; // error incompatible type : float found

        long n5 = 'a';
        long min = -9223372036854775808L;
        long max = 9223372036854775807L;

        System.out.printf("%s, %s, %s, %s, %s", n1, n2, n5, min, max);
    }

    private static void sbortPractice() {
        System.out.println("\n short ex :- ");
        short n1 =  10;
        short n2 = -10;

//        short n3 = 10.4; // error incompatible type : double found
//        short n4 = 10f; // error incompatible type : float found

        short n5 = 'a';
        short min = -32768;
        short max = 32767;

        System.out.printf("%s, %s, %s, %s, %s", n1, n2, n5, min, max);
    }
}
