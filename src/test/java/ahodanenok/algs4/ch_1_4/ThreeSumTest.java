package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumTest {

    @Test
    public void testEmpty() {
        assertEquals(0, ThreeSum.count(new int[0]));
    }

    @Test
    public void testNoPairs() {
        assertEquals(0, ThreeSum.count(new int[] { 4, -4 }));
        assertEquals(0, ThreeSum.count(new int[] { 1, 2, 3 }));
        assertEquals(0, ThreeSum.count(new int[] { 1, -1, 1, -1, 1 }));
        assertEquals(0, ThreeSum.count(new int[] { -2_000_000_000, -2_000_000_000, -294967296 }));
        assertEquals(0, ThreeSum.count(new int[] { 2_000_000_000, 2_000_000_000, 294967296 }));
    }

    @Test
    public void testHasPairs() {
        assertEquals(1, ThreeSum.count(new int[] { 1, 1, -2 }));
        assertEquals(2, ThreeSum.count(new int[] { 1, 2, 3, -5, -3 }));
        assertEquals(10, ThreeSum.count(new int[] { 0, 0, 0, 0, 0 }));
    }

    @RepeatedTest(1000)
    public void testWithRI() {
        int[] numbers = new int[StdRandom.uniform(50, 100)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = StdRandom.uniform(-20, 20);
        }

        int expected = edu.princeton.cs.algs4.ThreeSum.count(numbers);
        int actual = ThreeSum.count(numbers);
        assertEquals(expected, actual, () -> Arrays.toString(numbers));
    }
}
