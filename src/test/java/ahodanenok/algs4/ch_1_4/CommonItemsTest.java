package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CommonItemsTest {

    @Test
    public void testEmpty() {
        assertEquals(0, CommonItems.count(new int[0], new int[0]).size());
        assertEquals(0, CommonItems.count(new int[0], new int[] { 2, 4, 5 }).size());
        assertEquals(0, CommonItems.count(new int[] { 1, 2, 3}, new int[0]).size());
    }

    @Test
    public void testFirstShorter() {
        assertEquals(Arrays.asList(), CommonItems.count(new int[] { 4, 5 }, new int[] { 3, 7, 9 }));
        assertEquals(Arrays.asList(4), CommonItems.count(new int[] { 4, 5 }, new int[] { 1, 2, 3, 4 }));
        assertEquals(Arrays.asList(5), CommonItems.count(new int[] { 4, 5 }, new int[] { 2, 5, 7, 10, 11 }));
    }

    @Test
    public void testSecondShorter() {
        assertEquals(Arrays.asList(1), CommonItems.count(new int[] { 1, 2, 3 }, new int[] { 1 }));
        assertEquals(Arrays.asList(1, 2), CommonItems.count(new int[] { 1, 2, 3 }, new int[] { 1, 2 }));
        assertEquals(Arrays.asList(), CommonItems.count(new int[] { 1, 2, 3 }, new int[] { 4 }));
        assertEquals(Arrays.asList(2), CommonItems.count(new int[] { 1, 2, 3 }, new int[] { 2 }));
        assertEquals(Arrays.asList(2, 3), CommonItems.count(new int[] { 1, 2, 3 }, new int[] { 2, 3 }));
    }

    @Test
    public void testSameItems() {
        assertEquals(Arrays.asList(2), CommonItems.count(new int[] { 2 }, new int[] { 2 }));
        assertEquals(Arrays.asList(2, 2), CommonItems.count(new int[] { 2, 2 }, new int[] { 2, 2 }));
        assertEquals(Arrays.asList(2, 2, 2), CommonItems.count(new int[] { 2, 2, 2 }, new int[] { 2, 2, 2 }));
        assertEquals(Arrays.asList(2, 2), CommonItems.count(new int[] { 2, 2, 2 }, new int[] { 2, 2 }));
        assertEquals(Arrays.asList(2, 2), CommonItems.count(new int[] { 2, 2 }, new int[] { 2, 2, 2 }));
    }
}
