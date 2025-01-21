package streamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * filter
 * map
 * sorted
 * distinct
 * limit
 * skip
 * peek
 * flat map - handles streams of collections, list or array where each element is itself a collection
 */

public class StreamIntermediateOpsPractice {
    public static void main(String[] args) {
        filterEx();
        mapEx();
        sortedEx();
        distinctExample();
        limitExample();
        skipEx();
        peekEx();
        flatMapEx();
    }

    private static void flatMapEx() {
        List<List<String>> listList = Arrays.asList(
                Arrays.asList("abc", "bcd"),
                Arrays.asList("efg", "fgh"),
                Arrays.asList("cde", "def")
        );

        System.out.println(listList);

        System.out.println(listList.get(1).get(1));

        System.out.println(listList.stream().flatMap(x -> x.stream()).map(String::toUpperCase).collect(Collectors.toList()));

        List<String> sentences = Arrays.asList(
                "hi hello world",
                "how are you",
                "flat map is used."
        );
        System.out.println(sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList());


    }

    private static void peekEx() {
        Stream.iterate(1, x -> x+1).skip(10).limit(20).peek(System.out::println).count();
    }

    private static void skipEx() {
        System.out.println(Stream.iterate(1, x -> x+1).skip(10).limit(100).count());
    }

    private static void limitExample() {
        Stream<Integer> limit = Stream.iterate(1, x -> x + 1).limit(10);
        System.out.println(limit.count());
    }

    private static void distinctExample() {
        List<String> list = Arrays.asList("first", "second", "third", "fourth", "five", "six");
        long f = list.stream().filter(x -> x.startsWith("f")).distinct().count();
        System.out.println(f);
    }

    private static void sortedEx() {
        List<String> list = Arrays.asList("first", "second", "third", "fourth");
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sorted1 = list.stream().sorted((a, b) -> a.length() - b.length());
        System.out.println(sorted.collect(Collectors.toList()));
        System.out.println(sorted1.collect(Collectors.toList()));
    }

    private static void mapEx() {
        List<String> list = Arrays.asList("one", "two", "three", "four");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    private static void filterEx() {
        List<Integer> list = Arrays.asList(3,6,4,8,1,9);
        Stream<Integer> filteredStream = list.stream().filter(x -> x % 2 == 0);
        // no filtering at this point
        List<Integer> collect = filteredStream.collect(Collectors.toList());
        System.out.println(collect);
    }
}
