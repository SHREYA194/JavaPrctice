package streamPractice;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * int stream
 * range
 * range closed
 * random doubles
 */

public class PrimitiveStreamsPractice {
    public static void main(String[] args) {
        basicPrimitiveEx();
    }

    private static void basicPrimitiveEx() {
        int[] nums = {1,2,3,4,5,6};
        IntStream stream = Arrays.stream(nums);

        System.out.println(IntStream.range(1,5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));

        IntStream.of(5,6,7);

        DoubleStream doubleStream = new Random().doubles(5);
//        System.out.println(doubleStream.sum());
//        System.out.println(doubleStream.min());
//        System.out.println(doubleStream.max());
//        System.out.println(doubleStream.average());
//        System.out.println(doubleStream.summaryStatistics());
        System.out.println(doubleStream.mapToInt(x -> (int) x+1).boxed().collect(Collectors.toList()));
//        System.out.println(doubleStream.boxed().collect(Collectors.toList()));

        IntStream intStream = new Random().ints(4);
        System.out.println(intStream.boxed().toList());
    }
}
