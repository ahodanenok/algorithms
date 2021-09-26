package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchMinTest {

    @Test
    public void testEmpty() {
        assertEquals(-1, BinarySearchMin.search(new int[0], 1));
    }

    @Test
    public void testOneItemFound() {
        assertEquals(-1, BinarySearchMin.search(new int[] { 2 }, 1));
        assertEquals(0, BinarySearchMin.search(new int[] { 2 }, 2));
        assertEquals(-1, BinarySearchMin.search(new int[] { 2 }, 3));
    }

    @Test
    public void testTwoItems() {
        assertEquals(-1, BinarySearchMin.search(new int[] { 2, 3 }, 1));
        assertEquals(0, BinarySearchMin.search(new int[] { 2, 3 }, 2));
        assertEquals(1, BinarySearchMin.search(new int[] { 2, 3 }, 3));
        assertEquals(-1, BinarySearchMin.search(new int[] { 2, 3 }, 4));
        assertEquals(-1, BinarySearchMin.search(new int[] { 3, 3 }, 2));
        assertEquals(0, BinarySearchMin.search(new int[] { 3, 3 }, 3));
        assertEquals(-1, BinarySearchMin.search(new int[] { 3, 3 }, 4));
    }

    @Test
    public void testThreeItems() {
        assertEquals(-1, BinarySearchMin.search(new int[] { 2, 4, 6 }, 1));
        assertEquals(0, BinarySearchMin.search(new int[] { 2, 4, 6 }, 2));
        assertEquals(-1, BinarySearchMin.search(new int[] { 2, 4, 6 }, 3));
        assertEquals(1, BinarySearchMin.search(new int[] { 2, 4, 6 }, 4));
        assertEquals(-1, BinarySearchMin.search(new int[] { 2, 4, 6 }, 5));
        assertEquals(2, BinarySearchMin.search(new int[] { 2, 4, 6 }, 6));
        assertEquals(-1, BinarySearchMin.search(new int[] { 2, 4, 6 }, 7));
        assertEquals(-1, BinarySearchMin.search(new int[] { 3, 3, 3 }, 2));
        assertEquals(0, BinarySearchMin.search(new int[] { 3, 3, 3 }, 3));
        assertEquals(1, BinarySearchMin.search(new int[] { 2, 3, 3 }, 3));
        assertEquals(-1, BinarySearchMin.search(new int[] { 3, 3, 3 }, 4));
    }

    @RepeatedTest(1000)
    public void testRandom() {
        int[] numbers = new int[StdRandom.uniform(10, 50)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = StdRandom.uniform(0, numbers.length / 2);
        }

        Arrays.sort(numbers);
        for (int n : numbers) {
            int expectedIdx = 0;
            while (numbers[expectedIdx] != n) expectedIdx++;

            assertEquals(expectedIdx, BinarySearchMin.search(numbers, n));
        }
    }
}
