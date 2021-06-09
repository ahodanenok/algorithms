package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToBinaryTest {

    @Test
    public void testZero() {
        assertEquals("0", ToBinary.convert(0));
    }

    @Test
    public void testNegative() {
        assertThrows(IllegalArgumentException.class, () -> ToBinary.convert(-1));
    }

    @Test
    public void testOne() {
        assertEquals("1", ToBinary.convert(1));
    }

    @Test
    public void testTwo() {
        assertEquals("10", ToBinary.convert(2));
    }

    @Test
    public void testThree() {
        assertEquals("11", ToBinary.convert(3));
    }

    @Test
    public void testLarge() {
        assertEquals("111010110111100110100010101", ToBinary.convert(123456789));
    }

    @Test
    public void testMaxInteger() {
        assertEquals("1111111111111111111111111111111", ToBinary.convert(Integer.MAX_VALUE));
    }
}
