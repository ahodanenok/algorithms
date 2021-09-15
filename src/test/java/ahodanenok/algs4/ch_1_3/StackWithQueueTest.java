package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackWithQueueTest {

    @Test
    public void testEmpty() {
        StackWithQueue<String> stack = new StackWithQueue<>();
        assertTrue(stack.isEmpty());
        NoSuchElementException e = assertThrows(NoSuchElementException.class, stack::pop);
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testPushPop() {
        StackWithQueue<String> stack = new StackWithQueue<>();
        stack.push("a");

        assertFalse(stack.isEmpty());
        assertEquals("a", stack.pop());
        assertTrue(stack.isEmpty());

        stack.push("b");
        stack.push("c");
        stack.push("d");
        assertEquals("d", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertTrue(stack.isEmpty());
    }
}
