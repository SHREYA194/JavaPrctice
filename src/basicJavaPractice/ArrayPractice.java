package basicJavaPractice;

import java.util.Arrays;

/**
 * grouping of elements of same kind stored in a single, contiguous block of memory
 * contains similar data type elements
 * element stored in contiguous memory location
 * store only fixed set of elements
 * index based
 * implements Serializable and Cloneable interface
 *
 * single dimensional
 * multidimensional
 * anonymous
 * jagged arrays - each row of the array can have a different number of columns
 */

public class ArrayPractice {
    public static void main(String[] args) {
        singleDimArrayEx();
        multiDimArrayEx();
        anonymousArrayEx();
        jaggedArrayEx();
    }

    private static void jaggedArrayEx() {
        System.out.println("\n jagged array ex :- ");

        int arr[][] = new int[3][];
        arr[0] = new int[1];
        arr[1] = new int[2];
        arr[2] = new int[3];


        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                arr[i][j] = i * j;
            }
        }

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void anonymousArrayEx() {
        System.out.println("\n anonymous array ex :- ");
        callMethodAnonymousArray(new int[]{3,6,8});
    }

    private static void callMethodAnonymousArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static void multiDimArrayEx() {
        System.out.println("\n multi dimensional array ex :- ");
        int[][] arr = new int[3][3];
        int arr1[][] = {{7,8,9}, {4,5,6}, {1,2,3}};
        int[] arr2[] = {{1,2,3},{4,5,6},{7,8,9}};

        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;
        arr[1][0]=4;
        arr[1][1]=5;
        arr[1][2]=6;
        arr[2][0]=7;
        arr[2][1]=8;
        arr[2][2]=9;

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr1.length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i=0; i<arr2.length; i++) {
            for (int j=0; j<arr2.length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void singleDimArrayEx() {
        System.out.println("single dimensional array ex :- ");
        int[] arr1 = new int[5];
        int []arr2 = {1,2,3};
        int arr3[] = new int[2];

        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 4;
        arr1[4] = 5;

        arr3[0] = 1;
        arr3[1] = 2;
//        arr3[2] = 4; // array index out of bound

        System.out.println(Arrays.toString(arr1) + " \n " + Arrays.toString(arr2) + " \n " + Arrays.toString(arr3));
    }
}
