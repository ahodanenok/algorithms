package ahodanenok.algs4.ch_1_1;

import java.util.Arrays;

/**
 * Exercise 1.1.15
 */
public class Histogram {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int [] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            // not using floor as there is no negative numbers
            array[i] = (int) (Math.random() * n);
        }
        System.out.println("    array = " + Arrays.toString(array));
        System.out.println("        m = " + m);

        int[] histogram = compute(array, m);
        System.out.println("histogram = " + Arrays.toString(histogram));
    }

    public static int[] compute(int[] array, int m) {
        Arrays.sort(array);

        int[] result = new int[m];
        for (int i = 0; i < result.length; i++) {
            int idx = Arrays.binarySearch(array, i);
            if (idx < 0) {
                continue;
            }

            // because array is sorted, if `i` is found in the array,
            // then we are somewhere in a region of `i` values in it

            int j = idx;
            // check if there are any `i` values on the left (and at `idx`)
            while (j >= 0 && array[j] == i) {
                result[i]++;
                j--;
            }

            j = idx + 1;
            // check if there are any `i` values on the right
            while (j < array.length && array[j] == i) {
                result[i]++;
                j++;
            }
        }

        return result;
    }
}
