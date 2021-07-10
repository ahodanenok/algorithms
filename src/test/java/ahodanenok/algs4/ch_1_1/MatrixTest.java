package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void testDotProductThrowsExceptionWhenDifferentLengths() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix.dot(new double[] { 1 }, new double[] { 2, 3 }));

        assertEquals("Vectors have different lengths", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getDotProductData")
    public void testDotProduct(double[] a, double[] b, double p) {
        assertEquals(p, Matrix.dot(a, b));
    }

    private static Stream<Arguments> getDotProductData() {
        return Stream.of(
                Arguments.of(new double [0], new double[0], 0),
                Arguments.of(new double [] { 0 }, new double[] { 0 }, 0),
                Arguments.of(new double [] { 2 }, new double[] { 3 }, 6),
                Arguments.of(new double [] { 1, 2, 3 }, new double[] { 4, 5, 6 }, 32));
    }

    @ParameterizedTest
    @MethodSource("getTransposeData")
    public void testTranspose(double[][] a, double[][] t) {
        assertArrayEquals(t, Matrix.transpose(a));
    }

    private static Stream<Arguments> getTransposeData() {
        return Stream.of(
                Arguments.of(new double[0][], new double[0][]),
                Arguments.of(new double[][] {{ 10 }}, new double[][] {{ 10 }}),
                Arguments.of(
                    new double[][] {
                        { 1, 2 },
                        { 3, 4 }
                    },
                    new double[][] {
                        { 1, 3 },
                        { 2, 4 }
                    }
                ),
                Arguments.of(
                    new double[][] {
                        { 7, 9, 11 },
                        { 8, 10, 12 }
                    },
                    new double[][] {
                        { 7, 8 },
                        { 9, 10 },
                        { 11, 12 }
                    }
                ),
                Arguments.of(
                    new double[][] {
                        { 7, 8 },
                        { 9, 10 },
                        { 11, 12 }
                    },
                    new double[][] {
                        { 7, 9, 11 },
                        { 8, 10, 12 }
                    }
                ));
    }

    @ParameterizedTest
    @MethodSource("getMultiplyData")
    public void testMultiply(double[][] a, double[][] b, double[][] result) {
        assertArrayEquals(result, Matrix.multiply(a, b));
    }

    private static Stream<Arguments> getMultiplyData() {
        return Stream.of(
                Arguments.of(new double[0][], new double[0][], new double[0][0]),
                Arguments.of(new double[][] {{ 10 }}, new double[][] {{ 10 }}, new double[][] {{ 100 }}),
                Arguments.of(
                    new double[][] {
                        { 1, 2 },
                        { 3, 4 }
                    },
                    new double[][] {
                        { 0, 0 },
                        { 0, 0 }
                    },
                    new double[][] {
                        { 0, 0 },
                        { 0, 0 }
                    }
                ),
                Arguments.of(
                    new double[][] {
                        { 0, 0 },
                        { 0, 0 }
                    },
                    new double[][] {
                        { 1, 2 },
                        { 3, 4 }
                    },
                    new double[][] {
                        { 0, 0 },
                        { 0, 0 }
                    }
                ),
                Arguments.of(
                    new double[][] {
                        { 1, 2 },
                        { 3, 4 }
                    },
                    new double[][] {
                        { 2, 0 },
                        { 1, 2 }
                    },
                    new double[][] {
                        { 4, 4 },
                        { 10, 8 }
                    }
                ),
                Arguments.of(
                    new double[][] {
                        { 2, 0 },
                        { 1, 2 }
                    },
                    new double[][] {
                        { 1, 2 },
                        { 3, 4 }
                    },
                    new double[][] {
                        { 2, 4 },
                        { 7, 10 }
                    }
                ),
                Arguments.of(
                    new double[][] {
                        { 1, 2, 3 },
                        { 4, 5, 6 }
                    },
                    new double[][] {
                        { 7, 8 },
                        { 9, 10 },
                        { 11, 12 }
                    },
                    new double[][] {
                        { 58, 64 },
                        { 139, 154 }
                    }
                ),
                Arguments.of(
                    new double[][] {
                        { 1, 2 },
                        { 3, 4 },
                        { 5, 6 }
                    },
                    new double[][] {
                        { 7, 8, 9 },
                        { 10, 11, 12 }
                    },
                    new double[][] {
                        { 27, 30, 33 },
                        { 61, 68, 75 },
                        { 95, 106, 117 }
                    }
                ));
    }

    @Test
    public void testMultiplySecondOneDimensionalThrowsErrorWhenIncompatibleDimensions() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Matrix.multiply(new double[][] {{ 1 }, { 2 }, { 3 }}, new double[] { 4, 5, 6 });
        });

        assertEquals("Vectors have different lengths", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getMultiplyDataSecondOneDimensional")
    public void testMultiplySecondOneDimensional(double[][] a, double[] x, double[] result) {
        assertArrayEquals(result, Matrix.multiply(a, x));
    }

    private static Stream<Arguments> getMultiplyDataSecondOneDimensional() {
        return Stream.of(
                Arguments.of(new double[0][], new double[0], new double[0]),
                Arguments.of(new double[][] {{ 10 }}, new double[] { 10 }, new double[] { 100 }),
                Arguments.of(
                    new double[][] {{ 1, 2, 3 }},
                    new double[] { 4, 5, 6 },
                    new double[] { 32 }
                ),
                Arguments.of(
                    new double[][] {{ 1, 2 }, { 3, 4 }},
                    new double[] { 5, 6 },
                    new double[] { 17, 39 }
                ),
                Arguments.of(
                    new double[][] {{ 1 }, { 2 }, { 3 }, { 4 }},
                    new double[] { 10 },
                    new double[] { 10, 20, 30, 40}
                ));
    }

    @Test
    public void testMultiplyFirstOneDimensionalThrowsErrorWhenIncompatibleDimensions() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Matrix.multiply(new double[] { 1, 2 }, new double[][] {{ 3, 4,  5, 6 }});
        });

        assertEquals("Vectors have different lengths", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getMultiplyDataFirstOneDimensional")
    public void testMultiplyFirstOneDimensional(double[] y, double[][] b, double[] result) {
        assertArrayEquals(result, Matrix.multiply(y, b));
    }

    private static Stream<Arguments> getMultiplyDataFirstOneDimensional() {
        return Stream.of(
                Arguments.of(new double[0], new double[0][], new double[0]),
                Arguments.of(new double[] { 10 }, new double[][] {{ 10 }}, new double[] { 100 }),
                Arguments.of(
                    new double[] { 1, 2 },
                    new double[][] {
                        { 3, 4 },
                        { 5, 6 }
                    },
                    new double[] { 13, 16 }
                ),
                Arguments.of(
                    new double[] { 1, 2, 3 },
                    new double[][] {
                        { 4, 5 },
                        { 6, 7 },
                        { 8, 9 }
                    },
                    new double[] { 40, 46 }
                ),
                Arguments.of(
                    new double[] { 1, 2, 3 },
                    new double[][] {
                        { 4, 5, 6 },
                        { 7, 8, 9 },
                        { 10, 11, 12 }
                    },
                    new double[] { 48, 54, 60 }
                ));
    }
}
