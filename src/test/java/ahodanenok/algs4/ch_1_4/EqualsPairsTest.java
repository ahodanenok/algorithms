package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EqualsPairsTest {

    @Test
    public void testEmpty() {
        assertEquals(0, EqualPairs.count(new int[0]));
    }

    @Test
    public void testOneItem() {
        assertEquals(0, EqualPairs.count(new int[] { 1 }));
    }

    @Test
    public void testTwoItemsEqual() {
        assertEquals(1, EqualPairs.count(new int[] { 2, 2 }));
    }

    @Test
    public void testTwoItemsDifferent() {
        assertEquals(0, EqualPairs.count(new int[] { 2, 3 }));
        assertEquals(0, EqualPairs.count(new int[] { 3, 2 }));
    }

    @Test
    public void testMultipleItemsDifferent() {
        assertEquals(0, EqualPairs.count(new int[] { 2, 3, 5 }));
        assertEquals(0, EqualPairs.count(new int[] { 3, 2, 6, 7 }));
        assertEquals(0, EqualPairs.count(new int[] { 6, 3, 1, 0 }));
        assertEquals(0, EqualPairs.count(new int[] { 11, 5, 13, 2, 7 }));
    }

    @Test
    public void testMultipleItemsEqual() {
        assertEquals(3, EqualPairs.count(new int[] { 1, 1, 1 }));
        assertEquals(6, EqualPairs.count(new int[] { 2, 2, 2, 2 }));
        assertEquals(10, EqualPairs.count(new int[] { 3, 3, 3, 3, 3 }));
    }

    @Test
    public void testMultipleItemsMix() {
        assertEquals(1, EqualPairs.count(new int[] { 1, 2, 1 }));
        assertEquals(2, EqualPairs.count(new int[] { 1, 2, 3, 2, 1 }));
        assertEquals(9, EqualPairs.count(new int[] { 1, 2, 1, 2, 1, 2, 1 }));
        assertEquals(5, EqualPairs.count(new int[] { 1, 2, 1, 3, 2, 3, 1, 4 }));
    }
}
