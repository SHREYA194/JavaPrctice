package streamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * enables parallel processing
 * factorial ex
 * cumulative sum ex
 * for each order ex
 */

public class ParallelStreamPractice {
    public static void main(String[] args) {
        basicEx();
        cumulativeSumEx();
        forEachOrderEx();
    }

    private static void forEachOrderEx() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("\n using for each with parallel stream :- ");
        list.parallelStream().forEach(System.out::println);
        System.out.println("\n for each ordered :- ");
        list.parallelStream().forEachOrdered(System.out::println);
    }

    private static void cumulativeSumEx() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);

        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> list1 = list.stream().map(sum::addAndGet).toList();
        System.out.println(list1);

        sum = new AtomicInteger(0);
        List<Integer> list2 = list.parallelStream().map(sum::addAndGet).toList();
        System.out.println(list2);

        sum = new AtomicInteger(0);
        List<Integer> list3 = list.parallelStream().map(sum::addAndGet).sequential().toList();
        System.out.println(list3);
    }

    private static void basicEx() {
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        List<Long> factorialLst = list.stream().map(ParallelStreamPractice::factorial).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("time taken in sequential stream :- " + (endTime-startTime));

        long startTimeP = System.currentTimeMillis();
        List<Long> factorialLstP = list.parallelStream().map(ParallelStreamPractice::factorial).collect(Collectors.toList());
        long endTimeP = System.currentTimeMillis();
        System.out.println("time taken in parallel stream :- " + (endTimeP-startTimeP));
    }

    private static long factorial (int n) {
        long res = 1;
        for (int i=2; i<=n; i++) {
            res *= i;
        }
        return res;
    }
}
