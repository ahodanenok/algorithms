package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyQueueTest {

    @Test
    public void testCopyEmpty() {
        Queue<String> queue = new Queue<>();
        Queue<String> copy = CopyQueue.copy(queue);
        assertNotSame(copy, queue);
        assertTrue(copy.isEmpty());
    }

    @Test
    public void testCopyOneElement() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");

        Queue<String> copy = CopyQueue.copy(queue);
        assertNotSame(copy, queue);

        assertEquals("a", copy.dequeue());
        assertTrue(copy.isEmpty());

        assertEquals("a", queue.peek());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testCopyMultipleElements() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        Queue<String> copy = CopyQueue.copy(queue);
        assertNotSame(copy, queue);

        assertEquals("a", copy.dequeue());
        assertEquals("b", copy.dequeue());
        assertEquals("c", copy.dequeue());
        assertEquals("d", copy.dequeue());
        assertTrue(copy.isEmpty());

        assertFalse(queue.isEmpty());
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertEquals("d", queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
