package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LgTest {

    @Test
    public void test_0() {
        assertEquals(0, Lg.compute(0));
    }

    @Test
    public void test_1() {
        assertEquals(0, Lg.compute(1));
    }

    @Test
    public void test_2() {
        assertEquals(1, Lg.compute(2));
    }

    @Test
    public void test_3() {
        assertEquals(1, Lg.compute(3));
    }

    @Test
    public void test_4() {
        assertEquals(2, Lg.compute(4));
    }

    @Test
    public void test_5() {
        assertEquals(2, Lg.compute(5));
    }

    @Test
    public void test_6() {
        assertEquals(2, Lg.compute(6));
    }

    @Test
    public void test_7() {
        assertEquals(2, Lg.compute(7));
    }

    @Test
    public void test_8() {
        assertEquals(3, Lg.compute(8));
    }

    @Test
    public void test_9() {
        assertEquals(3, Lg.compute(9));
    }

    @Test
    public void test_30() {
        assertEquals(4, Lg.compute(30));
    }

    @Test
    public void test_31() {
        assertEquals(4, Lg.compute(31));
    }

    @Test
    public void test_32() {
        assertEquals(5, Lg.compute(32));
    }

    @Test
    public void test_33() {
        assertEquals(5, Lg.compute(33));
    }

    @Test
    public void test_MAX_VALUE() {
        assertEquals(30, Lg.compute(Integer.MAX_VALUE));
    }
}
