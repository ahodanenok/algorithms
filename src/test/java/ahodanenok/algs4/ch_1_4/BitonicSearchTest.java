package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitonicSearchTest {

    @Test
    public void testEmpty() {
        assertEquals(-1, BitonicSearch.find(new int[0], 10));
    }

    @Test
    public void testOneItem() {
        assertEquals(-1, BitonicSearch.find(new int[] { 3 }, 2));
        assertEquals(0, BitonicSearch.find(new int[] { 3 }, 3));
    }

    @Test
    public void testTwoItems() {
        assertEquals(-1, BitonicSearch.find(new int[] { 4, 6 }, 3));
        assertEquals(0, BitonicSearch.find(new int[] { 4, 6 }, 4));
        assertEquals(-1, BitonicSearch.find(new int[] { 4, 6 }, 5));
        assertEquals(1, BitonicSearch.find(new int[] { 4, 6 }, 6));
        assertEquals(-1, BitonicSearch.find(new int[] { 4, 6 }, 7));
    }

    @Test
    public void testThreeItemsIncreasing() {
        assertEquals(-1, BitonicSearch.find(new int[] { 3, 5, 7 }, 2));
        assertEquals(0, BitonicSearch.find(new int[] { 3, 5, 7 }, 3));
        assertEquals(-1, BitonicSearch.find(new int[] { 3, 5, 7 }, 4));
        assertEquals(1, BitonicSearch.find(new int[] { 3, 5, 7 }, 5));
        assertEquals(-1, BitonicSearch.find(new int[] { 3, 5, 7 }, 6));
        assertEquals(2, BitonicSearch.find(new int[] { 3, 5, 7 }, 7));
        assertEquals(-1, BitonicSearch.find(new int[] { 3, 5, 7 }, 8));
    }

    @Test
    public void testThreeItemsDecreasing() {
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3 }, 2));
        assertEquals(2, BitonicSearch.find(new int[] { 7, 5, 3 }, 3));
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3 }, 4));
        assertEquals(1, BitonicSearch.find(new int[] { 7, 5, 3 }, 5));
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3 }, 6));
        assertEquals(0, BitonicSearch.find(new int[] { 7, 5, 3 }, 7));
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3 }, 8));
    }

    @Test
    public void testFourItemsIncreasing() {
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 0));
        assertEquals(0, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 1));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 2));
        assertEquals(1, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 3));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 4));
        assertEquals(2, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 5));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 6));
        assertEquals(3, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 7));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 3, 5, 7 }, 8));
    }

    @Test
    public void testFourItemsDecreasing() {
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 0));
        assertEquals(3, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 1));
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 2));
        assertEquals(2, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 3));
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 4));
        assertEquals(1, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 5));
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 6));
        assertEquals(0, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 7));
        assertEquals(-1, BitonicSearch.find(new int[] { 7, 5, 3, 1 }, 8));
    }

    @Test
    public void testFourItemsPeakSecond() {
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 0));
        assertEquals(0, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 1));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 2));
        assertEquals(3, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 3));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 4));
        assertEquals(2, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 5));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 6));
        assertEquals(1, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 7));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 7, 5, 3 }, 8));
    }

    @Test
    public void testFourItemsPeakThird() {
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 0));
        assertEquals(0, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 1));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 2));
        assertEquals(3, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 3));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 4));
        assertEquals(1, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 5));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 6));
        assertEquals(2, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 7));
        assertEquals(-1, BitonicSearch.find(new int[] { 1, 5, 7, 3 }, 8));
    }

    @Test
    public void testFiveItemsPeakSecond() {
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 1));
        assertEquals(0, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 2));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 3));
        assertEquals(4, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 4));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 5));
        assertEquals(3, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 6));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 7));
        assertEquals(2, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 8));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 9));
        assertEquals(1, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 10));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 10, 8, 6, 4 }, 11));
    }

    @Test
    public void testFiveItemsPeakThird() {
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 1));
        assertEquals(0, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 2));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 3));
        assertEquals(4, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 4));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 5));
        assertEquals(3, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 6));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 7));
        assertEquals(1, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 8));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 9));
        assertEquals(2, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 10));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 8, 10, 6, 4 }, 11));
    }

    @Test
    public void testFiveItemsPeakFourth() {
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 1));
        assertEquals(0, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 2));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 3));
        assertEquals(4, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 4));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 5));
        assertEquals(1, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 6));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 7));
        assertEquals(2, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 8));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 9));
        assertEquals(3, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 10));
        assertEquals(-1, BitonicSearch.find(new int[] { 2, 6, 8, 10, 4 }, 11));
    }
}
