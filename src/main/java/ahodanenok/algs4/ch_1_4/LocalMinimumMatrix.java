package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.19
 */
public class LocalMinimumMatrix {

    public static Minimum find(int[][] matrix) {
        if (matrix.length < 3) {
            return null;
        }

        int row = matrix.length / 2;
        int col = matrix.length / 2;

        Minimum min = new Minimum(row, col);
        while (!isLocalMinimum(matrix, row, col)) {
            Minimum nextMin = rollDown(matrix, min.row, min.col);
            if (nextMin.equals(min)) {
                break;
            }

            min = nextMin;
        }

        if (isLocalMinimum(matrix, min.row, min.col)) {
            return min;
        } else {
            return null;
        }
    }

    private static boolean isLocalMinimum(int[][] matrix, int row, int col) {
        int n = matrix[row][col];
        return matrix[row - 1][col] > n
                && matrix[row + 1][col] > n
                && matrix[row][col - 1] > n
                && matrix[row][col + 1] > n;
    }

    private static Minimum rollDown(int[][] matrix, int row, int col) {
        int min = matrix[row][col];
        int rowNext = row;
        int colNext = col;

        if (row - 1 > 0 && matrix[row - 1][col] < min) {
            rowNext = row - 1;
            min = matrix[row - 1][col];
        }

        if (row + 1 < matrix.length - 1 && matrix[row + 1][col] < min) {
            rowNext = row + 1;
            min = matrix[row + 1][col];
        }

        if (col - 1 > 0 && matrix[row][col - 1] < min) {
            colNext = col - 1;
            rowNext = row;
            min = matrix[row][col - 1];
        }

        if (col + 1 < matrix.length - 1 && matrix[row][col + 1] < min) {
            colNext = col + 1;
            rowNext = row;
        }

        return new Minimum(rowNext, colNext);
    }

    public static class Minimum {
        final int row;
        final int col;

        public Minimum(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            Minimum other = (Minimum) obj;
            return row == other.row && col == other.col;
        }
    }
}
