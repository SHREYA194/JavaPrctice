package streamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * lambda expression
 * functional interface
 * user defined functional interface
 * predicate -> test -> boolean valued function
 * function -> apply -> work for you and return something
 * consumer -> accept -> only consume not return anything
 * supplier -> get -> not take anything only return
 * combined example
 * bi predicate
 * bi function
 * bi consumer
 * unary operator
 * binary operator
 * method reference
 * constructor reference
 */

public class Java8NewFeaturePractice {
    public static void main(String[] args) {
        lambdaExpressionEx();
        predicateEx();
        functionEx();
        consumerEx();
        supplierEx();
        combinedEx();
        biCombinedEx();
        unaryOperatorEx();
        binaryOperatorEx();
        methodReferenceEx();
        constructorReferenceEx();
    }

    private static void constructorReferenceEx() {
        System.out.println("\n constructor reference :- ");

        List<String> list = Arrays.asList("one", "two", "three");
        List<MobileNumber> mobileNumberList = list.stream().map(MobileNumber::new).collect(Collectors.toList());
        System.out.println(mobileNumberList);
    }

    private static void methodReferenceEx() {
        System.out.println("\n method reference ex :- ");

         List<String> list = Arrays.asList("first", "second", "third", "fourth");
         list.forEach(System.out::println);
    }

    private static void binaryOperatorEx() {
        System.out.println("\n binary operator ex :- ");
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply(6,8));
    }

    private static void unaryOperatorEx() {
        System.out.println("\n unary operator ex :- ");
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(4));
    }

    private static void biCombinedEx() {
        System.out.println("\n bi predicate, function, consumer ex :- ");

        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x % y == 0;
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        };

        System.out.println(biPredicate.test(4,2));
        if (biPredicate.test(4,2)) {
            biConsumer.accept(4, 2);
            System.out.println(biFunction.apply(4, 2));
        }
    }

    private static void combinedEx() {
        System.out.println("\n combined ex :- ");

        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 20;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }
    }

    private static void supplierEx() {
        System.out.println("\n supplier ex :- ");

        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());
    }

    private static void consumerEx() {
        System.out.println("\n consumer ex :- ");

        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("consumer print");

        Consumer<List<Integer>> listConsumer = x -> {
            for (Integer a : x) {
                System.out.println(a);
            }
        };
        Consumer<List<String>> listConsumerMethodRef = x -> x.forEach(System.out::println);
        listConsumer.accept(Arrays.asList(1,2,3,4));
        listConsumerMethodRef.accept(Arrays.asList("one", "two", "three"));

        Consumer<String> consumer1 = x -> Arrays.asList(x);

        consumer1.andThen(consumer).accept("first");
    }

    private static void functionEx() {
        System.out.println("\n function ex :- ");

        Function<Double, Integer> convertToInt = x -> x.intValue();
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        System.out.println(convertToInt.apply(4.4));
        System.out.println(convertToInt.andThen(doubleIt).apply(8.9));
        System.out.println(doubleIt.compose(convertToInt).apply(5.6));

        Function<Integer, Integer> identityFun = Function.identity();
        System.out.println(identityFun.apply(40));
    }

    private static void predicateEx() {
        System.out.println("\n predicate ex :- ");
        Predicate<Integer> isEvenPredicate =  x -> x % 2 == 0;
        System.out.println(isEvenPredicate.test(10));

        Predicate<String> isStartWith = x -> x.startsWith("a");
        Predicate<String> isEndWith = x -> x.endsWith("c");
        System.out.println(isStartWith.and(isEndWith).test("abc"));


    }

    private static void lambdaExpressionEx() {
        System.out.println("lambda ex :- ");

        Thread thread1 = new Thread(() -> {
            System.out.println("Hello !");
        });
        thread1.start();

        MathOperation sumOperation = (a, b) -> a+b;
        MathOperation subtractOperation = (a, b) -> a-b;
        System.out.println(sumOperation.operate(4,2));
        System.out.println(subtractOperation.operate(4,1));
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

class MobileNumber {
    String name;

    public MobileNumber(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MobileNumber{" +
                "name='" + name + '\'' +
                '}';
    }
}
