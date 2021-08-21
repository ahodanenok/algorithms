package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleNodeTest {

    @Test
    public void testNull() {
        assertNull(DoubleNode.list(null));
    }

    @Test
    public void testSingleElement() {
        DoubleNode<String> list = DoubleNode.list("a");
        assertEquals("a", list.value);
        assertNull(list.prev);
        assertNull(list.next);
    }

    @Test
    public void testTwoElements() {
        DoubleNode<String> currentNode = DoubleNode.list("a", "b");
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testMultipleElements() {
        DoubleNode<String> currentNode = DoubleNode.list("a", "b", "c", "d");
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertEquals("c", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertEquals("d", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("d", currentNode.value);
        assertEquals("c", currentNode.prev.value);
        assertNull(currentNode.next);
    }
}
