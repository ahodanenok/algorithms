package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.Interval1D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.StringWriter;
import java.util.stream.Stream;

public class IntersectingIntervals1DTest {

    @ParameterizedTest
    @MethodSource("getIntervals")
    public void test(String output, Interval1D[] intervals) throws Exception {
        StringWriter out = new StringWriter();
        IntersectingIntervals1D.print(intervals, out);
        Assertions.assertEquals(output, out.toString());
    }

    public static Stream<Arguments> getIntervals() {
        return Stream.of(
            Arguments.of("", new Interval1D[0]),
            Arguments.of("", new Interval1D[] {
                new Interval1D(1, 2)
            }),
            Arguments.of("", new Interval1D[] {
                new Interval1D(1, 2),
                new Interval1D(3, 4),
            }),
            Arguments.of(
                "[1.0, 2.0] [2.0, 4.0]" + System.lineSeparator(),
                new Interval1D[] {
                    new Interval1D(1, 2),
                    new Interval1D(2, 4),
                }
            ),
            Arguments.of(
                "[1.0, 2.0] [1.0, 3.0]" + System.lineSeparator(),
                new Interval1D[] {
                    new Interval1D(1, 3),
                    new Interval1D(1, 2),
                    new Interval1D(4, 5),
                }
            ),
            Arguments.of(
                "[1.0, 3.0] [2.0, 5.0]" + System.lineSeparator(),
                new Interval1D[] {
                    new Interval1D(1, 3),
                    new Interval1D(6, 8),
                    new Interval1D(2, 5),
                }
            ),
            Arguments.of(
                "[1.0, 3.0] [1.0, 3.0]" + System.lineSeparator() +
                "[1.0, 3.0] [1.0, 3.0]" + System.lineSeparator() +
                "[1.0, 3.0] [1.0, 3.0]" + System.lineSeparator(),
                new Interval1D[] {
                    new Interval1D(1, 3),
                    new Interval1D(1, 3),
                    new Interval1D(1, 3),
                }
            ),
            Arguments.of(
                "[4.0, 5.0] [1.0, 10.0]" + System.lineSeparator() +
                "[2.0, 3.0] [1.0, 10.0]" + System.lineSeparator(),
                new Interval1D[] {
                    new Interval1D(1, 10),
                    new Interval1D(2, 3),
                    new Interval1D(4, 5)
                }
            ),
            Arguments.of(
                "[6.0, 7.0] [3.0, 8.0]" + System.lineSeparator() +
                "[4.0, 5.0] [3.0, 8.0]" + System.lineSeparator() +
                "[3.0, 8.0] [2.0, 9.0]" + System.lineSeparator() +
                "[6.0, 7.0] [2.0, 9.0]" + System.lineSeparator() +
                "[4.0, 5.0] [2.0, 9.0]" + System.lineSeparator(),
                new Interval1D[] {
                    new Interval1D(2, 9),
                    new Interval1D(3, 8),
                    new Interval1D(4, 5),
                    new Interval1D(6, 7)
                }
            ),
            Arguments.of(
                "[1.0, 3.0] [1.0, 3.0]" + System.lineSeparator() +
                "[1.0, 3.0] [2.0, 7.0]" + System.lineSeparator() +
                "[1.0, 3.0] [2.0, 7.0]" + System.lineSeparator() +
                "[2.0, 7.0] [6.0, 8.0]" + System.lineSeparator() +
                "[6.0, 8.0] [6.0, 9.0]" + System.lineSeparator() +
                "[2.0, 7.0] [6.0, 9.0]" + System.lineSeparator() +
                "[6.0, 9.0] [9.0, 10.0]" + System.lineSeparator(),
                new Interval1D[] {
                    new Interval1D(1, 3),
                    new Interval1D(2, 7),
                    new Interval1D(1, 3),
                    new Interval1D(6, 8),
                    new Interval1D(6, 9),
                    new Interval1D(9, 10)
                }
            ));
    }
}
