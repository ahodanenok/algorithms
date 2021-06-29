package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EqualKeysTest {

    @ParameterizedTest
    @MethodSource("countSmallerTestData")
    public void testCountSmaller(int[] array, int n, int expected) {
        Assertions.assertEquals(expected, EqualKeys.rank(array, n));
    }

    private static Stream<Arguments> countSmallerTestData() {
        return Stream.of(
                Arguments.of(new int[0], 0, 0),
                Arguments.of(new int[0], 1, 0),

                Arguments.of(new int[] { 1 }, 0, 0),
                Arguments.of(new int[] { 1 }, 1, 0),
                Arguments.of(new int[] { 1 }, 2, 1),

                Arguments.of(new int[] { 1, 1, 1, 1, 1 }, 0, 0),
                Arguments.of(new int[] { 1, 1, 1, 1, 1 }, 1, 0),
                Arguments.of(new int[] { 1, 1, 1, 1, 1 }, 2, 5),

                Arguments.of(new int[] { 5, 7, 9, 11 }, 5, 0),
                Arguments.of(new int[] { 5, 7, 9, 11 }, 6, 1),
                Arguments.of(new int[] { 5, 7, 9, 11 }, 7, 1),
                Arguments.of(new int[] { 5, 7, 9, 11 }, 8, 2),
                Arguments.of(new int[] { 5, 7, 9, 11 }, 9, 2),
                Arguments.of(new int[] { 5, 7, 9, 11 }, 10, 3),
                Arguments.of(new int[] { 5, 7, 9, 11 }, 11, 3),
                Arguments.of(new int[] { 5, 7, 9, 11 }, 12, 4),

                Arguments.of(new int[] { 5, 5, 5, 7, 9, 11 }, 5, 0),
                Arguments.of(new int[] { 5, 5, 5, 7, 9, 11 }, 6, 3),
                Arguments.of(new int[] { 5, 5, 5, 7, 9, 11 }, 7, 3),
                Arguments.of(new int[] { 5, 5, 5, 7, 9, 11 }, 8, 4),

                Arguments.of(new int[] { 5, 7, 7, 7, 7, 9, 11 }, 6, 1),
                Arguments.of(new int[] { 5, 7, 7, 7, 7, 9, 11 }, 7, 1),
                Arguments.of(new int[] { 5, 7, 7, 7, 7, 9, 11 }, 8, 5),
                Arguments.of(new int[] { 5, 7, 7, 7, 7, 9, 11 }, 9, 5),

                Arguments.of(new int[] { 5, 7, 9, 11, 11, 11 }, 10, 3),
                Arguments.of(new int[] { 5, 7, 9, 11, 11, 11 }, 11, 3),
                Arguments.of(new int[] { 5, 7, 9, 11, 11, 11 }, 12, 6));
    }

    @ParameterizedTest
    @MethodSource("countEqualsTestData")
    public void testCountEquals(int[] array, int n, int expected) {
        Assertions.assertEquals(expected, EqualKeys.count(array, n));
    }

    private static Stream<Arguments> countEqualsTestData() {
        return Stream.of(
                Arguments.of(new int[0], 0, 0),
                Arguments.of(new int[0], 1, 0),

                Arguments.of(new int[] { 1 }, 0, 0),
                Arguments.of(new int[] { 1 }, 1, 1),
                Arguments.of(new int[] { 1 }, 2, 0),

                Arguments.of(new int[] { 1, 1, 1, 1 }, 0, 0),
                Arguments.of(new int[] { 1, 1, 1, 1 }, 1, 4),
                Arguments.of(new int[] { 1, 1, 1, 1 }, 2, 0),

                Arguments.of(new int[] { 5, 5, 5, 5, 5, 5, 6, 9 }, 4, 0),
                Arguments.of(new int[] { 5, 5, 5, 5, 5, 5, 6, 9 }, 5, 6),
                Arguments.of(new int[] { 5, 5, 5, 5, 5, 5, 6, 9 }, 6, 1),
                Arguments.of(new int[] { 5, 5, 5, 5, 5, 5, 6, 9 }, 9, 1),
                Arguments.of(new int[] { 5, 5, 5, 5, 5, 5, 6, 9 }, 10, 0),

                Arguments.of(new int[] { 5, 6, 6, 6, 7 }, 4, 0),
                Arguments.of(new int[] { 5, 6, 6, 6, 7 }, 5, 1),
                Arguments.of(new int[] { 5, 6, 6, 6, 7 }, 6, 3),
                Arguments.of(new int[] { 5, 6, 6, 6, 7 }, 7, 1),
                Arguments.of(new int[] { 5, 6, 6, 6, 7 }, 8, 0),

                Arguments.of(new int[] { 6, 7, 8, 8, 8, 8 }, 5, 0),
                Arguments.of(new int[] { 6, 7, 8, 8, 8, 8 }, 6, 1),
                Arguments.of(new int[] { 6, 7, 8, 8, 8, 8 }, 7, 1),
                Arguments.of(new int[] { 6, 7, 8, 8, 8, 8 }, 8, 4),
                Arguments.of(new int[] { 6, 7, 8, 8, 8, 8 }, 9, 0));
    }
}
