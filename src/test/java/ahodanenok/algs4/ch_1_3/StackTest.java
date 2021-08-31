package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPushPop() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(0, stack.size());

        for (int i = 1; i <= 20; i++) {
            stack.push(i);
            assertEquals(i, stack.size());
        }

        for (int i = 20; i > 0; i--) {
            assertEquals(i, stack.pop());
            assertEquals(i - 1, stack.size());
        }

        for (int i = 1; i <= 20; i++) {
            stack.push(i);
            assertEquals(i, stack.pop());
        }
    }

    @Test
    public void testPeekEmpty() {
        Stack<String> stack = new Stack<>();
        NoSuchElementException e = assertThrows(NoSuchElementException.class, stack::peek);
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testPeekSingleElement() {
        Stack<String> stack = new Stack<>();
        stack.push("a");

        assertEquals("a", stack.peek());
        assertEquals(1, stack.size());

        assertEquals("a", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeekMultipleElements() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");

        assertEquals("b", stack.peek());
        assertEquals(2, stack.size());

        assertEquals("b", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testPopEmpty() {
        Stack<String> stack = new Stack<>();
        NoSuchElementException e = assertThrows(NoSuchElementException.class, stack::pop);
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testPopSingleElement() {
        Stack<String> stack = new Stack<>();
        stack.push("a");

        assertEquals("a", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopMultipleElements() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");

        assertEquals("b", stack.pop());
        assertEquals(1, stack.size());

        assertEquals("a", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testIteratorEmpty() {
        Stack<String> stack = new Stack<>();
        for (String s : stack) {
            fail("Iterator should return no items");
        }
    }

    @Test
    public void testIteratorSingleElement() {
        Stack<String> stack = new Stack<>();
        stack.push("a");

        Iterator<String> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorRightOrder() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        Iterator<String> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("e", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
