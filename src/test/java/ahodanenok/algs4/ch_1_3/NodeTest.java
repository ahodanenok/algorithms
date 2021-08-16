package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void testNull() {
        assertNull(Node.list(null));
    }

    @Test
    public void testSingleElement() {
        Node<String> list = Node.list("a");
        assertEquals("a", list.value);
        assertNull(list.next);
    }

    @Test
    public void testTwoElements() {
        Node<Integer> list = Node.list(5, 10);
        assertEquals(5, list.value);
        assertEquals(10, list.next.value);
        assertNull(list.next.next);
    }

    @Test
    public void testMultipleElements() {
        Node<Character> list = Node.list('1', '2', '3', '4', '5');
        assertEquals('1', list.value);
        assertEquals('2', list.next.value);
        assertEquals('3', list.next.next.value);
        assertEquals('4', list.next.next.next.value);
        assertEquals('5', list.next.next.next.next.value);
        assertNull(list.next.next.next.next.next);
    }
}
