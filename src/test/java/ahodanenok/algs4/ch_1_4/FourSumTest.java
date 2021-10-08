package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FourSumTest {

    @Test
    public void testEmpty() {
        assertEquals(0, FourSum.count(new int[0]));
    }

    @Test
    public void testFound() {
        assertEquals(0, FourSum.count(new int[] { 1, 2, 3, -5 }));
        assertEquals(0, FourSum.count(new int[] { 1, 1, 1, 1, 1 }));
    }

    @Test
    public void testNotFound() {
        assertEquals(1, FourSum.count(new int[] { 1, 2, 3, -6 }));
        assertEquals(2, FourSum.count(new int[] { 1, 3, 2, 3, 5, -6 }));
        assertEquals(9, FourSum.count(new int[] { 1, -1, 1, -1, 1, -1 }));
    }
}
