package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
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

    @Test
    public void testIteratorConcurrentModificationError() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");

        Iterator<String> iterator = stack.iterator();

        stack.push("c");
        assertThrows(ConcurrentModificationException.class, iterator::hasNext);
        assertThrows(ConcurrentModificationException.class, iterator::next);

        stack.pop();
        assertThrows(ConcurrentModificationException.class, iterator::hasNext);
        assertThrows(ConcurrentModificationException.class, iterator::next);
    }

    @Test
    public void testBounded() {
        Stack<Integer> stack = Stack.bounded(15);
        for (int n = 0; n < 15; n++) {
            stack.push(n);
        }

        RuntimeException e = assertThrows(RuntimeException.class, () -> stack.push(100));
        assertEquals("Stack is full", e.getMessage());

        int n = 14;
        while (stack.size() > 0) {
            assertEquals(n, stack.pop());
            n--;
        }
    }

    @Test
    public void testReplaceAll() {
        Stack<String> stack = new Stack<>();

        stack.replaceAll("a", "b");
        assertEquals(0, stack.size());

        stack.push("a");
        stack.replaceAll("a", "b");
        assertEquals(1, stack.size());
        assertEquals("b", stack.pop());

        stack.push("c");
        stack.push("d");
        stack.push("c");
        stack.replaceAll("d", "f");
        assertEquals(3, stack.size());
        assertEquals("c", stack.pop());
        assertEquals("f", stack.pop());
        assertEquals("c", stack.pop());

        stack.push("k");
        stack.push("g");
        stack.push("k");
        stack.push("h");
        stack.push("k");
        stack.replaceAll("k", "X");
        assertEquals(5, stack.size());
        assertEquals("X", stack.pop());
        assertEquals("h", stack.pop());
        assertEquals("X", stack.pop());
        assertEquals("g", stack.pop());
        assertEquals("X", stack.pop());
    }

    @Test
    public void testDup() {
        Stack<String> stack = new Stack<>();

        NoSuchElementException e = assertThrows(NoSuchElementException.class, stack::dup);
        assertEquals("Stack is empty", e.getMessage());

        stack.push("a");
        stack.dup();
        assertEquals(2, stack.size());
        assertEquals("a", stack.pop());
        assertEquals("a", stack.pop());
        assertEquals(0, stack.size());

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.dup();
        assertEquals(4, stack.size());
        stack.dup();
        assertEquals(5, stack.size());
        assertEquals("c", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testExch() {
        Stack<String> stack = new Stack<>();

        IllegalStateException e1 = assertThrows(IllegalStateException.class, stack::exch);
        assertEquals("Exch requires at least two items in the stack", e1.getMessage());

        stack.push("a");

        IllegalStateException e2 = assertThrows(IllegalStateException.class, stack::exch);
        assertEquals("Exch requires at least two items in the stack", e2.getMessage());

        stack.push("b");
        stack.exch();
        assertEquals(2, stack.size());
        assertEquals("a", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals(0, stack.size());

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.exch();
        assertEquals(4, stack.size());
        assertEquals("c", stack.pop());

        stack.exch();
        assertEquals(3, stack.size());
        assertEquals("b", stack.pop());

        stack.exch();
        assertEquals(2, stack.size());
        assertEquals("a", stack.peek());

        stack.exch();
        assertEquals("d", stack.pop());
        assertEquals("a", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testMultiPop() {
        Stack<String> stack = new Stack<>();

        IllegalStateException e1 = assertThrows(IllegalStateException.class, () -> stack.multiPop(1));
        assertEquals("Not enough items", e1.getMessage());

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        IllegalStateException e2 = assertThrows(IllegalStateException.class, () -> stack.multiPop(6));
        assertEquals("Not enough items", e2.getMessage());

        List<String> items1 = stack.multiPop(3);
        assertEquals(2, stack.size());
        assertEquals(3, items1.size());
        assertEquals("e", items1.get(0));
        assertEquals("d", items1.get(1));
        assertEquals("c", items1.get(2));

        List<String> items2 = stack.multiPop(2);
        assertEquals(0, stack.size());
        assertEquals(2, items2.size());
        assertEquals("b", items2.get(0));
        assertEquals("a", items2.get(1));
    }
}
