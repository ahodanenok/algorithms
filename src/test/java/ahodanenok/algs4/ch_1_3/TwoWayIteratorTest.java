package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TwoWayIteratorTest {

    @Test
    public void testEmpty() {
        TwoWayIteratorList<String> list = new TwoWayIteratorList<>();
        TwoWayIteratorList<String>.TwoWayIterator iterator = list.iterator();

        assertFalse(iterator.hasPrevious());
        assertFalse(iterator.hasNext());

        NoSuchElementException en = assertThrows(NoSuchElementException.class, iterator::next);
        assertEquals("next", en.getMessage());

        NoSuchElementException ep = assertThrows(NoSuchElementException.class, iterator::previous);
        assertEquals("previous", ep.getMessage());
    }

    @Test
    public void testSingleElement() {
        TwoWayIteratorList<String> list = new TwoWayIteratorList<>("a");
        TwoWayIteratorList<String>.TwoWayIterator iterator = list.iterator();

        assertFalse(iterator.hasPrevious());
        NoSuchElementException ep = assertThrows(NoSuchElementException.class, iterator::previous);
        assertEquals("previous", ep.getMessage());

        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertFalse(iterator.hasNext());
        NoSuchElementException en = assertThrows(NoSuchElementException.class, iterator::next);
        assertEquals("next", en.getMessage());

        assertTrue(iterator.hasPrevious());
        assertEquals("a", iterator.previous());
        assertTrue(iterator.hasNext());
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void testMultipleElements() {
        TwoWayIteratorList<String> list = new TwoWayIteratorList<>("a", "b", "c");
        TwoWayIteratorList<String>.TwoWayIterator iterator = list.iterator();

        assertFalse(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.previous());

        assertTrue(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());

        assertTrue(iterator.hasPrevious());
        assertFalse(iterator.hasNext());
        assertEquals("c", iterator.previous());
    }
}
