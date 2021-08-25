package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RandomBagTest {

    @Test
    public void testIllegalInitialCapacity() {
        IllegalArgumentException e;

        e = assertThrows(IllegalArgumentException.class, () -> new RandomBag<>(0));
        assertEquals("Initial capacity must be > 0", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> new RandomBag<>(-1));
        assertEquals("Initial capacity must be > 0", e.getMessage());
    }

    @Test
    public void testSizeWhenEmpty() {
        assertEquals(0, new RandomBag<>().size());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        assertTrue(new RandomBag<>().isEmpty());
    }

    @Test
    public void testSizeWhenAddingItems() {
        RandomBag<String> bag = new RandomBag<>();

        bag.add("a");
        assertEquals(1, bag.size());

        bag.add("b");
        assertEquals(2, bag.size());

        bag.add("c");
        assertEquals(3, bag.size());
    }

    @Test
    public void testIsEmptyWhenElementAdded() {
        RandomBag<String> bag = new RandomBag<>();
        bag.add("a");

        assertFalse(bag.isEmpty());
    }

    @Test
    public void testErrorIfTooManyElements() {
        RandomBag<String> bag = new RandomBag<>(4);

        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");

        RuntimeException e = assertThrows(RuntimeException.class, () -> bag.add("e"));
        assertEquals("Bag is full", e.getMessage());
    }

    @Test
    public void testIterator() {
        RandomBag<String> bag = new RandomBag<>(8);
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");

        Set<String> retrievedItems = new HashSet<>();
        Iterator<String> iterator = bag.iterator();
        while (iterator.hasNext()) {
            retrievedItems.add(iterator.next());
        }

        assertEquals(new HashSet<>(Arrays.asList("a", "b", "c", "d", "e")), retrievedItems);
    }

    @Test
    public void testRandomIterator() {
        RandomBag<String> bag = new RandomBag<>(8);
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");
        bag.add("f");
        bag.add("g");
        bag.add("h");

        List<List<String>> permutations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> items = new ArrayList<>();
            for (String item : bag) {
                items.add(item);
            }

            permutations.add(items);
        }

        for (int i = 0; i < permutations.size(); i++) {
            for (int j = i + 1; j < permutations.size(); j++) {
                assertNotEquals(permutations.get(i), permutations.get(j));
            }
        }
    }
}
