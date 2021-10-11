package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalMinimumMatrixTest {

    @Test
    public void testEmpty() {
        assertNull(LocalMinimumMatrix.find(new int[0][0]));
    }

    @Test
    public void testOneOne() {
        assertNull(LocalMinimumMatrix.find(new int[][] {{ 1 }}));
    }

    @Test
    public void testTwoTwo() {
        assertNull(LocalMinimumMatrix.find(new int[][] {{ 1, 2 }, { 3, 4 }}));
    }

    @Test
    public void testThreeThree() {
        assertNull(LocalMinimumMatrix.find(new int[][] {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }}));
        assertEquals(new LocalMinimumMatrix.Minimum(1, 1), LocalMinimumMatrix.find(new int[][] {{ 7, 8, 5 }, { 9, 6, 11 }, { 5, 22, 3 }}));
    }

    @Test
    public void testFiveFive() {
        assertEquals(new LocalMinimumMatrix.Minimum(1, 1), LocalMinimumMatrix.find(new int[][] {
            { 11, 13,  8, 22, 14 },
            { 17,  2,  4,  5, 18 },
            { 29, 15,  7, 25, 37 },
            { 32, 62,  9, 21, 54 },
            { 43, 33, 12, 38, 76 },
        }));

        assertEquals(new LocalMinimumMatrix.Minimum(1, 3), LocalMinimumMatrix.find(new int[][] {
            { 11, 13,  8, 22, 14 },
            { 17,  3,  2,  1, 18 },
            { 29,  4,  7, 11, 37 },
            { 32,  5,  6, 27, 54 },
            { 43, 33, 12, 38, 76 },
        }));

        assertEquals(new LocalMinimumMatrix.Minimum(3, 1), LocalMinimumMatrix.find(new int[][] {
            { 11, 13,  8, 22, 14 },
            { 17,  6,  8,  1, 18 },
            { 29,  4,  7, 11, 37 },
            { 32,  3,  9, 27, 54 },
            { 43, 33, 12, 38, 76 },
        }));
    }

    @Test
    public void testSixSix() {
        assertEquals(new LocalMinimumMatrix.Minimum(4, 2), LocalMinimumMatrix.find(new int[][] {
            { 11, 13,  8, 22, 14, 76 },
            { 17,  4,  5,  6, 18, 66 },
            { 29,  3,  7, 10, 37, 93 },
            { 32,  2,  9, 11, 54, 82 },
            { 31,  1, -1, 21, 55, 81 },
            { 43, 33, 12, 38, 76, 68 },
        }));
    }
}
