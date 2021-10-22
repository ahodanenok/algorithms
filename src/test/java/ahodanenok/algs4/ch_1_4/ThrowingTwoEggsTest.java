package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThrowingTwoEggsTest {

    @Test
    public void test() {
        for (int n = 1; n < 10_000; n++) {
            for (int f = 1; f <= n; f++) {
                int tries = ThrowingTwoEggs.triesCount(n, f);
                assertTrue(tries > 0);

                int max = (int) Math.ceil(2 * Math.sqrt(n));
                assertTrue(tries <= max, "tries=" + tries + ", max=" + max + ", n=" + n + ", floor=" + f);
            }
        }
    }
}
