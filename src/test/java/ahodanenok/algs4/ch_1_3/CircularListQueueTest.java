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

    @Test
    public void testToArray() {
        CircularListQueue<String> queue = new CircularListQueue<>();

        String[] array1 = queue.toArray(String.class);
        assertEquals(0, array1.length);

        queue.enqueue("a");
        String[] array2 = queue.toArray(String.class);
        assertEquals(1, array2.length);
        assertEquals("a", array2[0]);

        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        String[] array3 = queue.toArray(String.class);
        assertEquals(4, array3.length);
        assertEquals("a", array3[0]);
        assertEquals("b", array3[1]);
        assertEquals("c", array3[2]);
        assertEquals("d", array3[3]);

        queue.dequeue();
        String[] array4 = queue.toArray(String.class);
        assertEquals(3, array4.length);
        assertEquals("b", array4[0]);
        assertEquals("c", array4[1]);
        assertEquals("d", array4[2]);
    }

    @Test
    public void testReverse() {
        CircularListQueue<String> queue = new CircularListQueue<>();

        assertDoesNotThrow(queue::reverse);

        queue.enqueue("a");
        queue.reverse();
        assertEquals(1, queue.size());
        assertEquals("a", queue.peek());

        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.reverse();
        assertEquals(4, queue.size());
        assertEquals("d", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("a", queue.dequeue());
    }
}
