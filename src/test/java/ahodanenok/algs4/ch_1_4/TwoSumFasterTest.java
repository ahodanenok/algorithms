package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumFasterTest {

    @Test
    public void testEmpty() {
        assertEquals(0, TwoSumFaster.count(new int[0]));
    }

    @Test
    public void testSingleItem() {
        assertEquals(0, TwoSumFaster.count(new int[] { 5 }));
    }

    @Test
    public void testTwoItems() {
        assertEquals(0, TwoSumFaster.count(new int[] { 5, 6 }));
        assertEquals(1, TwoSumFaster.count(new int[] { 6, -6 }));
    }

    @Test
    public void testThreeItems() {
        assertEquals(0, TwoSumFaster.count(new int[] { 1, 2, 3 }));
        assertEquals(1, TwoSumFaster.count(new int[] { 1, 2, -1 }));
        assertEquals(1, TwoSumFaster.count(new int[] { -1, 2, 1 }));
        assertEquals(2, TwoSumFaster.count(new int[] { 2, -2, 2 }));
        assertEquals(2, TwoSumFaster.count(new int[] { -2, -2, 2 }));
        assertEquals(2, TwoSumFaster.count(new int[] { 2, -2, -2 }));
    }

    @Test
    public void testZeroes() {
        assertEquals(6, TwoSumFaster.count(new int[] { 0, 0, 0, 0 }));
    }

    @RepeatedTest(1000)
    public void testWithRI() {
        int[] numbers = new int[StdRandom.uniform(50, 100)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = StdRandom.uniform(-20, 20);
        }

        int expected = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == 0) {
                    expected++;
                }
            }
        }

        int actual = TwoSumFaster.count(numbers);
        assertEquals(expected, actual, () -> Arrays.toString(numbers));
    }
}
