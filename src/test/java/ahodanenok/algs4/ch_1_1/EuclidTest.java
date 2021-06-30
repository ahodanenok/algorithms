package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Exercise 1.1.24
 */
public class EuclidTest {

    @ParameterizedTest
    @MethodSource("getCases")
    public void test(TestCase testCase) {
        Assertions.assertEquals(testCase.d, Euclid.gcd(testCase.p, testCase.q));
    }

    public static Stream<TestCase> getCases() {
        return Stream.of(
            new TestCase(0, 5, 5),
            new TestCase(6, 0, 6),
            new TestCase(1, 1, 1),
            new TestCase(100, 1, 1),
            new TestCase(8, 4, 4),
            new TestCase(22, 11, 11),
            new TestCase(198, 168, 6),
            new TestCase(3084, 1424, 4),
            new TestCase(210, 45, 15),
            new TestCase(765, 714, 51),
            new TestCase(33, 27, 3),
            new TestCase(97, 20, 1),
            new TestCase(1234567, 111111, 1));
    }

    private static class TestCase {

        final int p;
        final int q;
        final int d;

        public TestCase(int p, int q, int d) {
            this.p = p;
            this.q = q;
            this.d = d;
        }

        @Override
        public String toString() {
            return String.format("gcd(%d, %d) = %d", p, q, d);
        }
    }
}
