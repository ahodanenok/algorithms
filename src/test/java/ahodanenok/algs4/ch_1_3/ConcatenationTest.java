package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConcatenationTest {

    @Nested
    public class QueueTests {

        @Test
        @DisplayName("Given all queues are empty then concatenation should return an empty queue")
        public void testConcatenateQueuesEmpty() {
            Queue<?> result = Concatenation.concatenateQueues(queueOf(), queueOf(), queueOf());
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Given no queues then concatenation should return an empty queue")
        public void testConcatenateQueuesNone() {
            assertTrue(Concatenation.concatenateQueues().isEmpty());
        }

        @Test
        @DisplayName("Given some queues then concatenation should produce a new queue and extract all elements from the given queues in the process")
        public void testConcatenateQueuesDestructive() {
            Queue<String> a = queueOf("a");
            Queue<String> b = queueOf();
            Queue<String> c = queueOf("c", "d");

            Queue<?> result = Concatenation.concatenateQueues(a, b, c);

            assertTrue(a.isEmpty());
            assertNotSame(result, a);

            assertTrue(b.isEmpty());
            assertNotSame(result, b);

            assertTrue(c.isEmpty());
            assertNotSame(result, c);
        }

        @Test
        @DisplayName("Given some queues then concatenation should return a queue containing all elements from the given queues in the right order")
        public void testConcatenateQueues() {
            performConcatenateQueuesTest(queueOf("b", "c"), queueOf(), queueOf("b"), queueOf("c"));
            performConcatenateQueuesTest(queueOf("a", "b", "c"), queueOf("a"), queueOf("b"), queueOf("c"));
            performConcatenateQueuesTest(queueOf("a", "b", "c", "d", "e"), queueOf("a"), queueOf("b", "c", "d"), queueOf("e"));
            performConcatenateQueuesTest(queueOf(100, 200, 300, 10, 20), queueOf(100, 200, 300), queueOf(10), queueOf(20));
        }

        @SafeVarargs
        private final <T> void performConcatenateQueuesTest(Queue<T> expectedQueue, Queue<T>... queues) {
            Queue<T> resultQueue = Concatenation.concatenateQueues(queues);
            assertEquals(expectedQueue.size(), resultQueue.size());
            while (!expectedQueue.isEmpty()) {
                assertEquals(expectedQueue.dequeue(), resultQueue.dequeue());
            }
        }

        @SafeVarargs
        private final <T> Queue<T> queueOf(T... items) {
            Queue<T> queue = new Queue<>();
            for (T item : items) {
                queue.enqueue(item);
            }

            return queue;
        }
    }

    @Nested
    public class StackTests {

        @Test
        @DisplayName("Given all stacks are empty then concatenation should return an empty stack")
        public void testConcatenateStacksEmpty() {
            Stack<?> result = Concatenation.concatenateStacks(stackOf(), stackOf(), stackOf());
            assertEquals(0, result.size());
        }

        @Test
        @DisplayName("Given no stacks then concatenation should return an empty stack")
        public void testConcatenateStacksNone() {
            assertEquals(0, Concatenation.concatenateStacks().size());
        }


        @Test
        @DisplayName("Given some stacks then concatenation should produce a new stack and extract all elements from the given stacks in the process")
        public void testConcatenateStacksDestructive() {
            Stack<String> a = stackOf("a");
            Stack<String> b = stackOf();
            Stack<String> c = stackOf("c", "d");

            Stack<?> result = Concatenation.concatenateStacks(a, b, c);

            assertEquals(0, a.size());
            assertNotSame(result, a);

            assertEquals(0, b.size());
            assertNotSame(result, b);

            assertEquals(0, c.size());
            assertNotSame(result, c);
        }

        @Test
        @DisplayName("Given some stacks then concatenation should return a stack containing all elements from the given stacks in the right order")
        public void testConcatenateStacks() {
            performConcatenateStacksTest(stackOf("b", "c"), stackOf(), stackOf("b"), stackOf("c"));
            performConcatenateStacksTest(stackOf("a", "b", "c"), stackOf("a"), stackOf("b"), stackOf("c"));
            performConcatenateStacksTest(stackOf("a", "b", "c", "d", "e"), stackOf("a"), stackOf("b", "c", "d"), stackOf("e"));
            performConcatenateStacksTest(stackOf(100, 200, 300, 10, 20), stackOf(100, 200, 300), stackOf(10), stackOf(20));
        }

        @SafeVarargs
        private final <T> void performConcatenateStacksTest(Stack<T> expectedStack, Stack<T>... stacks) {
            Stack<T> resultStack = Concatenation.concatenateStacks(stacks);
            assertEquals(expectedStack.size(), resultStack.size());
            while (expectedStack.size() > 0) {
                assertEquals(expectedStack.pop(), resultStack.pop());
            }
        }

        @SafeVarargs
        private final <T> Stack<T> stackOf(T... items) {
            Stack<T> stack = new Stack<>();
            for (int i = items.length - 1; i >= 0; i--) {
                stack.push(items[i]);
            }

            return stack;
        }
    }

    @Nested
    public class StequeTests {

        @Test
        @DisplayName("Given all steques are empty then concatenation should return an empty steque")
        public void testConcatenateStequeEmpty() {
            Steque<?> result = Concatenation.concatenateSteques(stequeOf(), stequeOf(), stequeOf());
            assertEquals(0, result.size());
        }

        @Test
        @DisplayName("Given no steques then concatenation should return an empty steque")
        public void testConcatenateStequesNone() {
            assertEquals(0, Concatenation.concatenateSteques().size());
        }

        @Test
        @DisplayName("Given some steques then concatenation should produce a new steque and extract all elements from the given steques in the process")
        public void testConcatenateStequesDestructive() {
            Steque<String> a = stequeOf("a");
            Steque<String> b = stequeOf();
            Steque<String> c = stequeOf("c", "d");

            Steque<?> result = Concatenation.concatenateSteques(a, b, c);

            assertEquals(0, a.size());
            assertNotSame(result, a);

            assertEquals(0, b.size());
            assertNotSame(result, b);

            assertEquals(0, c.size());
            assertNotSame(result, c);
        }

        @Test
        @DisplayName("Given some steques then concatenation should return a steque containing all elements from the given steques in the right order")
        public void testConcatenateSteques() {
            performConcatenateStequesTest(stequeOf("b", "c"), stequeOf(), stequeOf("b"), stequeOf("c"));
            performConcatenateStequesTest(stequeOf("a", "b", "c"), stequeOf("a"), stequeOf("b"), stequeOf("c"));
            performConcatenateStequesTest(stequeOf("a", "b", "c", "d", "e"), stequeOf("a"), stequeOf("b", "c", "d"), stequeOf("e"));
            performConcatenateStequesTest(stequeOf(100, 200, 300, 10, 20), stequeOf(100, 200, 300), stequeOf(10), stequeOf(20));
        }

        @SafeVarargs
        private final <T> void performConcatenateStequesTest(Steque<T> expectedSteque, Steque<T>... steques) {
            Steque<T> resultSteque = Concatenation.concatenateSteques(steques);
            assertEquals(expectedSteque.size(), resultSteque.size());
            while (expectedSteque.size() > 0) {
                assertEquals(expectedSteque.pop(), resultSteque.pop());
            }
        }

        @SafeVarargs
        private final <T> Steque<T> stequeOf(T... items) {
            Steque<T> steque = new LinkedListSteque<>();
            for (T item : items) {
                steque.enqueue(item);
            }

            return steque;
        }
    }
}
