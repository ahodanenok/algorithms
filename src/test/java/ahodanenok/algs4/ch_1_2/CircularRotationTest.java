package ahodanenok.algs4.ch_1_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CircularRotationTest {

    @ParameterizedTest
    @MethodSource("getStrings")
    public void test(String a, String b, boolean match) {
        Assertions.assertEquals(match, CircularRotation.match(a, b));
    }

    private static Stream<Arguments> getStrings() {
        return Stream.of(
                Arguments.of("", "", true),
                Arguments.of("A", "A", true),
                Arguments.of("A", "B", false),
                Arguments.of("B", "A", false),
                Arguments.of("AA", "AA", true),
                Arguments.of("AB", "AB", true),
                Arguments.of("BA", "AB", true),
                Arguments.of("AB", "BA", true),
                Arguments.of("ABC", "CBA", false),
                Arguments.of("ABC", "BCA", true),
                Arguments.of("ABC", "CAB", true),
                Arguments.of("ABC", "ABC", true),
                Arguments.of("AAA", "AAAA", false),
                Arguments.of("AAAA", "AAA", false),
                Arguments.of("ABBA", "BAAB", true),
                Arguments.of("ABBA", "BABA", false),
                Arguments.of("ACTGACG", "TGACGAC", true));
    }
}
