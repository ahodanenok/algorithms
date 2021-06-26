package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesTest {

    @Test
    public void testEmpty() {
        assertArrayEquals(new int[0], Whitelist.removeDuplicates(new int[0]));
    }

    @Test
    public void testSingleElement() {
        assertArrayEquals(new int[] { 100 }, Whitelist.removeDuplicates(new int[] { 100 }));
    }

    @Test
    public void testTwoEqualElements() {
        assertArrayEquals(new int[] { 5 }, Whitelist.removeDuplicates(new int[] { 5, 5 }));
    }

    @Test
    public void testTwoDifferentElements() {
        assertArrayEquals(new int[] { 7, 8 }, Whitelist.removeDuplicates(new int[] { 7, 8 }));
    }

    @Test
    public void testAllEqualElements() {
        assertArrayEquals(new int[] { 4 }, Whitelist.removeDuplicates(new int[] { 4, 4, 4, 4, 4 }));
    }

    @Test
    public void testAllDifferentElements() {
        assertArrayEquals(
            new int[] { 3, 7, 21, 33, 54, 78, 113 }, 
            Whitelist.removeDuplicates(new int[] { 3, 7, 21, 33, 54, 78, 113 }));
    }

    @Test
    public void testDuplicatesStart() {
        assertArrayEquals(
            new int[] { 1, 7, 9, 11 }, 
            Whitelist.removeDuplicates(new int[] { 1, 1, 1, 7, 9, 11 }));
    }

    @Test
    public void testDuplicatesMiddle() {
        assertArrayEquals(
            new int[] { 1, 7, 8, 9, 11 }, 
            Whitelist.removeDuplicates(new int[] { 1, 7, 8, 8, 8, 8, 8, 9, 11  }));
    }

    @Test
    public void testDuplicatesEnd() {
        assertArrayEquals(
            new int[] { 1, 7, 9, 11 }, 
            Whitelist.removeDuplicates(new int[] { 1, 7, 9, 11, 11, 11, 11  }));
    }
}
