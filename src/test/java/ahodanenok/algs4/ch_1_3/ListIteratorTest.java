package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

public class ListIteratorTest {

    @Test
    public void testNavigatingEmpty() {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        ListIterator<String> iterator = deque.listIterator();
        assertFalse(iterator.hasNext());
        assertEquals(0, iterator.nextIndex());
        assertFalse(iterator.hasPrevious());
        assertEquals(-1, iterator.previousIndex());
    }

    @Test
    public void testNavigatingSingleElement() {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        deque.pushRight("a");

        ListIterator<String> iterator = deque.listIterator();

        assertFalse(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.nextIndex());
        assertEquals("a", iterator.next());
        assertFalse(iterator.hasNext());
        assertEquals(1, iterator.nextIndex());
        assertTrue(iterator.hasPrevious());
        assertEquals(0, iterator.previousIndex());
        assertEquals("a", iterator.previous());
        assertEquals(-1, iterator.previousIndex());
        assertFalse(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testNavigatingMultipleElements() {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");
        deque.pushRight("d");

        ListIterator<String> iterator = deque.listIterator();

        assertFalse(iterator.hasPrevious());
        assertEquals(-1, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.nextIndex());
        assertEquals("a", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertEquals(0, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.nextIndex());
        assertEquals("b", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertEquals(1, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.nextIndex());
        assertEquals("c", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertEquals(2, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.nextIndex());
        assertEquals("c", iterator.previous());

        assertTrue(iterator.hasPrevious());
        assertEquals(1, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.nextIndex());
        assertEquals("b", iterator.previous());

        assertTrue(iterator.hasPrevious());
        assertEquals(0, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.nextIndex());
        assertEquals("b", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertEquals(1, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.nextIndex());
        assertEquals("c", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertEquals(2, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.nextIndex());
        assertEquals("d", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertEquals(3, iterator.previousIndex());
        assertFalse(iterator.hasNext());
        assertEquals(4, iterator.nextIndex());
        assertEquals("d", iterator.previous());
    }

    @Test
    public void testSet() {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        ListIterator<String> iterator = deque.listIterator();

        assertThrows(IllegalStateException.class, () -> iterator.set("hello!"));
        assertEquals("a", iterator.next());
        assertDoesNotThrow(() -> iterator.set("a2"));
        assertEquals("a2", iterator.previous());
        assertEquals("a2", iterator.next());
        assertEquals("b", iterator.next());
        assertEquals("c", iterator.next());
        assertEquals("c", iterator.previous());
        assertEquals("b", iterator.previous());
        assertDoesNotThrow(() -> iterator.set("b2"));
        assertEquals("b2", iterator.next());
        assertEquals("c", iterator.next());
        assertDoesNotThrow(() -> iterator.set("c2"));
        assertFalse(iterator.hasNext());

        assertEquals("a2", deque.popLeft());
        assertEquals("b2", deque.popLeft());
        assertEquals("c2", deque.popLeft());
        assertEquals(0, deque.size());
    }

    @Test
    public void testRemove() {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        ListIterator<String> iterator = deque.listIterator();

        assertThrows(IllegalStateException.class, iterator::remove);
        assertEquals("a", iterator.next());
        assertEquals("b", iterator.next());
        assertDoesNotThrow(iterator::remove);
        assertEquals(2, deque.size());

        assertEquals(0, iterator.previousIndex());
        assertEquals(1, iterator.nextIndex());
        assertEquals("c", iterator.next());
        assertEquals("c", iterator.previous());
        assertEquals("a", iterator.previous());
        assertDoesNotThrow(iterator::remove);
        assertEquals(1, deque.size());

        assertFalse(iterator.hasPrevious());
        assertEquals(-1, iterator.previousIndex());
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.nextIndex());
        assertEquals("c", iterator.next());
        assertFalse(iterator.hasNext());
        assertDoesNotThrow(iterator::remove);
        assertEquals(0, deque.size());

        assertFalse(iterator.hasPrevious());
        assertEquals(-1, iterator.previousIndex());
        assertFalse(iterator.hasNext());
        assertEquals(0, iterator.nextIndex());
        assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void testAdd() {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();

        ListIterator<String> iterator = deque.listIterator();

        iterator.add("a");
        assertTrue(iterator.hasPrevious());
        assertEquals(0, iterator.previousIndex());
        assertFalse(iterator.hasNext());
        assertEquals(1, iterator.nextIndex());
        assertEquals(1, deque.size());

        iterator.add("b");
        assertEquals(1, iterator.previousIndex());
        assertEquals(2, iterator.nextIndex());
        assertEquals("b", iterator.previous());
        assertEquals(2, deque.size());

        iterator.add("c");
        assertEquals(1, iterator.previousIndex());
        assertEquals(2, iterator.nextIndex());
        assertEquals("b", iterator.next());
        assertEquals("b", iterator.previous());
        assertEquals("c", iterator.previous());
        assertEquals(3, deque.size());

        assertEquals("a", deque.popLeft());
        assertEquals("c", deque.popLeft());
        assertEquals("b", deque.popLeft());
        assertEquals(0, deque.size());
    }
}
