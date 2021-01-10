package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResizingArrayQueueOfStringsTest {

    @Test
    public void testAddRemoveSingle() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        assertEquals(0, queue.size());
        queue.enqueue("a");
        assertEquals(1, queue.size());

        assertEquals("a", queue.dequeue());
        assertEquals(0, queue.size());

        queue.enqueue("b");
        assertEquals(1, queue.size());
        assertEquals("b", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testAddRemoveMultiple() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals(3, queue.size());
        assertEquals("a", queue.dequeue());

        assertEquals(2, queue.size());
        assertEquals("b", queue.dequeue());

        assertEquals(1, queue.size());
        assertEquals("c", queue.dequeue());

        assertEquals(0, queue.size());
    }

    @Test
    public void testIntermixed() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals(3, queue.size());

        assertEquals("a", queue.dequeue());
        assertEquals(2, queue.size());

        queue.enqueue("d");
        assertEquals(3, queue.size());

        assertEquals("b", queue.dequeue());
        assertEquals(2, queue.size());

        queue.enqueue("e");
        assertEquals(3, queue.size());

        queue.enqueue("f");
        assertEquals(4, queue.size());

        assertEquals("c", queue.dequeue());
        assertEquals(3, queue.size());

        assertEquals("d", queue.dequeue());
        assertEquals(2, queue.size());

        assertEquals("e", queue.dequeue());
        assertEquals(1, queue.size());

        queue.enqueue("g");
        assertEquals(2, queue.size());

        assertEquals("f", queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals("g", queue.dequeue());
        assertEquals(0, queue.size());
    }
}
