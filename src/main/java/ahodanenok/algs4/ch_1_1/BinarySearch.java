package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.Counter;

import java.util.Arrays;

/**
 * Book, exercise 1.1.22
 */
public class BinarySearch {

    private static final boolean DEBUG = "true".equals(System.getProperty(BinarySearch.class.getName() + ".DEBUG"));

    public static void main(String[] args) {
        int[] array = new int[] { 1, 3, 6, 1, 2, 6, 12, 33, 6, 1, 0 };
        Arrays.sort(array);
        System.out.println(rank(array, 0));
    }

    public static int rank(int[] array, int n) {
        return rank(array, n, 0, array.length - 1, 0, null);
    }

    /**
     * Book, exercise 1.2.9
     */
    public static int rank(int[] array, int n, Counter counter) {
        return rank(array, n, 0, array.length - 1, 0, counter);
    }

    private static int rank(int[] array, int n, int lo, int hi, int depth, Counter counter) {
        if (DEBUG) {
            String indent = "";
            while (indent.length() < depth) {
                indent += " ";
            }

            System.out.printf("%slo=%d, hi=%d%n", indent, lo, hi);
        }

        if (lo > hi) {
            return -1;
        }

        if (counter != null) {
            counter.increment();
        }

        int mid = lo + (hi - lo) / 2;
        if (array[mid] > n) {
            return rank(array, n, lo, mid - 1, depth + 1, counter);
        } else if (array[mid] < n) {
            return rank(array, n, mid + 1, hi, depth + 1, counter);
        } else {
            return mid;
        }
    }
}
