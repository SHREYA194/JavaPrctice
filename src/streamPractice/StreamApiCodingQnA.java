package streamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiCodingQnA {

    public static void main(String[] args) {
//        oneTo10();
//        elevenTo20();
        twentyOneTo30();
    }

    private static void twentyOneTo30() {
        nthLarget();
        palindromicStrings();
        reverseStr();
        filConMapToList();
        rmvDuplWithoutCollector();
        mostFreqChar();
        cmnEle();
        sumSquEven();
        partStrByPalin();
        skipLimit();
    }

    // 30. Skip and Limit Elements
    private static void skipLimit() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> res = numbers.stream().skip(3).limit(2).collect(Collectors.toList());
        System.out.println(res);
    }

    // 29. Partition Strings by Palindrome
    private static void partStrByPalin() {
        List<String> words = Arrays.asList("radar", "level", "java", "stream");
        Map<Boolean, List<String>> map = words.stream()
                .collect(Collectors.partitioningBy(a -> a.equals(new StringBuilder(a).reverse().toString())));
        System.out.println(map);
    }

    // 28. Find the Sum of Squares of Even Numbers
    private static void sumSquEven() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum =  numbers.stream().filter(n -> n%2==0).mapToInt(n -> n*n).sum();
        System.out.println(sum);
    }

    // 27. Find Common Elements Between Two Lists
    private static void cmnEle() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> lst = list1.stream().filter(list2::contains).toList();
        System.out.println(lst);
    }

    // 26. Find the Most Frequent Character in a String
    private static void mostFreqChar() {
        String input = "success";
        char ch = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElseThrow();
        System.out.println(ch);
    }

    // 25. Remove Duplicates Without Collectors
    private static void rmvDuplWithoutCollector() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
        List<Integer> nums = numbers.stream().distinct().toList();
        System.out.println(nums);
    }

    // 24. Filter and Convert Map to List
    // Given a map, filter entries with values greater than 10 and collect keys into a list.
    private static void filConMapToList() {
        Map<String, Integer> map = Map.of("A", 5, "B", 15, "C", 10, "D", 20);
        List<String> lst = map.entrySet().stream().filter(a -> a.getValue() > 10).map(Map.Entry::getKey).toList();
        System.out.println(lst);
    }

    // 23. Reverse Each String in a List
    private static void reverseStr() {
        List<String> words = Arrays.asList("Java", "Stream", "API");
        List<String> rev = words.stream().map(a -> new StringBuilder(a).reverse().toString()).toList();
        System.out.println(rev);
    }

    // 22. Find All Palindromic Strings
    private static void palindromicStrings() {
        List<String> words = Arrays.asList("radar", "level", "world", "java");
        List<String> pal = words.stream().filter(a ->
            a.equals(new StringBuilder(a).reverse().toString())
        ).toList();
        System.out.println(pal);
    }

    // 21. Find Nth Largest Element in a List
    private static void nthLarget() {
        List<Integer> numbers = Arrays.asList(10, 20, 50, 40, 30);
        int a = numbers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow();
        System.out.println(a);
    }

    private static void elevenTo20() {
        flatterList();
        concatStr();
        longestStr();
        freqCharStr();
        parStreamSum();
        customCollector();
        removeNullVals();
        calcAvgNums();
        collectMapFromList();
        partEvenOdd();
    }

    // 20. Partition Numbers into Even and Odd
    private static void partEvenOdd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> map = numbers.stream().collect(
                Collectors.partitioningBy(a -> a%2==0));
        System.out.println(map);
    }

    // 19. Collect Map from List
    private static void collectMapFromList() {
        List<String> words = Arrays.asList("Java", "Stream", "API");
        Map<String, Integer> map = words.stream().collect(Collectors.toMap(c->c, String::length));
        System.out.println(map);
    }

    // 18. Calculate Average of Numbers
    private static void calcAvgNums() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        Double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(avg);
    }

    // 17. Remove Null Values
    private static void removeNullVals() {
        List<String> words = Arrays.asList("Java", null, "Stream", null, "API");
        List<String> filWords = words.stream().filter(Objects::nonNull).toList();
        System.out.println(filWords);
    }

    // 16. Create Custom Collector
    private static void customCollector() {
        List<String> words = Arrays.asList("Java", "Stream", "API");
        String s = words.stream().collect(Collectors.joining(", "));
        System.out.println(s);
    }

    // 15. Parallel Stream to Compute Sum
    private static void parStreamSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    // 14. Count Frequency of Characters in a String
    private static void freqCharStr() {
        String input = "success";
        Map<Character, Long> map = input.chars().mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println(map);
    }

    // 13. Find the Longest String
    private static void longestStr() {
        List<String> words = Arrays.asList("Java", "Stream", "API", "Development");
        String str = words.stream().reduce((w1,w2) -> w1.length() > w2.length() ? w1 : w2)
                .orElse(null);
        System.out.println(str);
    }

    // 12. Concatenate Strings
    private static void concatStr() {
        List<String> words = Arrays.asList("Stream", "API", "is", "powerful");
        String str = words.stream().reduce("", (s1,s2) -> s1+" "+s2).trim();
        System.out.println(str);
    }

    // 11. Flatten a List of Lists
    private static void flatterList() {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> res = listOfLists.stream().flatMap(List::stream).toList();

        System.out.println(res);
    }

    private static void oneTo10() {
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
