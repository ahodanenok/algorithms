package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CircularStackTest {

    @Test
    public void testEmpty() {
        Streaming.CircularStack<Integer> stack = new Streaming.CircularStack<>(3);
        assertTrue(stack.isEmpty());
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> stack.pop());
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testLessItemsThanCapacity() {
        Streaming.CircularStack<Integer> stack = new Streaming.CircularStack<>(4);

        stack.push(1);
        stack.push(2);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());

        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSameItemsAsCapacity() {
        Streaming.CircularStack<Integer> stack = new Streaming.CircularStack<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());

        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(10, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(8, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(6, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testMoreItemsThanCapacity() {
        Streaming.CircularStack<String> stack = new Streaming.CircularStack<>(3);

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        assertFalse(stack.isEmpty());
        assertEquals("e", stack.pop());
        assertEquals("d", stack.pop());
        assertEquals("c", stack.pop());
        assertTrue(stack.isEmpty());

        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("k");
        assertFalse(stack.isEmpty());
        assertEquals("k", stack.pop());
        assertEquals("h", stack.pop());
        assertEquals("g", stack.pop());
        assertTrue(stack.isEmpty());
    }
}
