package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TagSystemTest {

    @Test
    public void testEmpty() {
        TestObserver observer = new TestObserver();
        TagSystem.execute("", observer);
        assertEquals(Collections.singletonList(""), observer.transitions);
        assertFalse(observer.infiniteLoop);
        assertTrue(observer.halted);
    }

    @Test
    public void testTwoSymbols() {
        TestObserver observer = new TestObserver();
        TagSystem.execute("00", observer);
        assertEquals(Collections.singletonList("00"), observer.transitions);
        assertFalse(observer.infiniteLoop);
        assertTrue(observer.halted);
    }

    @Test
    public void test_0() {
        TestObserver observer = new TestObserver();
        TagSystem.execute("000", observer);
        assertEquals(Arrays.asList("00", "00"), observer.transitions);
        assertFalse(observer.infiniteLoop);
        assertTrue(observer.halted);
    }

    @Test
    public void test_1() {
        TestObserver observer = new TestObserver();
        TagSystem.execute("100", observer);
        assertEquals(Arrays.asList("1101", "11101", "011101", "10100", "001101"), observer.transitions);
        assertTrue(observer.infiniteLoop);
        assertFalse(observer.halted);
    }

    @Test
    public void test_10010() {
        TestObserver observer = new TestObserver();
        TagSystem.execute("10010", observer);
        assertEquals(
            Arrays.asList(
                "101101",
                "1011101",
                "11011101",
                "111011101",
                "0111011101",
                "101110100",
                "1101001101",
                "10011011101",
                "110111011101",
                "1110111011101",
                "01110111011101",
                "1011101110100",
                "11011101001101",
                "111010011011101",
                "0100110111011101",
                "011011101110100",
                "01110111010000",
                "1011101000000",
                "11010000001101",
                "100000011011101",
                "0000110111011101"
            ), observer.transitions);
        assertTrue(observer.infiniteLoop);
        assertFalse(observer.halted);
    }

    @Test
    public void test_100100100100100100() {
        TestObserver observer = new TestObserver();
        TagSystem.execute("100100100100100100", observer);
        assertEquals(
            Arrays.asList(
                "1001001001001001101",
                "10010010010011011101",
                "100100100110111011101",
                "1001001101110111011101",
                "10011011101110111011101",
                "110111011101110111011101",
                "1110111011101110111011101",
                "01110111011101110111011101",
                "1011101110111011101110100",
                "11011101110111011101001101",
                "111011101110111010011011101",
                "0111011101110100110111011101",
                "101110111010011011101110100",
                "1101110100110111011101001101",
                "11101001101110111010011011101",
                "010011011101110100110111011101",
                "01101110111010011011101110100",
                "0111011101001101110111010000",
                "101110100110111011101000000",
                "1101001101110111010000001101",
                "10011011101110100000011011101",
                "110111011101000000110111011101",
                "1110111010000001101110111011101",
                "01110100000011011101110111011101",
                "1010000001101110111011101110100",
                "00000011011101110111011101001101",
                "0001101110111011101110100110100",
                "110111011101110111010011010000",
                "1110111011101110100110100001101",
                "01110111011101001101000011011101",
                "1011101110100110100001101110100",
                "11011101001101000011011101001101",
                "111010011010000110111010011011101",
                "0100110100001101110100110111011101",
                "011010000110111010011011101110100",
                "01000011011101001101110111010000",
                "0001101110100110111011101000000",
                "110111010011011101110100000000",
                "1110100110111011101000000001101",
                "01001101110111010000000011011101",
                "0110111011101000000001101110100",
                "011101110100000000110111010000",
                "10111010000000011011101000000",
                "110100000000110111010000001101",
                "1000000001101110100000011011101",
                "00000011011101000000110111011101",
                "0001101110100000011011101110100",
                "110111010000001101110111010000",
                "1110100000011011101110100001101",
                "01000000110111011101000011011101",
                "0000011011101110100001101110100",
                "001101110111010000110111010000",
                "10111011101000011011101000000",
                "110111010000110111010000001101",
                "1110100001101110100000011011101",
                "01000011011101000000110111011101"
            ), observer.transitions);
        assertTrue(observer.infiniteLoop);
        assertFalse(observer.halted);
    }

    private static class TestObserver implements TagSystem.Observer {

        List<String> transitions = new ArrayList<>();
        boolean halted;
        boolean infiniteLoop;

        @Override
        public void onTransition(String symbols) {
            transitions.add(symbols);
        }

        @Override
        public void onHalt(String symbols) {
            transitions.add(symbols);
            halted = true;
        }

        @Override
        public void onInfiniteLoop(String symbols) {
            infiniteLoop = true;
        }
    }
}
