package ahodanenok.algs4.ch_1_4;

import java.util.Arrays;
import java.util.Map;

/**
 * Book, exercise 1.4.15
 */
public class ThreeSumFaster {

    public static int count(int[] numbers) {
        Arrays.sort(numbers);
        Map<Integer, TwoSumFaster.SameRange> ranges = TwoSumFaster.calculateRanges(numbers);

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                TwoSumFaster.SameRange range = ranges.get(-numbers[i] - numbers[j]);
                if (range != null && j < range.to) {
                    // using max to take zeroes range into account
                    // all other ranges do not intersect
                    count += (range.to - Math.max(range.from, j + 1));
                }
            }
        }

        return count;
    }
}
