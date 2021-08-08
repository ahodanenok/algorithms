package ahodanenok.algs4.ch_1_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RationalTest {

    @Test
    public void testZeroDenominator() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> new Rational(11, 0));
        assertEquals("Denominator can't be zero", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getNormalizeData")
    public void testNormalize(int n, int d, Rational r) {
        assertEquals(n, r.getNumerator());
        assertEquals(d, r.getDenominator());
    }

    @Test
    public void testMaxValueDenominator() {
        Rational r = new Rational(1, Integer.MAX_VALUE);
        assertEquals(1, r.getNumerator());
        assertEquals(Integer.MAX_VALUE, r.getDenominator());
    }

    @Test
    public void testMaxValueNumerator() {
        Rational r = new Rational(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MAX_VALUE, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testMaxValue() {
        Rational r = new Rational(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(1, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testMinValueDenominator() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> new Rational(1, Integer.MIN_VALUE));
        assertEquals("Overflow, maximum denominator value is " + Integer.MAX_VALUE, e.getMessage());
    }

    @Test
    public void testMinValueNumerator() {
        Rational r = new Rational(Integer.MIN_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testMinValue() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> new Rational(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals("Overflow, maximum denominator value is " + Integer.MAX_VALUE, e.getMessage());
    }

    private static Stream<Arguments> getNormalizeData() {
        return Stream.of(
            Arguments.of(1, 2, new Rational(1, 2)),
            Arguments.of(1, 2, new Rational(2, 4)),
            Arguments.of(1, 2, new Rational(8, 16)),
            Arguments.of(1, 1, new Rational(3, 3)),
            Arguments.of(2, 7, new Rational(4, 14)),
            Arguments.of(2, 7, new Rational(20, 70)),
            Arguments.of(3, 5, new Rational(-3, -5)),
            Arguments.of(3, 5, new Rational(-6, -10)),
            Arguments.of(-2, 9, new Rational(-2, 9)),
            Arguments.of(-2, 9, new Rational(-6, 27)),
            Arguments.of(-4, 11, new Rational(4, -11)),
            Arguments.of(-4, 11, new Rational(20, -55)));
    }

    @Test
    public void testToStringBasic() {
        assertEquals("7/9", new Rational(7, 9).toString());
    }

    @Test
    public void testToStringNormalized() {
        assertEquals("1/5", new Rational(5, 25).toString());
    }

    @Test
    public void testToStringNumeratorNegative() {
        assertEquals("-4/13", new Rational(-4, 13).toString());
    }

    @Test
    public void testToStringDenominatorNegative() {
        assertEquals("-9/16", new Rational(9, -16).toString());
    }

    @Test
    public void testToStringNumeratorDenominatorNegative() {
        assertEquals("6/17", new Rational(-6, -17).toString());
    }

    @Test
    public void testToStringMinMaxValue() {
        assertEquals(
                Integer.MIN_VALUE + "/" + Integer.MAX_VALUE,
                new Rational(Integer.MIN_VALUE, Integer.MAX_VALUE).toString());
    }

    @ParameterizedTest
    @MethodSource("getEqualsData")
    public void testEquals(boolean equals, Rational a, Rational b) {
        if (equals) {
            assertTrue(a.equals(b));
        } else {
            assertFalse(a.equals(b));
        }
    }

    private static Stream<Arguments> getEqualsData() {
        return Stream.of(
            Arguments.of(false, new Rational(1, 2), new Rational(1, 4)),
            Arguments.of(false, new Rational(-1, 2), new Rational(1, 2)),
            Arguments.of(false, new Rational(1, 2), new Rational(-1, 2)),
            Arguments.of(true, new Rational(0, 2), new Rational(0, 3)),
            Arguments.of(true, new Rational(-1, 2), new Rational(-1, 2)),
            Arguments.of(true, new Rational(5, 15), new Rational(10, 30)),
            Arguments.of(true, new Rational(2, 4), new Rational(1, 2)));
    }

    @ParameterizedTest
    @MethodSource("getPlusData")
    public void testPlus(Rational expected, Rational a, Rational b) {
        Rational sum = a.plus(b);
        assertEquals(expected.getNumerator(), sum.getNumerator());
        assertEquals(expected.getDenominator(), sum.getDenominator());
    }

    private static Stream<Arguments> getPlusData() {
        return Stream.of(
            Arguments.of(new Rational(1, 1), new Rational(1, 2), new Rational(1, 2)),
            Arguments.of(new Rational(2, 1), new Rational(1, 1), new Rational(2, 2)),
            Arguments.of(new Rational(3, 4), new Rational(1, 4), new Rational(1, 2)),
            Arguments.of(new Rational(1, 4), new Rational(1, 2), new Rational(-1, 4)),
            Arguments.of(new Rational(8, 11), new Rational(3, 11), new Rational(5, 11)),
            Arguments.of(new Rational(-29, 40), new Rational(-7, 8), new Rational(3, 20)),
            Arguments.of(new Rational(-49, 15), new Rational(-8, 5), new Rational(-5, 3)),
            Arguments.of(new Rational(-29, 24), new Rational(-3, 8), new Rational(-5, 6)));
    }

    @Test
    public void testPlusOverflowMaxValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MAX_VALUE, 1).plus(new Rational(1, 1));
        });

        assertEquals("Overflow, n=2147483648", e.getMessage());
    }

    @Test
    public void testPlusOverflowMinValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MIN_VALUE, 1).plus(new Rational(-1, 1));
        });

        assertEquals("Overflow, n=-2147483649", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getMinusData")
    public void testMinus(Rational expected, Rational a, Rational b) {
        Rational diff = a.minus(b);
        assertEquals(expected.getNumerator(), diff.getNumerator());
        assertEquals(expected.getDenominator(), diff.getDenominator());
    }

    private static Stream<Arguments> getMinusData() {
        return Stream.of(
            Arguments.of(new Rational(0, 2), new Rational(1, 2), new Rational(1, 2)),
            Arguments.of(new Rational(0, 1), new Rational(1, 1), new Rational(2, 2)),
            Arguments.of(new Rational(-1, 4), new Rational(1, 4), new Rational(1, 2)),
            Arguments.of(new Rational(3, 4), new Rational(1, 2), new Rational(-1, 4)),
            Arguments.of(new Rational(2, 11), new Rational(5, 11), new Rational(3, 11)),
            Arguments.of(new Rational(-41, 40), new Rational(-7, 8), new Rational(3, 20)),
            Arguments.of(new Rational(1, 15), new Rational(-8, 5), new Rational(-5, 3)),
            Arguments.of(new Rational(11, 24), new Rational(-3, 8), new Rational(-5, 6)));
    }

    @Test
    public void testMinusOverflowMaxValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MAX_VALUE, 1).minus(new Rational(-1, 1));
        });

        assertEquals("Overflow, n=2147483648", e.getMessage());
    }

    @Test
    public void testMinusOverflowMinValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MIN_VALUE, 1).plus(new Rational(-1, 1));
        });

        assertEquals("Overflow, n=-2147483649", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getTimesData")
    public void testTimes(Rational expected, Rational a, Rational b) {
        Rational product = a.times(b);
        assertEquals(expected.getNumerator(), product.getNumerator());
        assertEquals(expected.getDenominator(), product.getDenominator());
    }

    private static Stream<Arguments> getTimesData() {
        return Stream.of(
            Arguments.of(new Rational(0, 1), new Rational(1, 2), new Rational(0, 2)),
            Arguments.of(new Rational(0, 1), new Rational(0, 3), new Rational(1, 4)),
            Arguments.of(new Rational(1, 4), new Rational(1, 2), new Rational(1, 2)),
            Arguments.of(new Rational(1, 1), new Rational(1, 1), new Rational(2, 2)),
            Arguments.of(new Rational(1, 8), new Rational(1, 4), new Rational(1, 2)),
            Arguments.of(new Rational(-3, 14), new Rational(-3, 4), new Rational(2, 7)),
            Arguments.of(new Rational(-12, 55), new Rational(4, 11), new Rational(-3, 5)),
            Arguments.of(new Rational(7, 18), new Rational(-7, 9), new Rational(-1, 2)),
            Arguments.of(new Rational(2, 15), new Rational(14, 27), new Rational(18, 70)));
    }

    @Test
    public void testTimesOverflowMaxValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MAX_VALUE, 1).times(new Rational(2, 1));
        });

        assertEquals("Overflow, n=4294967294", e.getMessage());
    }

    @Test
    public void testTimesOverflowMinValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MIN_VALUE, 1).times(new Rational(2, 1));
        });

        assertEquals("Overflow, n=-4294967296", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getDividesData")
    public void testDivides(Rational expected, Rational a, Rational b) {
        Rational quotient = a.divides(b);
        assertEquals(expected.getNumerator(), quotient.getNumerator());
        assertEquals(expected.getDenominator(), quotient.getDenominator());
    }

    @Test
    public void testDividesByZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new Rational(5, 11).divides(new Rational(0, 4));
        });

        assertEquals("Can't divide by zero", e.getMessage());
    }

    private static Stream<Arguments> getDividesData() {
        return Stream.of(
                Arguments.of(new Rational(1, 1), new Rational(1, 2), new Rational(1, 2)),
                Arguments.of(new Rational(3, 8), new Rational(1, 4), new Rational(2, 3)),
                Arguments.of(new Rational(-10, 21), new Rational(-5, 7), new Rational(3, 2)),
                Arguments.of(new Rational(-15, 8), new Rational(3, 4), new Rational(-2, 5)),
                Arguments.of(new Rational(15, 22), new Rational(-6, 11), new Rational(-4, 5)));
    }

    @Test
    public void testDividesOverflowMaxValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MAX_VALUE, 1).divides(new Rational(1, 2));
        });

        assertEquals("Overflow, n=4294967294", e.getMessage());
    }

    @Test
    public void testDividesOverflowMinValue() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            new Rational(Integer.MIN_VALUE, 1).divides(new Rational(1, 2));
        });

        assertEquals("Overflow, n=-4294967296", e.getMessage());
    }
}
