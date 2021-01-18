package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KthQueueElementTest {

    @Test
    public void testSingle() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        assertEquals("1", KthQueueElement.kth(queue, 0));
    }

    @Test
    public void testFirst() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        assertEquals("1", KthQueueElement.kth(queue, 2));
    }

    @Test
    public void testMiddle() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        assertEquals("2", KthQueueElement.kth(queue, 1));
    }

    @Test
    public void testLast() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        assertEquals("3", KthQueueElement.kth(queue, 0));
    }

    @Test
    public void testEmpty() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        assertThrows(IllegalArgumentException.class, () -> {
           KthQueueElement.kth(queue, 0);
        });
    }

    @Test
    public void testNegative() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        assertThrows(IllegalArgumentException.class, () -> {
            KthQueueElement.kth(queue, -1);
        });
    }

    @Test
    public void testBeforeFirst() {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        assertThrows(IllegalArgumentException.class, () -> {
            KthQueueElement.kth(queue, 3);
        });
    }
}
