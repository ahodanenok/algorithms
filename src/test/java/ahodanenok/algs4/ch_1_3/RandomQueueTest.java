package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class RandomQueueTest {

    @Test
    public void testIsEmptyWhenEmpty() {
        RandomQueue<String> queue = new RandomQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyWhenElementAdded() {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("a");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsEmptyWhenElementRemoved() {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("a");
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueAddsElement() {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("a");
        assertEquals("a", queue.dequeue());
    }

    @Test
    public void testEnqueueAddsMultipleElements() {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        Set<String> items = new HashSet<>();
        while (!queue.isEmpty()) {
            items.add(queue.dequeue());
        }

        assertEquals(new HashSet<>(Arrays.asList("a", "b", "c")), items);
    }

    @RepeatedTest(10)
    public void testDequeRemovesRandomElements() {
        List<String> testItems = Arrays.asList("a", "b", "c", "d", "e", "f");
        Set<String> testItemsSet = new HashSet<>(testItems);

        Function<RandomQueue<String>, List<String>> permutationProducer = queue -> {
            for (String item : testItems) {
                queue.enqueue(item);
            }

            List<String> permutation = new ArrayList<>();
            while (!queue.isEmpty()) {
                permutation.add(queue.dequeue());
            }

            return permutation;
        };

        // different queues
        List<String> permutation1 = permutationProducer.apply(new RandomQueue<>());
        List<String> permutation2 = permutationProducer.apply(new RandomQueue<>());
        assertEquals(testItemsSet, new HashSet<>(permutation1));
        assertEquals(testItemsSet, new HashSet<>(permutation2));
        assertNotEquals(permutation1, permutation2);

        // same queue
        RandomQueue<String> queue = new RandomQueue<>();
        List<String> permutation3 = permutationProducer.apply(queue);
        List<String> permutation4 = permutationProducer.apply(queue);
        assertEquals(testItemsSet, new HashSet<>(permutation3));
        assertEquals(testItemsSet, new HashSet<>(permutation4));
        assertNotEquals(permutation3, permutation4);
    }

    @Test
    public void testSampleNotRemovesItem() {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("a");

        assertEquals("a", queue.sample());
        assertFalse(queue.isEmpty());
        assertEquals("a", queue.sample());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testSampleReturnsRandomItems() {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");

        // how it is likely that count won't have any of the items after all iterations
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            counts.compute(queue.sample(), (k, v) -> v != null ? v + 1 : 0);
        }

        assertEquals(5, counts.size());
        assertFalse(counts.values().stream().anyMatch(value -> value == 0));
    }

    @Test
    public void testCanHoldManyItems() {
        RandomQueue<Integer> queue = new RandomQueue<>();
        for (int n = 1; n <= 100_000; n++) {
            queue.enqueue(n);
        }

        Set<Integer> items = new HashSet<>();
        while (!queue.isEmpty()) {
            items.add(queue.dequeue());
        }

        for (int n = 1_000_000; n <= 2_000_000; n++) {
            queue.enqueue(n);
        }
        while (!queue.isEmpty()) {
            items.add(queue.dequeue());
        }

        IntStream itemsStream = IntStream.concat(
                IntStream.rangeClosed(1, 100_000), IntStream.rangeClosed(1_000_000, 2_000_000));
        Set<Integer> expectedItems = itemsStream.boxed().collect(Collectors.toSet());

        assertEquals(expectedItems, items);
    }
}
