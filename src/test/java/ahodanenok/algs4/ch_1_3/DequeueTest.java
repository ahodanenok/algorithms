package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DequeueTest {

    @TestFactory
    public Stream<DynamicTest> testDoubleLinkedDeque() {
        return createTests(DoubleLinkedListDeque::new);
    }

    @TestFactory
    public Stream<DynamicTest> testResizingArrayDeque() {
        return Stream.concat(
            createTests(ResizingArrayDeque::new),
            Stream.of(
                dynamicTest("testArrayResizing", this::testArrayResizing)
            )
        );
    }

    @TestFactory
    public Stream<DynamicTest> testDequeWithStackSteque() {
        return createTests(DequeWithStackSteque::new);
    }

    public Stream<DynamicTest> createTests(Supplier<Deque<String>> dequeInstance) {
        return Stream.of(
            dynamicTest("testSizeWhenEmpty", () -> testSizeWhenEmpty(dequeInstance)),
            dynamicTest("testIsEmptyWhenEmpty", () -> testIsEmptyWhenEmpty(dequeInstance)),
            dynamicTest("testSizeWhenOneElementAddedAtStart", () -> testSizeWhenOneElementAddedAtStart(dequeInstance)),
            dynamicTest("testIsEmptyWhenOneElementAddedAtStart", () -> testIsEmptyWhenOneElementAddedAtStart(dequeInstance)),
            dynamicTest("testSizeWhenOneElementAddedAtEnd", () -> testSizeWhenOneElementAddedAtEnd(dequeInstance)),
            dynamicTest("testIsEmptyWhenOneElementAddedAtEnd", () -> testIsEmptyWhenOneElementAddedAtEnd(dequeInstance)),
            dynamicTest("testRemoveElementFromStartWhenEmpty", () -> testRemoveElementFromStartWhenEmpty(dequeInstance)),
            dynamicTest("testRemoveElementFromEndWhenEmpty", () -> testRemoveElementFromEndWhenEmpty(dequeInstance)),
            dynamicTest("testSizeWhenMultipleElements", () -> testSizeWhenMultipleElements(dequeInstance)),
            dynamicTest("testSizeAfterRemoveFromStart", () -> testSizeAfterRemoveFromStart(dequeInstance)),
            dynamicTest("testSizeAfterRemoveFromEnd", () -> testSizeAfterRemoveFromEnd(dequeInstance)),
            dynamicTest("testRemoveFromEnd", () -> testRemoveFromEnd(dequeInstance)),
            dynamicTest("testRemoveFromStart", () -> testRemoveFromStart(dequeInstance)),
            dynamicTest("testClearAndAddToStart", () -> testClearAndAddToStart(dequeInstance)),
            dynamicTest("testClearAndAddToEnd", () -> testClearAndAddToEnd(dequeInstance)),
            dynamicTest("testUsageAsQueue", () -> testUsageAsQueue(dequeInstance)),
            dynamicTest("testUsageAsBackwardsQueue", () -> testUsageAsBackwardsQueue(dequeInstance)),
            dynamicTest("testIteratorWhenEmpty", () -> testIteratorWhenEmpty(dequeInstance)),
            dynamicTest("testIteratorWhenSingleElement", () -> testIteratorWhenSingleElement(dequeInstance)),
            dynamicTest("testIteratorWhenMultipleElement", () -> testIteratorWhenMultipleElement(dequeInstance)));
    }

    public void testSizeWhenEmpty(Supplier<Deque<String>> dequeInstance) {
        assertEquals(0, dequeInstance.get().size());
    }

    public void testIsEmptyWhenEmpty(Supplier<Deque<String>> dequeInstance) {
        assertTrue(dequeInstance.get().isEmpty());
    }

    public void testSizeWhenOneElementAddedAtStart(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");

        assertEquals(1, deque.size());
    }

    public void testIsEmptyWhenOneElementAddedAtStart(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");

        assertFalse(deque.isEmpty());
    }

    public void testSizeWhenOneElementAddedAtEnd(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushRight("a");

        assertEquals(1, deque.size());
    }

    public void testIsEmptyWhenOneElementAddedAtEnd(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushRight("a");

        assertFalse(deque.isEmpty());
    }

    public void testRemoveElementFromStartWhenEmpty(Supplier<Deque<String>> dequeInstance) {
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> dequeInstance.get().popLeft());
        assertEquals("Queue is empty", e.getMessage());
    }

    public void testRemoveElementFromEndWhenEmpty(Supplier<Deque<String>> dequeInstance) {
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> dequeInstance.get().popRight());
        assertEquals("Queue is empty", e.getMessage());
    }

    public void testSizeWhenMultipleElements(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");
        deque.pushRight("a");
        deque.pushLeft("a");

        assertEquals(3, deque.size());
    }

    public void testSizeAfterRemoveFromStart(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popLeft();
        assertEquals(2, deque.size());
    }

    public void testSizeAfterRemoveFromEnd(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");
        deque.pushRight("b");

        deque.popRight();
        assertEquals(1, deque.size());
    }

    public void testRemoveFromStart(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");
        deque.pushRight("b");
        deque.pushLeft("c");

        assertEquals("c", deque.popLeft());
        assertEquals("a", deque.popLeft());
        assertEquals("b", deque.popLeft());
    }

    public void testRemoveFromEnd(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");
        deque.pushRight("b");
        deque.pushLeft("c");
        deque.pushRight("d");

        assertEquals("d", deque.popRight());
        assertEquals("b", deque.popRight());
        assertEquals("a", deque.popRight());
        assertEquals("c", deque.popRight());
    }

    public void testClearAndAddToStart(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.popLeft();
        deque.popLeft();

        deque.pushLeft("c");
        deque.pushLeft("d");
        assertEquals("d", deque.popLeft());
        assertEquals("c", deque.popLeft());
    }

    public void testClearAndAddToEnd(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.popRight();
        deque.popRight();

        deque.pushRight("c");
        deque.pushRight("d");
        assertEquals("d", deque.popRight());
        assertEquals("c", deque.popRight());
    }

    public void testUsageAsQueue(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushRight("a");
        deque.pushRight("b");

        assertEquals("a", deque.popLeft());

        deque.pushRight("c");

        assertEquals("b", deque.popLeft());
        assertEquals("c", deque.popLeft());
    }

    public void testUsageAsBackwardsQueue(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");
        deque.pushLeft("b");

        assertEquals("a", deque.popRight());

        deque.pushLeft("c");

        assertEquals("b", deque.popRight());
        assertEquals("c", deque.popRight());
    }

    public void testIteratorWhenEmpty(Supplier<Deque<String>> dequeInstance) {
        Iterator<String> iterator = new DoubleLinkedListDeque<String>().iterator();
        assertFalse(iterator.hasNext());
    }

    public void testIteratorWhenSingleElement(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");

        Iterator<String> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertFalse(iterator.hasNext());
    }

    public void testIteratorWhenMultipleElement(Supplier<Deque<String>> dequeInstance) {
        Deque<String> deque = dequeInstance.get();
        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");
        deque.pushLeft("d");

        Iterator<String> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertFalse(iterator.hasNext());
    }

    public void testArrayResizing() {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        for (int n = 1; n <= 900; n++) {
            deque.pushLeft(n);
        }
        assertEquals(900, deque.size());

        for (int n = 900; n > 0; n--) {
            assertEquals(n, deque.popLeft());
        }
        assertEquals(0, deque.size());

        for (int n = 1; n <= 900; n++) {
            deque.pushLeft(n);
        }
        assertEquals(900, deque.size());

        for (int n = 900; n > 0; n--) {
            assertEquals(n, deque.popLeft());
        }
        assertEquals(0, deque.size());
    }
}
