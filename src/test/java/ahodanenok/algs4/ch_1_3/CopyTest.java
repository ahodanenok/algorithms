package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyTest {

    @Test
    public void copyEmpty() {
        Stack<String> stack = new Stack<>();
        Stack<String> copy = Copy.copy(stack);
        assertNotSame(stack, copy);

        assertEquals(0, stack.size());
        assertEquals(0, copy.size());
    }

    @Test
    public void copySingleElement() {
        Stack<String> stack = new Stack<>();
        stack.push("test");

        Stack<String> copy = Copy.copy(stack);
        assertNotSame(stack, copy);

        assertEquals(1, stack.size());
        assertEquals(1, copy.size());

        assertEquals("test", stack.pop());
        assertEquals("test", copy.pop());
    }

    @Test
    public void copyMultipleElements() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        Stack<String> copy = Copy.copy(stack);
        assertNotSame(stack, copy);

        assertEquals(3, stack.size());
        assertEquals(3, copy.size());

        assertEquals("c", stack.pop());
        assertEquals("c", copy.pop());

        assertEquals("b", stack.pop());
        assertEquals("b", copy.pop());

        assertEquals("a", stack.pop());
        assertEquals("a", copy.pop());
    }
}
