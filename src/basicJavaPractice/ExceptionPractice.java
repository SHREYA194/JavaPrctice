package basicJavaPractice;

/**
 * types - checked, unchecked, error
 * try
 * catch
 * finally
 * throw
 * throws
 * custom
 * by default unchecked exception forwarded calling chain, checked exception not forwarded
 */

public class ExceptionPractice {
    public static void main(String[] args) {
//        basicExceptionEx();

//        validate(13);  // tried unchecked exception

        // tried checked exception
//        try {
//            validateChecked(13);
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }

        // user defined exception
        testUserDefinedExceltion();

        System.out.println("rest of the code for checked exception");
    }

    private static void testUserDefinedExceltion() {
        try {
            throw new UserDefinedException("this is user-defined exception");
        } catch (UserDefinedException e) {
            System.out.println("caught exception");
            System.out.println(e);
        }
        finally {
            System.out.println("finally block");
        }
        System.out.println("rest of the code");
    }

    public static void validateChecked(int age) throws ArithmeticException {
        if (age < 18) {
            throw new ArithmeticException("person age is less than 18");
        } else {
            System.out.println("person age is greater than 18");
        }
    }

    public static void validate(int age) {
        if (age < 18) {
            throw new ArithmeticException("person age is less than 18");
        } else {
            System.out.println("person age is greater than 18");
        }
    }

    private static void basicExceptionEx() {
        try {
            int data = 25/0;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        finally {
            System.out.println("finally block");
        }
        System.out.println("rest of the code");
    }
}

class UserDefinedException extends Exception {
    public UserDefinedException(String message) {
        super(message);
    }
}