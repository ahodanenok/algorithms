package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumFasterTest {

    @Test
    public void testEmpty() {
        assertEquals(0, ThreeSumFaster.count(new int[0]));
    }

    @Test
    public void testSingleItem() {
        assertEquals(0, ThreeSumFaster.count(new int[] { 5 }));
    }

    @Test
    public void testTwoItems() {
        assertEquals(0, ThreeSumFaster.count(new int[] { 5, 6 }));
        assertEquals(0, ThreeSumFaster.count(new int[] { 6, -6 }));
    }

    @Test
    public void testThreeItems() {
        assertEquals(0, ThreeSumFaster.count(new int[] { 1, 2, 3 }));
        assertEquals(1, ThreeSumFaster.count(new int[] { 1, 2, -3 }));
        assertEquals(1, ThreeSumFaster.count(new int[] { -1, 2, -1 }));
    }

    @Test
    public void testZeroes() {
        assertEquals(4, ThreeSumFaster.count(new int[] { 0, 0, 0, 0 }));
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
