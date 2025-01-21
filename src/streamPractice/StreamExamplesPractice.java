package streamPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1. collecting names by length
 * 2. counting word occurrences
 * 3. partitioning even and odd numbers
 * 4. summing values in a map
 * 5. creating map from stream elements
 * 6. creating map with stream
 */

public class StreamExamplesPractice {
    public static void main(String[] args) {
        collectingNamesByLength();
        countingWordOccurrences();
        partitionaingEvenAndOddNums();
        summingValuesInAMap();
        creatingElementsFromStreamElements();
        mapWithCount();
    }

    private static void mapWithCount() {
        System.out.println("\n 6. Creating map :- ");
        List<String> list = Arrays.asList("abc", "def", "ghijk", "lmnop");
        System.out.println(list.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));
        System.out.println(list.stream().collect(Collectors.toMap(k -> k,  v -> 1, (x,y) -> x+y)));
    }

    private static void creatingElementsFromStreamElements() {
        System.out.println("\n 5. Creating map from stream elements :- ");
        List<String> list = Arrays.asList("abc", "cdejd", "def", "ight");
        System.out.println(list.stream().collect(Collectors.toMap(k -> k, v -> v)));
    }

    private static void summingValuesInAMap() {
        System.out.println("\n 4. Summing values in a map :- ");
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 10);
        map.put("def", 20);
        map.put("ghi", 30);
        System.out.println(map);
        System.out.println(map.values().stream().reduce(Integer::sum).get());
        System.out.println(map.values().stream().collect(Collectors.summarizingInt(x -> x)));
    }

    private static void partitionaingEvenAndOddNums() {
        System.out.println("\n 3. Partitioning even and odd numbers :- ");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(list);
        System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toList())));
    }

    private static void countingWordOccurrences() {
        System.out.println("\n 2. Counting word occurrences :- ");
        String s = "hello world , hello java , hii world !!!";
        System.out.println(Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));
    }

    private static void collectingNamesByLength() {
        System.out.println("\n 1. Collecting Names By Length :- ");
        List<String> list = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
        System.out.println(list);
        System.out.println(list.stream().collect(Collectors.groupingBy(String::length)));

    }
}
