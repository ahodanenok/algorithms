package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotOrColdTest {

    @Test
    public void test() {
        for (int n = 1; n <= 10000; n++) {
            for (int s = 1; s <= n; s++) {
                int guessCount = HotOrCold.guess(n, s);
                assertTrue(guessCount > 0);

                int maxGuesses = Math.max(2 * (32 - Integer.numberOfLeadingZeros(n - 1)), 1);
                assertTrue(guessCount <= maxGuesses, "n=" + n + ", s=" + s + ", guesses=" + guessCount + ", max=" + maxGuesses);
            }
        }
    }
}
