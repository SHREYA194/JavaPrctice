package basicJavaPractice;

/**
 * unary
 * arithmetic
 * shift
 * logical and bitwise and ternary
 * assignment
 */

public class OperatorsPractice {
    public static void main(String[] args) {
        unaryOpEx();
        arithmeticOpEx();
        shiftOpEx();
        logicalAndBitwiseOpEx();
        assignmentOpEx();
    }

    private static void assignmentOpEx() {
        System.out.println("\n assignment operators ex :- ");
        int a=10;
        a+=3;//10+3
        System.out.println(a);
        a-=4;//13-4
        System.out.println(a);
        a*=2;//9*2
        System.out.println(a);
        a/=2;//18/2
        System.out.println(a);

        short c=10;
        short b=10;
        c=(short)(c+b);//20 which is int now converted to short
        System.out.println(c);
    }

    private static void logicalAndBitwiseOpEx() {
        System.out.println("\n logical and bit wise operators ex :- ");
        int a=10;
        int b=5;
        int c=20;
        System.out.println(a<b && a++<c); //false && true = false
        System.out.println(a); //10 because second condition is not checked
        System.out.println(a<b & a++<c); //false && true = false
        System.out.println(a); //11 because second condition is checked
        System.out.println();
        System.out.println(a>b || a++<c);//true || true = true
        System.out.println(a);//10 because second condition is not checked
        System.out.println(a>b | a++<c);//true | true = true
        System.out.println(a);//11 because second condition is checked
        System.out.println();
        System.out.println(b<c ? b:c);
        System.out.println(b>c ? b:c);
    }

    private static void shiftOpEx() {
        System.out.println("\n shift operators ex :- ");
        System.out.println(20<<2); // 20 * 2^2
        System.out.println(20<<3); // 20 * 2^3
        System.out.println(20>>2); // 20 / 2^2
        System.out.println(20>>3); // 20 / 2^3
        System.out.println(-20>>2);
        System.out.println(-20>>>3);  // >>> for negative nos changes parity bit MSB to 0
    }

    private static void arithmeticOpEx() {
        System.out.println("\n arithmetic operations ex :- ");
        int a = 40;
        int b = 25;

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
        System.out.println(10*10/5+3-1*4/2);
    }

    private static void unaryOpEx() {
        System.out.println("unary operators ex :- ");

        int x = 10;
        int y = 20;
        int a = 30;
        int b = -40;
        boolean c = true;
        boolean d = false;

        System.out.println(x++);
        System.out.println(++x);

        System.out.println(x++ + ++x);
        System.out.println(y++ + y++);

        System.out.println(~a);
        System.out.println(~b);

        System.out.println(!c);
        System.out.println(!d);
    }
}
