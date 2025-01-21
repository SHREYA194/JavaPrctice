package streamPractice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Collectors is a utility class
 * provides a set of methods to create set of methods to create common collectors
 *
 * list
 * set
 * specific collection
 * joining = concatenates stream elements into a single string
 * summarizing data = generates statistical summary = count, sum, min, average, max
 * grouping elements
 * partition elements = based on predicate - two groups - true, false
 * mapping and collecting = applies a mapping function before collecting
 */

public class CollectorsPractice {
    public static void main(String[] args) {
        basicCollectorsEx();
    }

    private static void basicCollectorsEx() {
        System.out.println("1. collecting to List :- ");
        List<String> list = Arrays.asList("one", "two", "three", "four");
        List<String> collect = list.stream().filter(a -> a.startsWith("t")).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("\n 2. set :- ");
        Set<String> collect1 = list.stream().collect(Collectors.toSet());
        System.out.println(collect1);

        System.out.println("\n 3. specific collection :- ");
        ArrayDeque<String> collect2 = list.stream().collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(collect2);

        System.out.println("\n 4. joining strings :- ");
        String collect3 = list.stream().collect(Collectors.joining(" "));
        System.out.println(collect3);

        System.out.println("\n 5. summarizing data :- ");
        List<Integer> list1 = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics collect4 = list1.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(collect4);
        System.out.println(list1.stream().collect(Collectors.counting()));

        System.out.println("\n 6. grouping elements :- ");
        Map<Integer, List<String>> collect5 = list.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(collect5);
        Map<Integer, String> collect6 = list.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(" , ")));
        System.out.println(collect6);
        System.out.println(list.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> collect7 = list.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(collect7);

        System.out.println("\n 7. partition elements :- ");
        System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x.length() > 3)));

        System.out.println("\n 8. mapping and collecting :- ");
        System.out.println(list.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList())));
    }
}
