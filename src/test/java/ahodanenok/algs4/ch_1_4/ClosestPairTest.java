package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    public void testEmpty() {
        assertNull(ClosestPair.find(new double[0]));
    }

    @Test
    public void testSingleItem() {
        assertNull(ClosestPair.find(new double[] { 2 }));
    }

    @Test
    public void testTwoItems() {
        assertEquals(new Pair(3, 5), ClosestPair.find(new double[] { 3, 5 }));
        assertEquals(new Pair(3, 5), ClosestPair.find(new double[] { 5, 3 }));
    }

    @Test
    public void testThreeItems() {
        assertEquals(new Pair(1, 2), ClosestPair.find(new double[] { 1, 2, 3 }));
        assertEquals(new Pair(1, 3), ClosestPair.find(new double[] { 1, 6, 3 }));
        assertEquals(new Pair(4, 5), ClosestPair.find(new double[] { 1, 4, 5 }));
        assertEquals(new Pair(3, 4), ClosestPair.find(new double[] { 3, 4, 7 }));
    }

    @Test
    public void testEqual() {
        assertEquals(new Pair(0, 0), ClosestPair.find(new double[] { 0, 0, 0 }));
        assertEquals(new Pair(2, 2), ClosestPair.find(new double[] { 2, 2, 2, 2 }));
    }

    @Test
    public void testMultipleItems() {
        assertEquals(new Pair(3, 4), ClosestPair.find(new double[] { 1, 3, 4, 7 }));
        assertEquals(new Pair(1, 3), ClosestPair.find(new double[] { 1, 3, 8, 17 }));
        assertEquals(new Pair(6, 7), ClosestPair.find(new double[] { 1, 3, 6, 7, 17 }));
        assertEquals(new Pair(8, 8), ClosestPair.find(new double[] { 1, 8, 8, 9, 17 }));
        assertEquals(new Pair(16, 17), ClosestPair.find(new double[] { 1, 5, 8, 16, 17 }));
    }
}
