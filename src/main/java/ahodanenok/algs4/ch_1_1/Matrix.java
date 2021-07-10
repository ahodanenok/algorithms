package ahodanenok.algs4.ch_1_1;

import java.util.stream.IntStream;

/**
 * Exercise 1.1.33
 */
public class Matrix {

    private static final double[] EMPTY_VECTOR = new double[0];
    private static final double[][] EMPTY_MATRIX = new double[0][0];

    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vectors have different lengths");
        }

        return IntStream.range(0, x.length).mapToDouble(i -> x[i] * y[i]).sum();
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        double[][] t = transpose(b);

        int rows = a.length;
        int cols = t.length;

        double[][] result = new double[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[row][col] = dot(a[row], t[col]);
            }
        }

        return result;
    }

    public static double[][] transpose(double[][] a) {
        if (a.length == 0) {
            return EMPTY_MATRIX;
        }

        int rows = a[0].length;
        int cols = a.length;

        double[][] t = new double[rows][cols];
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                t[row][col] = a[col][row];
            }
        }

        return t;
    }

    public static double[] multiply(double[][] a, double[] x) {
        double[][] result = multiply(a, toColumnMatrix(x));
        if (result.length == 0) {
            return EMPTY_VECTOR;
        }

        return transpose(result)[0];
    }

    public static double[] multiply(double[] y, double[][] b) {
        double[][] result = multiply(toRowMatrix(y), b);
        if (result.length == 0) {
            return EMPTY_VECTOR;
        }

        return result[0];
    }

    // [a1, a2, a3] -> [[a1, a2, a3]]
    private static double[][] toRowMatrix(double[] a) {
        double[][] m = new double[1][];
        m[0] = a;
        return m;
    }

    // [a1, a2, a3] -> [[a1], [a2], [a3]]
    private static double[][] toColumnMatrix(double[] a) {
        return transpose(toRowMatrix(a));
    }
}
