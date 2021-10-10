package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.18
 */
public class LocalMinimumArray {

    public static int find(int[] numbers) {
        // first and last elements are sentinels
        int from = 1;
        int to = numbers.length - 2;
        while (to >= from) {
            int mid = from + (to - from) / 2;
            int n = numbers[mid];
            if (numbers[mid - 1] < n) {
                to = mid - 1;
            } else if (numbers[mid + 1] < n) {
                from = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
