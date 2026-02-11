package streamPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiCodingQnA {

    public static void main(String[] args) {
//        oneTo10();
//        elevenTo20();
//        twentyOneTo30();
//        thirtyOneTo40();
//        fourtyOneTo50();
        fiftyOneTo60();
    }

    private static void fiftyOneTo60() {
        freqChars();
        flatNestList();
        duplEle();
        convMapToLst();
        checkLstSort();
        findAllSubArray();
        combineTwoListIntoMap();
        pairSum();
        randomNos();
        longestIncreasingSubsequence();
    }

    // 60. Find Longest Increasing Subsequence
    private static void longestIncreasingSubsequence() {
        List<Integer> numbers = Arrays.asList(10, 9, 2, 5, 3, 7, 101, 18);
        List<Integer> lis = new ArrayList<>();

        numbers.forEach(num -> {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos+1);
            if (pos < lis.size()) lis.set(pos, num);
            else lis.add(num);
        });

        System.out.println(lis);
    }

    // 59. Generate Random Numbers Using Stream
    private static void randomNos() {
        List<Integer> list = new Random().ints(5, 1, 100)
                .boxed().collect(Collectors.toList());

        System.out.println(list);
    }

    // 58. Find Pair of Numbers with a Given Sum
    private static void pairSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int targetSum = 6;

        List<List<Integer>> pairs = numbers.stream()
                .flatMap(a -> numbers.stream().filter(b -> a+b == targetSum && a<b)
                        .map(b -> Arrays.asList(a,b)))
                .collect(Collectors.toList());

        System.out.println(pairs);
    }

    // 57. Combine Two Lists into a Map
    private static void combineTwoListIntoMap() {
        List<String> keys = Arrays.asList("A", "B", "C");
        List<Integer> values = Arrays.asList(1, 2, 3);

        Map<String, Integer> map = IntStream.range(0, keys.size())
                .boxed().collect(Collectors.toMap(keys::get, values::get));

        System.out.println(map);
    }

    // 56. Find All Subarrays of a List
    private static void findAllSubArray() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        List<List<Integer>> subarrays = IntStream.range(0, numbers.size()).boxed()
                .flatMap(i -> IntStream.rangeClosed(i+1, numbers.size())
                        .mapToObj(j -> numbers.subList(i,j)))
                .collect(Collectors.toList());

        System.out.println(subarrays);
    }

    // 55. Check if a List is Sorted
    private static void checkLstSort() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean isSorted = IntStream.range(0, numbers.size()-1)
                .allMatch(i -> numbers.get(i) <= numbers.get(i+1));
        System.out.println(isSorted);
    }

    // 54. Convert Map to List of Key-Value Pairs
    private static void convMapToLst() {
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);
        List<String> lst = map.entrySet().stream()
                .map(entry -> entry.getKey() + "-" + entry.getValue()).collect(Collectors.toList());
        System.out.println(lst);
    }

    // 53. Find Duplicate Elements in a List
    private static void duplEle() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);
        Set<Integer> dup = numbers.stream().filter(n -> Collections.frequency(numbers, n) > 1).collect(Collectors.toSet());
        System.out.println(dup);
    }

    // 52. Flatten a Nested List
    private static void flatNestList() {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> list = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(list);
    }

    // 51. Count Frequency of Characters in a String
    private static void freqChars() {
        String input = "success";
        Map<Character, Long> map = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println(map);
    }

    private static void fourtyOneTo50() {
        fibo();
        empHighSalEachDept();
        grpWordsByLen();
        calcProdLst();
        slidingWindowN();
        anagrams();
        pyramid();
        maxPathSumTriangle();
        nonRepeatingChar();
        allSubSeq();
    }

    // 50. Find All Subsequences of a String
    private static void allSubSeq() {
        String str = "abc";
        List<String> subSeqs = IntStream.range(0, 1 << str.length())
                .mapToObj(i -> IntStream.range(0, str.length())
                        .filter(j -> (i & (1<<j)) != 0)
                        .mapToObj(j -> String.valueOf(str.charAt(j)))
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
        System.out.println(subSeqs);
    }

    // 49. Find Non-Repeating Characters in a String
    private static void nonRepeatingChar() {
        String input = "swiss";
        List<Character> nonRep = input.chars().mapToObj(c -> (char) c)
                .filter(c -> input.chars().filter(ch -> ch == c).count() == 1)
                .collect(Collectors.toList());
        System.out.println(nonRep);
    }

    // 48. Find Maximum Path Sum in a Triangle
    private static void maxPathSumTriangle() {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(7, 4),
                Arrays.asList(2, 4, 6),
                Arrays.asList(8, 5, 9, 3)
        );

        int maxSum = IntStream.range(0, triangle.size())
                .mapToObj(i -> triangle.get(triangle.size()-1-i))
                .reduce((rowBelow, currentRow) -> IntStream.range(0, currentRow.size())
                        .mapToObj(j -> currentRow.get(j) + Math.max(rowBelow.get(j), rowBelow.get(j+1)))
                        .collect(Collectors.toList()))
                .orElse(List.of()).get(0);

        System.out.println(maxSum);

    }

    // 47. Generate a Pyramid Pattern
    private static void pyramid() {
        int levels = 5;
        List<String> pyramid = IntStream.rangeClosed(1,levels)
                        .mapToObj(i -> " ".repeat(levels-i) + IntStream.rangeClosed(1,i)
                                .mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                        .collect(Collectors.toList());
        pyramid.forEach(System.out::println);
    }

    // 46. Detect Anagrams in a List
    private static void anagrams() {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "google", "elbow", "below");
        Map<String, List<String>> map = words.stream().collect(Collectors.groupingBy(
                word -> word.chars().sorted().mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining())
        ));
        System.out.println(map);
    }

    // 45. Sliding Window of N Element
    private static void slidingWindowN() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> slw = IntStream.range(0, numbers.size()-2)
                .mapToObj(i -> numbers.subList(i, i+3)).toList();
        System.out.println(slw);
    }

    // 44. Calculate the Product of All Numbers
    // Question: Calculate the product of all numbers in a list using reduce.
    private static void calcProdLst() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int prod = numbers.stream().reduce(1, (a,b) -> a*b);
        System.out.println(prod);
    }

    // 43. Group Words by Length and Sort Them
    // Question: Group words by their length and sort each group alphabetically.
    private static void grpWordsByLen() {
        List<String> words = Arrays.asList("java", "stream", "api", "example", "code", "test");
        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(String::length,
                Collectors.collectingAndThen(
                        Collectors.toList(), list -> list.stream().sorted().toList()
                )));
        System.out.println(map);
    }

    // 42. Find Employees with Highest Salary in Each Department
    private static void empHighSalEachDept() {
        class Employee {
            String name, department;
            double salary;
            Employee(String name, String department, double salary) {
                this.name = name;
                this.department = department;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", department='" + department + '\'' +
                        ", salary=" + salary +
                        '}';
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 80000),
                new Employee("Charlie", "IT", 75000),
                new Employee("Dave", "HR", 60000),
                new Employee("Eve", "Finance", 70000)
        );

        Map<String, Employee> map = employees.stream().collect(Collectors.groupingBy(e -> e.department,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(e -> e.salary)),
                        Optional::get)));
        System.out.println(map);
    }

    // 41. Generate Fibonacci Sequence Using Streams
    // Question: Generate the first N numbers in the Fibonacci sequence.
    private static void fibo() {
        int n = 10;
        List<Integer> fiboLst = Stream.iterate(new int[]{0,1}, arr -> new int[]{arr[1], arr[0]+arr[1]})
                .limit(n).map(arr -> arr[0]).toList();
        System.out.println(fiboLst);
    }

    private static void thirtyOneTo40() {
        longestWordFromSen();
        cartProd();
        topNHighestSco();
        grpByFirstChar();
        cusConStr();
        median();
        nestMapGroup();
        detectCycleInGraphLikeStr();
        wordWithMaxVowel();
        runningSum();
    }

    // 40. Compute Running Sum
    private static void runningSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> runSum = IntStream.range(0,numbers.size())
                .mapToObj(i -> numbers.subList(0,i+1).stream().mapToInt(Integer::intValue).sum()).toList();
        System.out.println(runSum);
    }

    // 39. Find the Word with Maximum Vowels
    private static void wordWithMaxVowel() {
        List<String> words = Arrays.asList("stream", "java", "programming", "awesome");
        String str = words.stream().max(Comparator.comparingInt(s -> (int) s.chars()
                .filter(c -> "aeiou".indexOf(c) != -1).count())).orElse(null);

        System.out.println(str);
    }

    // 38. Detect Cycles in a Graph-Like Structure
    // Question: Detect cycles in a list of parent-child relationships.
    private static void detectCycleInGraphLikeStr() {
        class Node {
            int id, parentId;
            Node(int id, int parentId) {
                this.id = id;
                this.parentId = parentId;
            }
        }

        List<Node> nodes = Arrays.asList(
                new Node(1, 0), new Node(2, 1), new Node(3, 2), new Node(4, 3), new Node(5, 4), new Node(2, 5)
        );

        boolean hasCycle = nodes.stream().anyMatch(node -> nodes.stream()
                .filter(n -> n.id == node.parentId).anyMatch(n -> n.id == node.id));

        System.out.println(hasCycle);
    }

    // 37. Collect Nested Map by Grouping
    // Question: Group employees by department and then by age.
    private static void nestMapGroup() {
        class Employee {
            String name, department;
            int age;
            Employee(String name, String department, int age) {
                this.name = name;
                this.department = department;
                this.age = age;
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 25),
                new Employee("Bob", "IT", 30),
                new Employee("Charlie", "HR", 30),
                new Employee("Dave", "IT", 25)
        );

        Map<String, Map<Integer, List<String>>> map = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.groupingBy(e -> e.age,
                        Collectors.mapping(e -> e.name, Collectors.toList()))));

        System.out.println(map);
    }

    // 36. Find Median of a List
    private static void median() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 5);
        List<Integer> sortedNums = numbers.stream().sorted().toList();
        double median = (sortedNums.size() % 2 == 0)
                ? (sortedNums.get(sortedNums.size()/2 - 1) + sortedNums.get(sortedNums.size())/2) / 2.0
                : sortedNums.get(sortedNums.size() / 2);

        System.out.println(median);
    }

    // 35. Custom Reduce to Concatenate Strings
    // Question: Concatenate strings in reverse order using reduce.
    private static void cusConStr() {
        List<String> words = Arrays.asList("Stream", "API", "is", "awesome");
        String res = words.stream().reduce((w1, w2) -> w2 + " " + w1).orElse(null);
        System.out.println(res);
    }

    // 34. Group by First Character
    private static void grpByFirstChar() {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry");
        Map<Character, List<String>> map = words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map);
    }

    // 33. Find Top N Highest Scoring Students
    private static void topNHighestSco() {
        class Student {
            String name;
            int score;
            Student(String name, int score) { this.name = name; this.score = score; }
        }

        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 88),
                new Student("Dave", 78),
                new Student("Eve", 91)
        );

        List<String> list = students.stream().sorted(Comparator.comparingInt((Student s) -> s.score).reversed())
                .limit(3).map(s -> s.name).toList();

        System.out.println(list);
    }

    // 32. Compute Cartesian Product of Two Lists
    private static void cartProd() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);
        List<String> res = list1.stream().flatMap(i -> list2.stream()
                .map(j -> "("+i+","+j+")")).collect(Collectors.toList());
        System.out.println(res);
    }

    // 31. Find the Longest Word from a Sentence
    private static void longestWordFromSen() {
        String sentence = "Java Stream API is very powerful";
        String res = Arrays.stream(sentence.split(" ")).max(Comparator.comparing(String::length)).orElse(null);
        System.out.println(res);
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
