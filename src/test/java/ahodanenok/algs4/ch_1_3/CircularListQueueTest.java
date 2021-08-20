package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CircularListQueueTest {

    @Test
    public void testSizeWhenEmpty() {
        CircularListQueue<String> queue = new CircularListQueue<>();
        assertEquals(0, queue.size());
    }

    @Test
    public void testPeekThrowsErrorIfEmpty() {
        CircularListQueue<String> queue = new CircularListQueue<>();
        NoSuchElementException e = assertThrows(NoSuchElementException.class, queue::peek);
        assertEquals("Queue is empty", e.getMessage());
    }

    @Test
    public void testDequeueThrowsErrorIfEmpty() {
        CircularListQueue<String> queue = new CircularListQueue<>();
        NoSuchElementException e = assertThrows(NoSuchElementException.class, queue::dequeue);
        assertEquals("Queue is empty", e.getMessage());
    }

    @Test
    public void testEnqueueDequeueOneElement() {
        CircularListQueue<String> queue = new CircularListQueue<>();
        queue.enqueue("a");

        assertEquals(1, queue.size());
        assertEquals("a", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueDequeueTwoElements() {
        CircularListQueue<String> queue = new CircularListQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");

        assertEquals(2, queue.size());
        assertEquals("a", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("b", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueDequeueMultipleElements() {
        CircularListQueue<String> queue = new CircularListQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");

        assertEquals(5, queue.size());
        assertEquals("a", queue.dequeue());
        assertEquals(4, queue.size());
        assertEquals("b", queue.dequeue());
        assertEquals(3, queue.size());
        assertEquals("c", queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals("d", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("e", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueDequeueMix() {
        CircularListQueue<String> queue = new CircularListQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");

        assertEquals(2, queue.size());
        assertEquals("a", queue.dequeue());
        assertEquals(1, queue.size());

        queue.enqueue("c");
        queue.enqueue("d");

        assertEquals(3, queue.size());
        assertEquals("b", queue.dequeue());
        assertEquals(2, queue.size());

        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("g");

        assertEquals(5, queue.size());
        assertEquals("c", queue.dequeue());
        assertEquals(4, queue.size());
        assertEquals("d", queue.dequeue());
        assertEquals(3, queue.size());
        assertEquals("e", queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals("f", queue.dequeue());
        assertEquals(1, queue.size());

        queue.enqueue("h");
        assertEquals(2, queue.size());
        assertEquals("g", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("h", queue.dequeue());
        assertEquals(0, queue.size());

        queue.enqueue("k");
        queue.enqueue("m");
        assertEquals(2, queue.size());
        assertEquals("k", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("m", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testPeekSingleElement() {
        CircularListQueue<Integer> queue = new CircularListQueue<>();
        queue.enqueue(100);

        assertEquals(100, queue.peek());
        assertEquals(1, queue.size());
        assertEquals(100, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void testPeekTwoElements() {
        CircularListQueue<Integer> queue = new CircularListQueue<>();
        queue.enqueue(100);
        queue.enqueue(200);

        assertEquals(100, queue.peek());
        assertEquals(2, queue.size());
        assertEquals(100, queue.peek());
        assertEquals(2, queue.size());
    }
}
