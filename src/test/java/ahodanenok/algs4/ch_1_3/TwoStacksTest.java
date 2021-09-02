package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TwoStacksTest {

    @Test
    public void testEmpty() {
        TwoStacks<String> stacks = new TwoStacks<>();
        assertEquals(0, stacks.sizeA());
        assertEquals(0, stacks.sizeB());
    }

    @Test
    public void testPushSingleA() {
        TwoStacks<String> stacks = new TwoStacks<>();
        stacks.pushA("a");

        assertEquals(1, stacks.sizeA());
        assertEquals(0, stacks.sizeB());
        assertEquals("a", stacks.popA());
        assertEquals(0, stacks.sizeA());
    }

    @Test
    public void testPushSingleB() {
        TwoStacks<String> stacks = new TwoStacks<>();
        stacks.pushB("b");

        assertEquals(0, stacks.sizeA());
        assertEquals(1, stacks.sizeB());
        assertEquals("b", stacks.popB());
        assertEquals(0, stacks.sizeB());
    }

    @Test
    public void testPopEmptyA() {
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> new TwoStacks<>().popA());
        assertEquals("Stack A is empty", e.getMessage());
    }

    @Test
    public void testPopEmptyB() {
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> new TwoStacks<>().popB());
        assertEquals("Stack B is empty", e.getMessage());
    }

    @Test
    public void testPushBoth() {
        TwoStacks<String> stacks = new TwoStacks<>();
        stacks.pushA("a1");
        stacks.pushA("a2");
        stacks.pushA("a3");
        stacks.pushB("b1");
        stacks.pushB("b2");

        assertEquals(3, stacks.sizeA());
        assertEquals(2, stacks.sizeB());

        assertEquals("a3", stacks.popA());
        assertEquals("b2", stacks.popB());
        assertEquals("a2", stacks.popA());
        assertEquals("b1", stacks.popB());
        assertEquals("a1", stacks.popA());

        assertEquals(0, stacks.sizeA());
        assertEquals(0, stacks.sizeB());
    }
}
