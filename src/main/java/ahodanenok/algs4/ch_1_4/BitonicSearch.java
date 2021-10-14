package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.20
 */
public class BitonicSearch {

    public static int find(int[] numbers, int n) {
        if (numbers.length == 0) {
            return -1;
        }

        int maxIdx = binaryMax(numbers);
        if (numbers[maxIdx] == n) {
            return maxIdx;
        }

        int idx = binarySearchLeft(numbers, n, maxIdx);
        if (idx != -1) {
            return idx;
        }

        return binarySearchRight(numbers, n, maxIdx);
    }

    private static int binaryMax(int[] numbers) {
        int from = 0;
        int to = numbers.length - 1;
        while (from != to) {
            int mid = from + (to - from) / 2;
            if (numbers[mid + 1] > numbers[mid]) {
                from = mid + 1;
            } else {
                to = mid;
            }
        }

        return from;
    }

    private static int binarySearchLeft(int[] numbers, int n, int maxIdx) {
        int from = 0;
        int to = maxIdx - 1;
        while (from <= to) {
            int mid = from + (to - from) / 2;
            if (numbers[mid] < n) {
                from = mid + 1;
            } else if (numbers[mid] > n) {
                to = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static int binarySearchRight(int[] numbers, int n, int maxIdx) {
        int from = maxIdx + 1;
        int to = numbers.length - 1;
        while (from <= to) {
            int mid = from + (to - from) / 2;
            if (numbers[mid] < n) {
                to = mid - 1;
            } else if (numbers[mid] > n) {
                from = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
