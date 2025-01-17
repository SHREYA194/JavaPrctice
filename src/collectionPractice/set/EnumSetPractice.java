package collectionPractice.set;

import java.util.*;

/**
 * of
 * all of
 * none of
 * iterator
 */


enum days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumSetPractice {
    public static void main(String[] args) {
        basicEnumSet();
    }

    private static void basicEnumSet() {
        Set<days> set = EnumSet.of(days.FRIDAY, days.THURSDAY);
        Iterator<days> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<days> set1 = EnumSet.allOf(days.class);
        System.out.println(set1);

        Set<days> set2 = EnumSet.noneOf(days.class);
        System.out.println(set2);
    }
}
