package streamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * what - a sequence of elements supporting functional and declarative programming
 * how to use - source , intermediate operations & terminal operation
 * create stream
 */

public class StreamBasic {
    public static void main(String[] args) {
        basicEx();
        createStreamEx();
    }

    private static void createStreamEx() {
        System.out.println("\n create stream ex :- ");

        System.out.println("\n 1. from collection :- ");
        List<String> list = Arrays.asList("abc", "bcd", "cde");
        Stream<String> stream = list.stream();
        System.out.println(stream.collect(Collectors.toList()));

        System.out.println("\n 2. from Arrays :- ");
        String[] array = { "one", "two", "three" };
        Stream<String> stream1 = Arrays.stream(array);
        System.out.println(stream1.collect(Collectors.toList()));

        System.out.println("\n 3. from Stream.of() :- ");
        Stream<String> a = Stream.of("a", "b", "c");
        System.out.println(a.collect(Collectors.toList()));

        System.out.println("\n 4. infinite stream from generate() :- ");
        Stream<String> generate = Stream.generate(() -> "example").limit(5);
        System.out.println(generate.collect(Collectors.toList()));

        System.out.println("\n 5. infinite stream from iterate :- ");
        List<Integer> collect = Stream.iterate(2, x -> x + 2).limit(8).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void basicEx() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(list.stream().filter(x -> x % 2 == 0).count());

        List<String> list1 = Arrays.asList("abc", "bcd", "aef", "cde", "def", "acc", "abf");
        System.out.println(list1.stream().filter(x -> x.startsWith("a")).collect(Collectors.toList()));
    }
}
