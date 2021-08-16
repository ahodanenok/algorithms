package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListMethodsTest {

    @Test
    public void testRemoveLastNull() {
        assertNull(LinkedListMethods.removeLast(null));
    }

    @Test
    public void testRemoveLastSingleElement() {
        assertNull(LinkedListMethods.removeLast(Node.list(1)));
    }

    @Test
    public void testRemoveLastTwoElements() {
        Node<String> list = LinkedListMethods.removeLast(Node.list("aa", "bb"));
        assertNotNull(list);
        assertEquals("aa", list.value);
        assertNull(list.next);
    }

    @Test
    public void testRemoveLastMultipleElements() {
        Node<Integer> list = LinkedListMethods.removeLast(Node.list(1, 2, 3, 4));
        assertNotNull(list);
        assertEquals(1, list.value);
        assertEquals(2, list.next.value);
        assertEquals(3, list.next.next.value);
        assertNull(list.next.next.next);
    }
}
