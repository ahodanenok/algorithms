package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.10
 */
public class BinarySearchMin {

    public static int search(int[] numbers, int n) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] >= n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo - 1 >= 0 && numbers[lo - 1] == n) {
            return lo - 1;
        }

        if (lo < numbers.length && numbers[lo] == n) {
            return lo;
        }

        if (lo + 1 < numbers.length && numbers[lo + 1] == n) {
            return lo + 1;
        }

        return -1;
    }
}
