package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FurthestPointTest {

    @Test
    public void testEmpty() {
        assertNull(FurthestPoint.find(new double[0]));
    }

    @Test
    public void testOneItem() {
        assertNull(FurthestPoint.find(new double[] { 10 }));
    }

    @Test
    public void testTwoItems() {
        assertEquals(new Pair(1, 2), FurthestPoint.find(new double[] { 1, 2 }));
        assertEquals(new Pair(3, 4), FurthestPoint.find(new double[] { 4, 3 }));
    }

    @Test
    public void testSameItems() {
        assertEquals(new Pair(1, 1), FurthestPoint.find(new double[] { 1, 1 }));
        assertEquals(new Pair(0, 0), FurthestPoint.find(new double[] { 0, 0, 0 }));
        assertEquals(new Pair(3, 3), FurthestPoint.find(new double[] { 3, 3, 3, 3 }));
    }

    @Test
    public void testThreeItems() {
        assertEquals(new Pair(1, 3), FurthestPoint.find(new double[] { 1, 2, 3 }));
        assertEquals(new Pair(1, 3), FurthestPoint.find(new double[] { 3, 2, 1 }));
        assertEquals(new Pair(-1, 2), FurthestPoint.find(new double[] { -1, 2, 1 }));
        assertEquals(new Pair(-10, 2), FurthestPoint.find(new double[] { 2, -5, -10 }));
    }

    @RepeatedTest(1000)
    public void testRandom() {
        double[] numbers = new double[StdRandom.uniform(50, 100)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = StdRandom.uniform(-100, 100);
        }
        Arrays.sort(numbers);

        Pair expected = null;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                Pair p = new Pair(numbers[i], numbers[j]);
                if (expected == null || p.distance() > expected.distance()) {
                    expected = p;
                }
            }
        }

        assertEquals(expected, FurthestPoint.find(numbers));
    }
}
