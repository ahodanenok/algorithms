package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class InfixToPostfixTest {

    @ParameterizedTest
    @MethodSource("getExpressions")
    public void testConversion(String expectedPostfixExpr, String infixExpr) {
        assertEquals(expectedPostfixExpr, InfixToPostfix.convert(infixExpr));
    }

    @Test
    public void testThrowsErrorIfNotEnoughArguments() {
        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> InfixToPostfix.convert("2 +"));
        assertEquals("Not enough arguments for +", e.getMessage());
    }

    @Test
    public void testThrowsErrorIfUnmatchedParenthesisRight() {
        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> InfixToPostfix.convert("1 + (2 - 3"));
        assertEquals("Unmatched parenthesis", e.getMessage());
    }

    @Test
    public void testThrowsErrorIfUnmatchedParenthesisLeft() {
        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> InfixToPostfix.convert("1 + 2 - 3) + 5"));
        assertEquals("Unmatched parenthesis", e.getMessage());
    }

    private static Stream<Arguments> getExpressions() {
        return Stream.of(
            Arguments.of(null, null),
            Arguments.of("", ""),
            Arguments.of("", "  \t   \n  \r  "),
            Arguments.of("123 67 +", " \n  \r \t 123 \r \n \t  + 67  \t \t \r \n \r "),

            Arguments.of("+2", "+2"),
            Arguments.of("-3", "-3"),
            Arguments.of("*4", "*4"),
            Arguments.of("/5", "/5"),

            Arguments.of("1 2 +", "1 + 2"),
            Arguments.of("2 3 -", "2 - 3"),
            Arguments.of("4 5 *", "4 * 5"),
            Arguments.of("6 7 /", "6 / 7"),

            Arguments.of("+1 +2 +", "+1++2"),
            Arguments.of("-1 -2 -", "-1--2"),
            Arguments.of("+3 -4 -", "+3--4"),
            Arguments.of("+3 -4 +", "+3+-4"),
            Arguments.of("-3 +4 -", "-3-+4"),
            Arguments.of("-3 +4 +", "-3++4"),

            Arguments.of("1 2 + 3 +", "1 + 2 + 3"),
            Arguments.of("1 2 + 3 -", "1 + 2 - 3"),
            Arguments.of("1 2 - 3 +", "1 - 2 + 3"),

            Arguments.of("1 2 3 * -", "1 - 2 * 3"),
            Arguments.of("1 2 3 * +", "1 + 2 * 3"),
            Arguments.of("1 2 3 / -", "1 - 2 / 3"),
            Arguments.of("1 2 3 / +", "1 + 2 / 3"),

            Arguments.of("1 2 - 3 *", "(1 - 2) * 3"),
            Arguments.of("1 2 + 3 /", "(1 + 2) / 3"),
            Arguments.of("1 2 + 3 - 4 5 - 6 + *", "(1 + 2 - 3) * (4 - 5 + 6)"),
            Arguments.of("1 2 + 3 4 + - 5 6 + -", "(1 + 2) - (3 + 4) - (5 + 6)"),
            Arguments.of("1 3 4 - * 5 1 + / 3 -", "1 * (3 - 4) / (5 + 1) - 3"),

            Arguments.of("ab2 1b *", "ab2 * 1b"),
            Arguments.of("+ + +", "+++"),
            Arguments.of("- - -", "---"),
            Arguments.of("- - +", "-+-"),
            Arguments.of("* * *", "***"),
            Arguments.of("+ - *", "+*-"),
            Arguments.of("/ / /", "///"),
            Arguments.of("+D -EF /", "+D / -EF"),
            Arguments.of("& @ - $ +", "& - @ + $"));
    }
}
