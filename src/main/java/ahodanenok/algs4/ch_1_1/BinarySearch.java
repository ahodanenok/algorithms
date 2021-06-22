package ahodanenok.algs4.ch_1_1;

import java.util.Arrays;

/**
 * Exercise 1.1.22
 */
public class BinarySearch {

    private static final boolean DEBUG = "true".equals(System.getProperty(BinarySearch.class.getName() + ".DEBUG"));

    public static void main(String[] args) {
        int[] array = new int[] { 1, 3, 6, 1, 2, 6, 12, 33, 6, 1, 0 };
        Arrays.sort(array);
        System.out.println(rank(array, 0));
    }

    public static int rank(int[] array, int n) {
        return rank(array, n, 0, array.length, 0);
    }

    private static int rank(int[] array, int n, int lo, int hi, int depth) {
        if (DEBUG) {
            String indent = "";
            while (indent.length() < depth) {
                indent += " ";
            }

            System.out.printf("%slo=%d, hi=%d%n", indent, lo, hi);
        }

        if (lo >= hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (array[mid] > n) {
            return rank(array, n, lo, mid - 1, depth + 1);
        } else if (array[mid] < n) {
            return rank(array, n, mid + 1, hi, depth + 1);
        } else {
            return mid;
        }
    }
}
