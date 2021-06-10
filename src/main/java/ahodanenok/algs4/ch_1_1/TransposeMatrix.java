package ahodanenok.algs4.ch_1_1;

import java.util.Arrays;

/**
 * Exercise 1.1.13
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 2, 3, 4, 5 },
            { 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15 }
        };

        int[][] transposed = transpose(matrix);
        for (int[] row : transposed) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int[][] transpose(int[][] matrix) {
        int rowsCount = matrix.length;
        int columnsCount = rowsCount > 0 ? matrix[0].length : 0;

        int[][] result = new int[columnsCount][rowsCount];
        for (int c = 0; c < columnsCount; c++) {
            for (int r = 0; r < rowsCount; r++) {
                result[c][r] = matrix[r][c];
            }
        }

        return result;
    }
}

