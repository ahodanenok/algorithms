package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackWithMaxTest {

    @Test
    public void testSizeEmpty() {
        StackWithMax<Integer> stack = new StackWithMax<>();
        assertEquals(0, stack.size());

        NoSuchElementException e;

        e = assertThrows(NoSuchElementException.class, () -> new StackWithMax<>().peek());
        assertEquals("Stack is empty", e.getMessage());

        e = assertThrows(NoSuchElementException.class, () -> new StackWithMax<>().pop());
        assertEquals("Stack is empty", e.getMessage());

        e = assertThrows(NoSuchElementException.class, () -> new StackWithMax<>().max());
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testSingleElement() {
        StackWithMax<Integer> stack = new StackWithMax<>();
        stack.push(10);

        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
        assertEquals(10, stack.max());
        assertEquals(10, stack.pop());
        assertEquals(0, stack.size());
        NoSuchElementException e = assertThrows(NoSuchElementException.class, stack::max);
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testMultipleElements() {
        StackWithMax<Integer> stack = new StackWithMax<>();

        // adding items
        stack.push(2);
        assertEquals(2, stack.max());

        stack.push(1);
        assertEquals(2, stack.max());

        stack.push(3);
        assertEquals(3, stack.max());

        stack.push(10);
        assertEquals(10, stack.max());

        stack.push(9);
        assertEquals(10, stack.max());

        stack.push(8);
        assertEquals(10, stack.max());

        stack.push(10);
        assertEquals(10, stack.max());

        stack.push(7);
        assertEquals(10, stack.max());

        stack.push(11);
        assertEquals(11, stack.max());

        // after all added
        assertEquals(9, stack.size());
        assertEquals(11, stack.peek());

        // extracting items
        assertEquals(11, stack.pop());
        assertEquals(10, stack.max());

        assertEquals(7, stack.pop());
        assertEquals(10, stack.max());

        assertEquals(10, stack.pop());
        assertEquals(10, stack.max());

        assertEquals(8, stack.pop());
        assertEquals(10, stack.max());

        assertEquals(9, stack.pop());
        assertEquals(10, stack.max());

        assertEquals(10, stack.pop());
        assertEquals(3, stack.max());

        assertEquals(3, stack.pop());
        assertEquals(2, stack.max());

        assertEquals(1, stack.pop());
        assertEquals(2, stack.max());

        assertEquals(2, stack.pop());
        NoSuchElementException e = assertThrows(NoSuchElementException.class, stack::max);
        assertEquals("Stack is empty", e.getMessage());
    }
}
