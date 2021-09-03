package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluatePostfixTest {

    @Test
    public void testErrorLastTokenIsNotOperator() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> EvaluatePostfix.evaluate("1 2*"));

        assertEquals("Last token must be an operation, found '2*'", e.getMessage());
    }

    @Test
    public void testErrorUnsupportedToken() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> EvaluatePostfix.evaluate("3 4 * b +"));

        assertEquals("Unsupported token: b", e.getMessage());
    }

    @Test
    public void testErrorNotEnoughArgumentsSum() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> EvaluatePostfix.evaluate("1 +"));

        assertEquals("Not enough arguments for sum: expected 2, found 1", e.getMessage());
    }

    @Test
    public void testErrorNotEnoughArgumentsSubtract() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> EvaluatePostfix.evaluate("-"));

        assertEquals("Not enough arguments for subtraction: expected 2, found 0", e.getMessage());
    }

    @Test
    public void testErrorNotEnoughArgumentsMultiply() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> EvaluatePostfix.evaluate("3 5 + *"));

        assertEquals("Not enough arguments for multiplication: expected 2, found 1", e.getMessage());
    }

    @Test
    public void testErrorNotEnoughArgumentsDivision() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> EvaluatePostfix.evaluate("3 5 + / 5 -"));

        assertEquals("Not enough arguments for division: expected 2, found 1", e.getMessage());
    }

    @Test
    public void testErrorDivisionByZero() {
        ArithmeticException e = assertThrows(
                ArithmeticException.class, () -> EvaluatePostfix.evaluate("2 0 /"));

        assertEquals("/ by zero", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getExpressions")
    public void testEvaluate(int result, String expr) {
        assertEquals(result, EvaluatePostfix.evaluate(expr));
    }

    private static Stream<Arguments> getExpressions() {
        return Stream.of(
            Arguments.of(0, ""),
            Arguments.of(0, "\n \r \t"),

            Arguments.of(8, "3 5 +"),

            Arguments.of(3, "7 4 -"),
            Arguments.of(-3, "4 7 -"),
            Arguments.of(3, "-4 -7 -"),
            Arguments.of(-11, "-4 7 -"),
            Arguments.of(11, "4 -7 -"),

            Arguments.of(42, "6 7 *"),
            Arguments.of(-42, "-6 7 *"),
            Arguments.of(-42, "6 -7 *"),
            Arguments.of(42, "-6 -7 *"),

            Arguments.of(7, "15 2 /"),
            Arguments.of(6, "18 3 /"),
            Arguments.of(-6, "-18 3 /"),
            Arguments.of(-6, "18 -3 /"),
            Arguments.of(6, "-18 -3 /"),

            Arguments.of(-80, "10 12 5 - 4 - 2 3 4 * 1 + - + *"));
    }
}
