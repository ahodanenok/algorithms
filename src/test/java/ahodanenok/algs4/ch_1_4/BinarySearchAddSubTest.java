package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchAddSubTest {

    @Test
    public void testEmpty() {
        assertEquals(-1, BinarySearchAddSub.find(new int[0], 1));
    }

    @Test
    public void testOneItem() {
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3 }, 2));
        assertEquals(0, BinarySearchAddSub.find(new int[] { 3 }, 3));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3 }, 4));
    }

    @Test
    public void testTwoItems() {
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 4, 6 }, 3));
        assertEquals(0, BinarySearchAddSub.find(new int[] { 4, 6 }, 4));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 4, 6 }, 5));
        assertEquals(1, BinarySearchAddSub.find(new int[] { 4, 6 }, 6));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 4, 6 }, 7));
    }

    @Test
    public void testThreeItems() {
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7 }, 2));
        assertEquals(0, BinarySearchAddSub.find(new int[] { 3, 5, 7 }, 3));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7 }, 4));
        assertEquals(1, BinarySearchAddSub.find(new int[] { 3, 5, 7 }, 5));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7 }, 6));
        assertEquals(2, BinarySearchAddSub.find(new int[] { 3, 5, 7 }, 7));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7 }, 8));
    }

    @Test
    public void testFourItems() {
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 2));
        assertEquals(0, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 3));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 4));
        assertEquals(1, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 5));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 6));
        assertEquals(2, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 7));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 8));
        assertEquals(3, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 9));
        assertEquals(-1, BinarySearchAddSub.find(new int[] { 3, 5, 7, 9 }, 10));
    }

    @RepeatedTest(1000)
    public void testRandom() {
        int length = StdRandom.uniform(50, 1000);
        Set<Integer> set = new HashSet<>();
        while (set.size() < length) {
            set.add(StdRandom.uniform(0, 2000));
        }

        int i = 0;
        int[] numbers = new int[set.size()];
        for (int n : set) {
            numbers[i++] = n;
        }
        Arrays.sort(numbers);

        for (int j = 0; j < numbers.length; j++) {
            assertEquals(j, BinarySearchAddSub.find(numbers, numbers[j]));
            if (j == 0 || numbers[j] - 1 != numbers[j - 1]) {
                assertEquals(-1, BinarySearchAddSub.find(numbers, numbers[j] - 1));
            }
            if (j + 1 == numbers.length || numbers[j] + 1 != numbers[j + 1]) {
                assertEquals(-1, BinarySearchAddSub.find(numbers, numbers[j] + 1));
            }
        }
    }
}
