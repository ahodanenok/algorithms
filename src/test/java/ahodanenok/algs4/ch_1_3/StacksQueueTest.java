package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StacksQueueTest {

    @Test
    public void testSizeEmpty() {
        assertEquals(0, new StacksQueue<>().size());
    }

    @Test
    public void testDequeueEmpty() {
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> new StacksQueue<>().dequeue());
        assertEquals("Queue is empty", e.getMessage());
    }

    @Test
    public void testDequeue() {
        StacksQueue<String> queue = new StacksQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals(3, queue.size());
        assertEquals("a", queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals("b", queue.dequeue());
        assertEquals(1, queue.size());

        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");

        assertEquals(4, queue.size());
        assertEquals("c", queue.dequeue());
        assertEquals(3, queue.size());
        assertEquals("d", queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals("e", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("f", queue.dequeue());
        assertEquals(0, queue.size());
    }
}
