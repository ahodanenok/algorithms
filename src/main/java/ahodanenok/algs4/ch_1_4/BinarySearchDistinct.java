package ahodanenok.algs4.ch_1_4;

import ahodanenok.algs4.ch_1_1.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Book, exercise 1.4.21
 */
public class BinarySearchDistinct {

    public static void main(String[] args) {
        int[] numbers = new int[StdRandom.uniform(5, 15)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = StdRandom.uniform(0, 20);
        }

        int[] distinct = getDistinct(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(distinct));
        for (int i = 0; i < 3; i++) {
            int n = StdRandom.uniform(0, 20);
            System.out.printf("contains %d: %s%n", n, BinarySearch.rank(distinct, n) != -1);
        }
    }

    private static int[] getDistinct(int[] numbers) {
        int[] distinct = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(distinct);

        int lastIdx = 0;
        for (int i = 1; i < distinct.length; i++) {
            if (distinct[lastIdx] != distinct[i]) {
                distinct[++lastIdx] = distinct[i];
            }
        }

        if (lastIdx + 1 < distinct.length) {
            distinct = Arrays.copyOf(distinct, lastIdx + 1);
        }

        return distinct;
    }
}
