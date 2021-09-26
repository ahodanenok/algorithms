package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Book, exercise 1.4.8
 */
public class EqualPairs {

    public static void main(String[] args) {
        int[] numbers = StdIn.readAllInts();
        if (numbers.length <= 20) {
            System.out.println("Numbers:     " + Arrays.toString(numbers));
        }
        System.out.println("Equal pairs: " + count(numbers));
    }

    public static int count(int[] numbers) {
        int count = 0;

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int j = lastIndexOf(numbers, i);
            count += (j - i);
        }

        return count;
    }

    private static int lastIndexOf(int[] numbers, int idx) {
        int from = idx;
        int to = numbers.length - 1;
        int n = numbers[idx];

        while (to > from) {
            int mid = from + (to - from) / 2;
            if (numbers[mid] > n) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }

        if (numbers[from] > n) {
            return Math.max(idx, from - 1);
        } else {
            return from;
        }
    }
}
