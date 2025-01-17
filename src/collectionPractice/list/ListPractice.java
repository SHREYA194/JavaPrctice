package collectionPractice.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * add
 * addAll
 * remove
 * indexOf
 * removeAll
 * retainAll
 * Array -> List :- Arrays.asList() ,  ArrayList Constructor
 * List -> Array :- List.toArray()
 * List Iterator
 */

public class ListPractice {
    public static void main(String[] args) {

        String[] arrStrings = {"abc", "def", "ghi"};
        System.out.println("printing array :- " + arrStrings.toString());

        List<String> list = Arrays.asList(arrStrings);
        System.out.println("array to list :- " + list);

        String[] array = list.toArray(new String[list.size()]);
        System.out.println("list to array :- " + array);
        System.out.println("printing :- " + Arrays.toString(array));

        List<String> list1 = new ArrayList<>();
        list1.add("asd");
        list1.add("qwer");
        list1.add("zcccccv");
        ListIterator iterator = list1.listIterator();
        while (iterator.hasNext()) {
            System.out.println("next index :- " + iterator.nextIndex() + " , next ele :- " + iterator.next());
        }
        while (iterator.hasPrevious()) {
            System.out.println("previous index :- " + iterator.previousIndex() + " , previous ele :- " + iterator.previous());
        }
    }
}
