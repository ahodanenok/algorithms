package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class GeneralizedQueueTest {

    @Nested
    public class LinkedListGeneralizedQueueTest extends DefaultTests {

        @Override
        protected GeneralizedQueue<String> createQueue() {
            return new LinkedListGeneralizedQueue<>();
        }
    }

    @Nested
    public class ResizingArrayGeneralizedQueueTest extends DefaultTests {

        @Override
        protected GeneralizedQueue<String> createQueue() {
            return new ResizingArrayGeneralizedQueue<>();
        }

        @Test
        public void testResize() {
            ResizingArrayGeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
            for (int i = 0; i < 2; i++) {
                for (int n = 0; n < 1000; n++) {
                    queue.insert(n);
                }

                int expectedNumber = 0;
                while (!queue.isEmpty()) {
                    assertEquals(expectedNumber, queue.delete(0));
                    expectedNumber++;
                }
            }
        }
    }

    private abstract static class DefaultTests {

        protected abstract GeneralizedQueue<String> createQueue();

        @Test
        public void testIsEmpty() {
            GeneralizedQueue<String> queue = createQueue();
            assertTrue(queue.isEmpty());

            queue.insert("a");
            assertFalse(queue.isEmpty());

            queue.delete(0);
            assertTrue(queue.isEmpty());
        }

        @Test
        public void testRemoveWhenEmpty() {
            GeneralizedQueue<String> queue = createQueue();
            NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> queue.delete(0));
            assertEquals("Queue is empty", e.getMessage());
        }

        @Test
        public void testRemoveNotExistingElement() {
            GeneralizedQueue<String> queue = createQueue();
            queue.insert("a");

            NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> queue.delete(1));
            assertEquals("No element at position 1", e.getMessage());
        }

        @Test
        public void testRemoveWhenOneElement() {
            GeneralizedQueue<String> queue = createQueue();
            queue.insert("a");
            assertEquals("a", queue.delete(0));
        }

        @Test
        public void testRemoveFirstElement() {
            GeneralizedQueue<String> queue = createQueue();
            queue.insert("a");
            queue.insert("b");
            queue.insert("c");

            assertEquals("a", queue.delete(0));
            assertEquals("b", queue.delete(0));
            assertEquals("c", queue.delete(0));
        }

        @Test
        public void testRemoveMiddleElement() {
            GeneralizedQueue<String> queue = createQueue();
            queue.insert("a");
            queue.insert("b");
            queue.insert("c");
            queue.insert("d");
            queue.insert("e");

            assertEquals("c", queue.delete(2));
            assertEquals("d", queue.delete(2));
            assertEquals("b", queue.delete(1));
        }

        @Test
        public void testRemoveLastElement() {
            GeneralizedQueue<String> queue = createQueue();
            queue.insert("a");
            queue.insert("b");
            queue.insert("c");

            assertEquals("c", queue.delete(2));
            assertEquals("b", queue.delete(1));
            assertEquals("a", queue.delete(0));
        }
    }
}
