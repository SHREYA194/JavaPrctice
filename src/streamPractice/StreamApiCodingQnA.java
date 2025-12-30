package streamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiCodingQnA {

    public static void main(String[] args) {
        OneTo10();
    }

    private static void OneTo10() {
        filterEvenNums();
        findMax();
        sortLst();
        countStr();
        nonRepeatedChar();
        convertToUpper();
        sumNums();
        checkCondStr();
        duplicateEle();
        grpStrByLen();
    }

    // 10. Group Strings by Length
    private static void grpStrByLen() {
        List<String> words = Arrays.asList("Java", "Stream", "API", "Code", "Fun");
        Map<Integer, List<String>> map = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }

    // 9. Find Duplicate Elements in a List
    private static void duplicateEle() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        Set<Integer> unique = new HashSet<>();
        Set<Integer> dup = numbers.stream()
                .filter(n -> !unique.add(n))
                .collect(Collectors.toSet());
        System.out.println(dup);
    }

    // 8. Check if Any String Matches a Condition
    private static void checkCondStr() {
        List<String> strings = Arrays.asList("Java", "Stream API", "Lambda");
        boolean res = strings.stream().anyMatch(s -> s.contains("API"));
        System.out.println(res);
    }

    // 7. Sum of Numbers in a List
    private static void sumNums() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(Integer::sum).orElse(0);
        int sums = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum + " - " + sums);
    }

    // 6. Convert List of Strings to Uppercase
    private static void convertToUpper() {
        List<String> names = Arrays.asList("java", "stream", "api");
        List<String> upperLst = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperLst);
    }

    // 5. Find First Non-Repeated Character in a String
    private static void nonRepeatedChar() {
        String input = "swiss";
        Optional<Character> a = input.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c)).findFirst();
        System.out.println(a.orElse(null));
    }

    // 4. Count Strings with Specific Prefix
    private static void countStr() {
        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        long cnt = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(cnt);
    }

    // 3. Sort a List
    private static void sortLst() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 4, 2);
        List<Integer> sorted = numbers.stream().sorted().toList();
        List<Integer> descSorted = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sorted + " - " + descSorted);
    }

    // 2. Find Maximum in a List
    private static void findMax() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int max = numbers.stream().max(Integer::compare).orElseThrow();
        System.out.println(max);
    }

    // 1. Filter Even Numbers from a List
    private static void filterEvenNums() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNums = numbers.stream()
                .filter(n-> n%2==0).toList();
        System.out.println(evenNums);
    }


}
