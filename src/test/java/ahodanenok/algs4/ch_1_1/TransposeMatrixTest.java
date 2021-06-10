package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransposeMatrixTest {

    @Test
    public void testEmpty() {
        assertArrayEquals(new int[0][0], TransposeMatrix.transpose(new int[0][0]));
    }

    @Test
    public void testSingleElement() {
        assertArrayEquals(new int[][] {{ 1 }}, TransposeMatrix.transpose(new int[][] {{ 1 }}));
    }

    @Test
    public void testOneRow() {
        assertArrayEquals(
            new int[][] {
                { 1, 2, 3, 4, 5 }
            },
            TransposeMatrix.transpose(new int[][] {
                { 1 },
                { 2 },
                { 3 },
                { 4 },
                { 5 }
            }));
    }

    @Test
    public void testOneColumn() {
        assertArrayEquals(
            new int[][] {
                { 1 },
                { 2 },
                { 3 },
                { 4 },
                { 5 }
            },
            TransposeMatrix.transpose(new int[][] {
                { 1, 2, 3, 4, 5 }
            }));
    }

    @Test
    public void testSquare() {
        assertArrayEquals(
            new int[][] {
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 3, 6, 9 }
            },
            TransposeMatrix.transpose(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
            }));
    }

    @Test
    public void testColumnsMoreThanRows() {
        assertArrayEquals(
            new int[][] {
                { 1, 5 },
                { 2, 6 },
                { 3, 7 },
                { 4, 8 }
            },
            TransposeMatrix.transpose(new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 }
            }));
    }

    @Test
    public void testRowsMoreThanColumns() {
        assertArrayEquals(
            new int[][] {
                { 1, 3, 5, 7 },
                { 2, 4, 6, 8 }
            },
            TransposeMatrix.transpose(new int[][] {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 },
                { 7, 8 }
            }));
    }
}
