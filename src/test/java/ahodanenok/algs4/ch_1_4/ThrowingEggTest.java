package ahodanenok.algs4.ch_1_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThrowingEggTest {

    @Test
    public void test() {
        for (int floor = 1; floor < 100_000_000; floor++) {
            int eggs = ThrowingEgg.eggsNeeded(floor);
            assertTrue(eggs > 0);

            // ~ 2 * log2(floor), at least one egg is required
            int max = 2 * Math.max((32 - Integer.numberOfLeadingZeros(floor - 1)), 1);
            assertTrue(eggs <= max, "eggs=" + eggs + ", max=" + max + ", floor=" + floor);
        }
    }
}
