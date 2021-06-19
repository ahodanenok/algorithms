package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HistogramTest {

    @Test
    public void testEmptyArray() {
        int[] h = Histogram.compute(new int[0], 1);
        assertEquals(1, h.length);
        assertArrayEquals(new int[1], h);
    }

    @Test
    public void testSingleItemArray() {
        int[] h = Histogram.compute(new int[] { 0 }, 1);
        assertEquals(1, h.length);
        assertArrayEquals(new int[] { 1 }, h);
    }

    @Test
    public void testZeroM() {
        assertEquals(0, Histogram.compute(new int[] { 0 }, 0).length);
    }

    @Test
    public void testAllItemsEqual() {
        int[] h = Histogram.compute(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }, 2);
        assertEquals(2, h.length);
        assertArrayEquals(new int[] { 0, 8 }, h);
    }

    @Test
    public void testAllBetweenZeroAndM() {
        int[] h = Histogram.compute(new int[] { 0, 1, 2, 3, 4 }, 5);
        assertEquals(5, h.length);
        assertArrayEquals(new int[] { 1, 1, 1, 1, 1 }, h);
        assertEquals(5, Arrays.stream(h).sum());
    }

    @Test
    public void testAllItemsGreaterThanM() {
        assertArrayEquals(new int[] { 0, 0, 0 }, Histogram.compute(new int[] { 3, 5 }, 3));
    }

    @Test
    public void testSomeItemsLowerThanM() {
        assertArrayEquals(new int[] { 1, 0, 1 }, Histogram.compute(new int[] { 0, 2, 5 }, 3));
    }

    @Test
    public void testLargeArrayAllZero() {
        int[] h = Histogram.compute(new int[100_000_000], 100);
        assertEquals(100, h.length);
        assertEquals(100_000_000, h[0]);
    }

    @Test
    public void testLargeArrayAllBetweenZeroAndM() {
        int[] array = new int[100_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int[] h = Histogram.compute(array, 100_000_000);
        assertEquals(100_000_000, h.length);
        for (int value : h) {
            assertEquals(1, value);
        }
    }
}
