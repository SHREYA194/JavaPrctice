package streamPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collect
 * forEach
 * reduce  -  combines elements to produce single result
 * count
 * short circuit methods / operations
 * anyMatch, allMatch, noneMatch
 * findFirst, findAny
 * toArray
 * min max
 * Examples
 */

public class TerminalOpsPractice {

    static List<Integer> list = Arrays.asList(5,6,7,1,2,3,4);

    public static void main(String[] args) {
        collectEx();
        forEachEx();
        reduceEx();
        countEx();
        matchEx();
        findEx();
        toArrayEx();
        minMaxEx();
        moreExamples();
    }

    private static void minMaxEx() {
        System.out.println("max = " + Stream.of(5, 89, 23).max(Comparator.naturalOrder()).get());
        System.out.println("min = " + Stream.of(5, 89, 23).min(Comparator.naturalOrder()).get());
    }

    private static void toArrayEx() {
        Object[] array = Stream.of(1, 2, 3).toArray();
        System.out.println(Arrays.stream(array).toList());
    }

    private static void moreExamples() {
        System.out.println("\n 1. filtering nad collecting names :- ");
        System.out.println(" find elements their size are greater than 3 :- ");
        List<String> list1 = Arrays.asList("a", "ab", "abc", "abcd", "abcde", "bcd", "qwer", "awsdfg", "wef");
        System.out.println(list1);
        System.out.println(list1.stream().filter(x -> x.length() > 3).collect(Collectors.toSet()));

        System.out.println("\n\n 2. squaring and sorting numbers :- ");
        List<Integer> list2 = Arrays.asList(5,2,4,8,2,9,6);
        System.out.println(list2);
        System.out.println(list2.stream().map(a -> a * a).sorted().toList());

        System.out.println("\n\n 3. summing numbers :- ");
        List<Integer> list3 = Arrays.asList(2,5,7,9,1);
        System.out.println(list3);
        System.out.println(list3.stream().reduce(Integer::sum).get());

        System.out.println("\n\n 4. counting occurrence of a character :- ");
        String sentence = "Hello world";
        System.out.println(sentence + "\n count of l :- ");
        System.out.println(sentence.chars().filter(x -> x == 'l').count());


    }

    private static void findEx() {
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());
    }

    private static void matchEx() {
        System.out.println(list.stream().anyMatch(x -> x % 2 == 0));
        System.out.println(list.stream().allMatch(x -> x % 2 == 0));
        System.out.println(list.stream().noneMatch(x -> x % 2 == 0));
        System.out.println(list.stream().allMatch(x -> x > 0));
        System.out.println(list.stream().noneMatch(x -> x < 0));
    }

    private static void countEx() {
        System.out.println(list.stream().count());
    }

    private static void reduceEx() {
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());
    }


    private static void forEachEx() {
        list.forEach(System.out::println);
    }

    private static void collectEx() {
        Set<Integer> collect = list.stream().skip(1).collect(Collectors.toSet());
        List<Integer> list1 = list.stream().skip(2).toList();

        System.out.println(list);
        System.out.println(collect);
        System.out.println(list1);
    }
}
