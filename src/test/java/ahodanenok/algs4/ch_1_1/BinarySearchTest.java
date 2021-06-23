package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void testEmptyArray() {
        assertEquals(-1, BinarySearch.rank(new int[0], 0));
    }

    @Test
    public void testSingleItemArrayNotFound() {
        assertEquals(-1, BinarySearch.rank(new int[] { 5 }, 6));
    }

    @Test
    public void testSingleItemArrayFound() {
        assertEquals(0, BinarySearch.rank(new int[] { 5 }, 5));
    }

    @Test
    public void testAllEqualNotFound() {
        assertEquals(-1, BinarySearch.rank(new int[] { 3, 3, 3, 3 }, 1));
    }

    @Test
    public void testAllEqualFound() {
        int idx = BinarySearch.rank(new int[] { 3, 3, 3, 3 }, 3);
        assertTrue(idx >= 0);
        assertTrue(idx < 4);
    }

    @Test
    public void testNotFound() {
        assertEquals(-1, BinarySearch.rank(new int[] { 2, 5, 7, 33, 127 }, 8));
    }

    @Test
    public void testFoundStart() {
        assertEquals(0, BinarySearch.rank(new int[] { 2, 5, 7, 33, 127 }, 2));
    }

    @Test
    public void testFoundMiddle() {
        assertEquals(2, BinarySearch.rank(new int[] { 2, 5, 7, 33, 127 }, 7));
    }

    @Test
    public void testFoundEnd() {
        assertEquals(4, BinarySearch.rank(new int[] { 2, 5, 7, 33, 127 }, 127));
    }

    @Test
    public void testRightBounded() {
        int[] array = new int[] { 10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98 };
        assertEquals(12, BinarySearch.rank(array, 77));
    }
}
