package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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

    @Test
    public void testDeleteNull() {
        NoSuchElementException e = assertThrows(
                NoSuchElementException.class, () -> LinkedListMethods.delete(null, 0));
        assertEquals("No element at index 0", e.getMessage());
    }

    @Test
    public void testDeleteNegative() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> LinkedListMethods.delete(Node.list(1, 2), -1));
        assertEquals("Index must be >= 0", e.getMessage());
    }

    @Test
    public void testDeleteSingleElement() {
        assertNull(LinkedListMethods.delete(Node.list("abc"), 0));
    }

    @Test
    public void testDeleteSingleElementNoFound() {
        NoSuchElementException e = assertThrows(
                NoSuchElementException.class, () -> LinkedListMethods.delete(Node.list("abc"), 1));
        assertEquals("No element at index 1", e.getMessage());
    }

    @Test
    public void testDeleteFirstTwoElements() {
        Node<Integer> list = LinkedListMethods.delete(Node.list(100, 200), 0);
        assertNotNull(list);
        assertEquals(200, list.value);
        assertNull(list.next);
    }

    @Test
    public void testDeleteSecondTwoElements() {
        Node<Integer> list = LinkedListMethods.delete(Node.list(100, 200), 1);
        assertNotNull(list);
        assertEquals(100, list.value);
        assertNull(list.next);
    }

    @Test
    public void testDeleteTwoElementsNotFound() {
        NoSuchElementException e = assertThrows(
                NoSuchElementException.class, () -> LinkedListMethods.delete(Node.list(100, 200), 2));
        assertEquals("No element at index 2", e.getMessage());
    }

    @Test
    public void testDeleteFirstMultipleElements() {
        Node<String> list = LinkedListMethods.delete(Node.list("a", "b", "c", "d", "e"), 0);
        assertNotNull(list);
        assertEquals("b", list.value);
        assertEquals("c", list.next.value);
        assertEquals("d", list.next.next.value);
        assertEquals("e", list.next.next.next.value);
        assertNull(list.next.next.next.next);
    }

    @Test
    public void testDeleteMiddleMultipleElements() {
        Node<String> list = LinkedListMethods.delete(Node.list("a", "b", "c", "d", "e"), 2);
        assertNotNull(list);
        assertEquals("a", list.value);
        assertEquals("b", list.next.value);
        assertEquals("d", list.next.next.value);
        assertEquals("e", list.next.next.next.value);
        assertNull(list.next.next.next.next);
    }

    @Test
    public void testDeleteLastMultipleElements() {
        Node<String> list = LinkedListMethods.delete(Node.list("a", "b", "c", "d", "e"), 4);
        assertNotNull(list);
        assertEquals("a", list.value);
        assertEquals("b", list.next.value);
        assertEquals("c", list.next.next.value);
        assertEquals("d", list.next.next.next.value);
        assertNull(list.next.next.next.next);
    }

    @Test
    public void testDeleteMultipleElementsNotFound() {
        NoSuchElementException e = assertThrows(
                NoSuchElementException.class, () -> LinkedListMethods.delete(Node.list("a", "b", "c", "d", "e"), 5));
        assertEquals("No element at index 5", e.getMessage());
    }

    @Test
    public void testFindNoElements() {
        assertFalse(LinkedListMethods.find(null, "a"));
    }

    @Test
    public void testFindSingleElementFound() {
        assertTrue(LinkedListMethods.find(Node.list("a"), "a"));
    }

    @Test
    public void testFindSingleElementNotFound() {
        assertFalse(LinkedListMethods.find(Node.list("b"), "a"));
    }

    @Test
    public void testFindTwoElementsFoundFirst() {
        assertTrue(LinkedListMethods.find(Node.list("c", "d"), "c"));
    }

    @Test
    public void testFindTwoElementsFoundSecond() {
        assertTrue(LinkedListMethods.find(Node.list("c", "d"), "d"));
    }

    @Test
    public void testFindTwoElementsNotFound() {
        assertFalse(LinkedListMethods.find(Node.list("c", "d"), "e"));
    }

    @Test
    public void testFindMultipleElementsFoundFirst() {
        assertTrue(LinkedListMethods.find(Node.list("a", "b", "c", "d", "e"), "a"));
    }

    @Test
    public void testFindMultipleElementsFoundMiddle() {
        assertTrue(LinkedListMethods.find(Node.list("a", "b", "c", "d", "e"), "c"));
    }

    @Test
    public void testFindMultipleElementsFoundLast() {
        assertTrue(LinkedListMethods.find(Node.list("a", "b", "c", "d", "e"), "e"));
    }

    @Test
    public void testFindMultipleElementsNotFound() {
        assertFalse(LinkedListMethods.find(Node.list("a", "b", "c", "d", "e"), "f"));
    }

    @Test
    public void testRemoveAfterNull() {
        assertDoesNotThrow(() -> LinkedListMethods.removeAfter(null));
    }

    @Test
    public void testRemoveAfterSingleElement() {
        Node<String> list = Node.list("a");
        LinkedListMethods.removeAfter(list);
        assertEquals("a", list.value);
        assertNull(list.next);
    }

    @Test
    public void testRemoveAfterWithNext() {
        Node<String> list = Node.list("a", "b");
        LinkedListMethods.removeAfter(list);
        assertEquals("a", list.value);
        assertNull(list.next);
    }

    @Test
    public void testRemoveAfterWithMultipleNext() {
        Node<String> list = Node.list("a", "b", "c");
        LinkedListMethods.removeAfter(list);
        assertEquals("a", list.value);
        assertEquals("c", list.next.value);
        assertNull(list.next.next);
    }

    @Test
    public void testInsertAfterAllNull() {
        assertDoesNotThrow(() -> LinkedListMethods.insertAfter(null, null));
    }

    @Test
    public void testInsertAfterNodeNull() {
        Node<String> list = Node.list("a");
        assertDoesNotThrow(() -> LinkedListMethods.insertAfter(null, list));
        assertEquals("a", list.value);
        assertNull(list.next);
    }

    @Test
    public void testInsertAfterInsertedNull() {
        Node<String> list = Node.list("a");
        assertDoesNotThrow(() -> LinkedListMethods.insertAfter(list, null));
        assertEquals("a", list.value);
        assertNull(list.next);
    }

    @Test
    public void testInsertAfterFirst() {
        Node<String> list = Node.list("a", "b");
        assertDoesNotThrow(() -> LinkedListMethods.insertAfter(list, Node.list("c")));
        assertEquals("a", list.value);
        assertEquals("c", list.next.value);
        assertEquals("b", list.next.next.value);
        assertNull(list.next.next.next);
    }

    @Test
    public void testInsertAfterEnd() {
        Node<String> list = Node.list("a", "b");
        assertDoesNotThrow(() -> LinkedListMethods.insertAfter(list.next, Node.list("c")));
        assertEquals("a", list.value);
        assertEquals("b", list.next.value);
        assertEquals("c", list.next.next.value);
        assertNull(list.next.next.next);
    }

    @Test
    public void testRemoveNull() {
        assertNull(LinkedListMethods.remove(null, "a"));
    }

    @Test
    public void testRemoveSingleElementFound() {
        assertNull(LinkedListMethods.remove(Node.list("a"), "a"));
    }

    @Test
    public void testRemoveSingleElementNotFound() {
        Node<String> list = LinkedListMethods.remove(Node.list("a"), "b");
        assertEquals("a", list.value);
        assertNull(list.next);
    }

    @Test
    public void testRemoveTwoElementsFirst() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b"), "a");
        assertEquals("b", list.value);
        assertNull(list.next);
    }

    @Test
    public void testRemoveTwoElementsLast() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b"), "b");
        assertEquals("a", list.value);
        assertNull(list.next);
    }

    @Test
    public void testRemoveTwoElementsAll() {
        assertNull(LinkedListMethods.remove(Node.list("b", "b"), "b"));
    }

    @Test
    public void testRemoveMultipleElementsFirst() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b", "c", "d", "e"), "a");
        assertEquals("b", list.value);
        assertEquals("c", list.next.value);
        assertEquals("d", list.next.next.value);
        assertEquals("e", list.next.next.next.value);
        assertNull(list.next.next.next.next);
    }

    @Test
    public void testRemoveMultipleElementsMiddle() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b", "c", "d", "e"), "c");
        assertEquals("a", list.value);
        assertEquals("b", list.next.value);
        assertEquals("d", list.next.next.value);
        assertEquals("e", list.next.next.next.value);
        assertNull(list.next.next.next.next);
    }

    @Test
    public void testRemoveMultipleElementsLast() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b", "c", "d", "e"), "e");
        assertEquals("a", list.value);
        assertEquals("b", list.next.value);
        assertEquals("c", list.next.next.value);
        assertEquals("d", list.next.next.next.value);
        assertNull(list.next.next.next.next);
    }

    @Test
    public void testRemoveMultipleElementsFirstLast() {
        Node<String> list = LinkedListMethods.remove(Node.list("e", "b", "c", "d", "e"), "e");
        assertEquals("b", list.value);
        assertEquals("c", list.next.value);
        assertEquals("d", list.next.next.value);
        assertNull(list.next.next.next);
    }

    @Test
    public void testRemoveMultipleElementsNotFound() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b", "c", "d", "e"), "f");
        assertEquals("a", list.value);
        assertEquals("b", list.next.value);
        assertEquals("c", list.next.next.value);
        assertEquals("d", list.next.next.next.value);
        assertEquals("e", list.next.next.next.next.value);
        assertNull(list.next.next.next.next.next);
    }

    @Test
    public void testRemoveMultipleElementsAll() {
        assertNull(LinkedListMethods.remove(Node.list("a", "a", "a", "a", "a"), "a"));
    }

    @Test
    public void testRemoveMultipleElementsSeparated() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b", "c", "b", "e"), "b");
        assertEquals("a", list.value);
        assertEquals("c", list.next.value);
        assertEquals("e", list.next.next.value);
        assertNull(list.next.next.next);
    }

    @Test
    public void testRemoveMultipleElementsFollowing() {
        Node<String> list = LinkedListMethods.remove(Node.list("a", "b", "b", "b", "e"), "b");
        assertEquals("a", list.value);
        assertEquals("e", list.next.value);
        assertNull(list.next.next);
    }
}
