package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StequeTest {

    @Nested
    public class StequeTwoStacksTests extends DefaultTests {
        @Override
        protected Steque<String> createSteque() {
            return new StequeTwoStacks<>();
        }
    }

    @Nested
    public class LinkedListStequeTests extends DefaultTests {
        @Override
        protected Steque<String> createSteque() {
            return new LinkedListSteque<>();
        }
    }
    
    private static abstract class DefaultTests {
        
        protected abstract Steque<String> createSteque();
        
        @Test
        public void testSizeWhenEmpty() {
            assertEquals(0, createSteque().size());
        }

        @Test
        public void testPeekWhenEmpty() {
            NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> createSteque().peek());
            assertEquals("Steque is empty", e.getMessage());
        }

        @Test
        public void testPopWhenEmpty() {
            NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> createSteque().pop());
            assertEquals("Steque is empty", e.getMessage());
        }

        @Test
        public void testSizeAfterEnqueueOneElement() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");

            assertEquals(1, steque.size());
        }

        @Test
        public void testPeekAfterEnqueueOneElement() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");

            assertEquals("a", steque.peek());
        }

        @Test
        public void testPeekNotRemoveElement() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");

            steque.peek();
            steque.peek();
            steque.peek();
            steque.peek();
            assertEquals(1, steque.size());
        }

        @Test
        public void testPopAfterEnqueueOneElement() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");

            assertEquals("a", steque.pop());
        }

        @Test
        public void testPopRemoveElement() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");

            steque.pop();
            assertEquals(0, steque.size());
        }

        @Test
        public void testSizeAfterEnqueueTwoElements() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.enqueue("b");

            assertEquals(2, steque.size());
        }

        @Test
        public void testPeekAfterEnqueueTwoElements() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.enqueue("b");

            assertEquals("a", steque.peek());
        }

        @Test
        public void testPopAfterEnqueueTwoElements() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.enqueue("b");

            assertEquals("a", steque.pop());
            assertEquals("b", steque.pop());
        }

        @Test
        public void testSizeAfterEnqueueMultipleElements() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.enqueue("b");
            steque.enqueue("c");
            steque.enqueue("d");

            assertEquals(4, steque.size());
        }

        @Test
        public void testPeekAfterEnqueueMultipleElements() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.enqueue("b");
            steque.enqueue("c");
            steque.enqueue("d");

            assertEquals("a", steque.peek());
        }

        @Test
        public void testPopAfterEnqueueMultipleElements() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.enqueue("b");
            steque.enqueue("c");
            steque.enqueue("d");

            assertEquals("a", steque.pop());
            assertEquals("b", steque.pop());
            assertEquals("c", steque.pop());
            assertEquals("d", steque.pop());
        }

        @Test
        public void testSizeAfterPushOneElement() {
            Steque<String> steque = createSteque();
            steque.push("a");

            assertEquals(1, steque.size());
        }

        @Test
        public void testPeekAfterPushOneElement() {
            Steque<String> steque = createSteque();
            steque.push("a");

            assertEquals("a", steque.peek());
        }

        @Test
        public void testPopAfterPushOneElement() {
            Steque<String> steque = createSteque();
            steque.push("a");

            assertEquals("a", steque.pop());
        }

        @Test
        public void testSizeAfterPushTwoElements() {
            Steque<String> steque = createSteque();
            steque.push("a");
            steque.push("b");

            assertEquals(2, steque.size());
        }

        @Test
        public void testPeekAfterPushTwoElements() {
            Steque<String> steque = createSteque();
            steque.push("a");
            steque.push("b");

            assertEquals("b", steque.peek());
        }

        @Test
        public void testPopAfterPushTwoElements() {
            Steque<String> steque = createSteque();
            steque.push("a");
            steque.push("b");

            assertEquals("b", steque.pop());
            assertEquals("a", steque.pop());
        }

        @Test
        public void testSizeAfterPushMultipleElements() {
            Steque<String> steque = createSteque();
            steque.push("a");
            steque.push("b");
            steque.push("c");
            steque.push("d");
            steque.push("e");

            assertEquals(5, steque.size());
        }

        @Test
        public void testPeekAfterPushMultipleElements() {
            Steque<String> steque = createSteque();
            steque.push("a");
            steque.push("b");
            steque.push("c");
            steque.push("d");
            steque.push("e");

            assertEquals("e", steque.peek());
        }

        @Test
        public void testPopAfterPushMultipleElements() {
            Steque<String> steque = createSteque();
            steque.push("a");
            steque.push("b");
            steque.push("c");
            steque.push("d");
            steque.push("e");

            assertEquals("e", steque.pop());
            assertEquals("d", steque.pop());
            assertEquals("c", steque.pop());
            assertEquals("b", steque.pop());
            assertEquals("a", steque.pop());
        }

        @Test
        public void testSizeAfterEnqueuePushSequence() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.push("b");
            steque.enqueue("c");
            steque.push("d");
            steque.enqueue("e");
            steque.push("f");
            steque.enqueue("g");

            assertEquals(7, steque.size());
        }

        @Test
        public void testPeekAfterEnqueuePushSequence() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.push("b");
            steque.enqueue("c");
            steque.push("d");
            steque.enqueue("e");
            steque.push("f");
            steque.enqueue("g");

            assertEquals("f", steque.peek());
        }

        @Test
        public void testPopAfterEnqueuePushSequence() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.push("b");
            steque.enqueue("c");
            steque.push("d");
            steque.enqueue("e");
            steque.push("f");
            steque.enqueue("g");

            // f, d, b, a, c, e, g
            assertEquals("f", steque.pop());
            assertEquals("d", steque.pop());
            assertEquals("b", steque.pop());
            assertEquals("a", steque.pop());
            assertEquals("c", steque.pop());
            assertEquals("e", steque.pop());
            assertEquals("g", steque.pop());
        }

        @Test
        public void testPopAllAndPushNewElements() {
            Steque<String> steque = createSteque();
            steque.push("a");
            steque.push("b");

            steque.pop();
            steque.pop();

            steque.push("c");
            steque.push("d");
            assertEquals(2, steque.size());
            assertEquals("d", steque.pop());
            assertEquals("c", steque.peek());
        }

        @Test
        public void testPopAllAndEnqueueNewElements() {
            Steque<String> steque = createSteque();
            steque.enqueue("a");
            steque.enqueue("b");

            steque.pop();
            steque.pop();

            steque.enqueue("c");
            steque.enqueue("d");
            assertEquals(2, steque.size());
            assertEquals("c", steque.pop());
            assertEquals("d", steque.peek());
        }
    }
}
