package ahodanenok.algs4.ch_1_4;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Book, exercise 1.4.15
 */
public class TwoSumFaster {

    public static int count(int[] numbers) {
        Arrays.sort(numbers);
        Map<Integer, SameRange> ranges = calculateRanges(numbers);

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            SameRange range = ranges.get(-numbers[i]);
            if (range != null && i < range.to) {
                // using max to take zeroes range into account
                // all other ranges do not intersect
                count += (range.to - Math.max(range.from, i + 1));
            }
        }

        return count;
    }

    static Map<Integer, SameRange> calculateRanges(int[] numbers) {
        Map<Integer, SameRange> ranges = new LinkedHashMap<>();

        int rangeStart = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 == numbers.length || numbers[i + 1] != numbers[i]) {
                ranges.put(numbers[i], new SameRange(rangeStart, i + 1));
                rangeStart = i + 1;
            }
        }

        return ranges;
    }

    static class SameRange {

        final int from;
        final int to;

        public SameRange(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
