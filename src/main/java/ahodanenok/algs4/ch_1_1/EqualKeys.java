package ahodanenok.algs4.ch_1_1;

/**
 * Exercise 1.1.29
 */
public class EqualKeys {
    
    public static int rank(int[] array, int n) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] >= n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static int count(int[] array, int n) {
        int idx = BinarySearch.rank(array, n);
        if (idx < 0) {
            return 0;
        }

        int count = 1;

        int i = idx - 1;
        // count equal elements on the left
        while (i >= 0 && array[i--] == n) {
            count++;
        }

        i = idx + 1;
        // count equal elements on the right
        while (i < array.length && array[i++] == n) {
            count++;
        }

        return count;
    }
}
