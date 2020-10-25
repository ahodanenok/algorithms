package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FixedCapacityStackOfStringsTest {

    @Test
    public void testPushPop() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(3);

        assertEquals(0, stack.size());
        assertFalse(stack.isFull());

        stack.push("1");
        assertEquals(1, stack.size());
        assertFalse(stack.isFull());

        stack.push("2");
        assertEquals(2, stack.size());
        assertFalse(stack.isFull());

        stack.push("3");
        assertEquals(3, stack.size());
        assertTrue(stack.isFull());

        assertEquals("3", stack.pop());
        assertEquals(2, stack.size());
        assertFalse(stack.isFull());

        assertEquals("2", stack.pop());
        assertEquals(1, stack.size());
        assertFalse(stack.isFull());

        assertEquals("1", stack.pop());
        assertEquals(0, stack.size());
        assertFalse(stack.isFull());
    }

    @Test
    public void testOverflow() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(1);
        stack.push("1");
        assertThrows(IllegalStateException.class, () -> stack.push("2"));
    }

    @Test
    public void testUnderflow() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(1);
        stack.push("1");
        stack.pop();
        assertThrows(IllegalStateException.class, stack::pop);
    }
}
