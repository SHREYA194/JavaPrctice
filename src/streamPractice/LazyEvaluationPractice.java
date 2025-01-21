package streamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * lazy evaluation
 * before and after terminal
 */

public class LazyEvaluationPractice {
    public static void main(String[] args) {
        lazyEvaluationEx();
    }

    private static void lazyEvaluationEx() {
        List<String> list = Arrays.asList("one","two","three","four");
        System.out.println(list);

        Stream<String> stringStream = list.stream().filter(a -> {
            System.out.println(a);
            return a.length() > 3;
        });

        System.out.println("before terminal operation :- ");

        List<String> collect = stringStream.collect(Collectors.toList());

        System.out.println(collect);
    }
}
