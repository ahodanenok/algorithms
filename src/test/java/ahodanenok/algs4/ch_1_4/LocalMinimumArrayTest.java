package ahodanenok.algs4.ch_1_4;

import ahodanenok.algs4.ch_1_3.IntegerSet;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

public class LocalMinimumArrayTest {

    @Test
    public void testEmpty() {
        assertEquals(-1, LocalMinimumArray.find(new int[0]));
    }

    @Test
    public void testOneItem() {
        assertEquals(-1, LocalMinimumArray.find(new int[] { 15 }));
    }

    @Test
    public void testTwoItems() {
        assertEquals(-1, LocalMinimumArray.find(new int[] { 3, 4 }));
    }

    @Test
    public void testThreeItems() {
        assertEquals(-1, LocalMinimumArray.find(new int[] { 1, 2, 3 }));
        assertEquals(1, LocalMinimumArray.find(new int[] { 2, 1, 3 }));
        assertEquals(-1, LocalMinimumArray.find(new int[] { 2, 3, 1 }));
    }

    @Test
    public void testMultipleItems() {
        assertEquals(-1, LocalMinimumArray.find(new int[] { 1, 4, 5, 7 }));
        assertEquals(3, LocalMinimumArray.find(new int[] { 1, 5, 3, 2, 4 }));
        assertEquals(1, LocalMinimumArray.find(new int[] { 10, 7, 8, 5, 4 }));
        assertEquals(4, LocalMinimumArray.find(new int[] { 10, 9, 8, 5, 4, 6 }));
    }

    @RepeatedTest(1000)
    public void testRandom() {
        int[] numbers = new int[StdRandom.uniform(3, 10)];
        BitSet seen = new BitSet();
        for (int i = 0; i < numbers.length; i++) {
            int n;
            do {
                n = StdRandom.uniform(1, 10);
            } while (seen.get(n));

            numbers[i] = n;
            seen.set(n);
        }
        numbers[0] = 11;
        numbers[numbers.length - 1] = 12;

        int minIdx = LocalMinimumArray.find(numbers);
        if (minIdx >= 0) {
            assertTrue(minIdx > 0, () -> Arrays.toString(numbers));
            assertTrue(minIdx < numbers.length - 1, () -> Arrays.toString(numbers));
            assertTrue(numbers[minIdx - 1] > numbers[minIdx], () -> Arrays.toString(numbers));
            assertTrue(numbers[minIdx + 1] > numbers[minIdx], () -> Arrays.toString(numbers));
        } else {
            for (int i = 1, len = numbers.length - 1; i < len; i++) {
                assertFalse(numbers[i - 1] > numbers[i] && numbers[i + 1] > numbers[i], () -> Arrays.toString(numbers));
            }
        }
    }
}
