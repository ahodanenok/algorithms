package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void testPeek() {
        Stack<String> stack = new Stack<>();
        assertEquals(0, stack.size());
        stack.push("1");
        assertEquals(1, stack.size());
        stack.push("2");
        assertEquals(2, stack.size());
        assertEquals("2", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testEmpty() {
        Stack<String> stack = new Stack<>();
        assertThrows(IllegalStateException.class, stack::pop);
    }
}
