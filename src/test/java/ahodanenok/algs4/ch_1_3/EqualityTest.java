package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EqualityTest {

    @Test
    public void testEmptyBagsEqual() {
        assertTrue(Equality.bagsEqual(new Bag<>(), new Bag<>()));
    }

    @Test
    public void testBagsWithSingleItemEqual() {
        Bag<String> a = new Bag<>();
        a.add("a");

        Bag<String> b = new Bag<>();
        b.add("a");

        assertTrue(Equality.bagsEqual(a, b));
    }

    @Test
    public void testBagsWithSingleItemNotEqual() {
        Bag<String> a = new Bag<>();
        a.add("a");

        Bag<String> b = new Bag<>();
        b.add("b");

        assertFalse(Equality.bagsEqual(a, b));
    }

    @Test
    public void testBagsWithDifferentSizesNotEqual() {
        Bag<String> a = new Bag<>();
        a.add("a");
        a.add("a");

        Bag<String> b = new Bag<>();
        b.add("a");
        b.add("a");
        b.add("a");

        assertFalse(Equality.bagsEqual(a, b));
    }

    @Test
    public void testBagsWithDifferentItemsCountsNotEqual() {
        Bag<String> a = new Bag<>();
        a.add("a");
        a.add("a");
        a.add("b");

        Bag<String> b = new Bag<>();
        b.add("a");
        b.add("b");
        b.add("b");

        assertFalse(Equality.bagsEqual(a, b));
    }

    @Test
    public void testBagsWithMultipleItemsNotEqual() {
        Bag<String> a = new Bag<>();
        a.add("a");
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("e");
        a.add("d");
        a.add("e");

        Bag<String> b = new Bag<>();
        b.add("c");
        b.add("b");
        b.add("a");
        b.add("d");
        b.add("a");
        b.add("a");
        b.add("e");

        assertFalse(Equality.bagsEqual(a, b));
    }

    @Test
    public void testBagsWithMultipleItemsEqual() {
        Bag<String> a = new Bag<>();
        a.add("a");
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        a.add("c");
        a.add("a");

        Bag<String> b = new Bag<>();
        b.add("c");
        b.add("b");
        b.add("c");
        b.add("d");
        b.add("e");
        b.add("a");
        b.add("a");
        b.add("a");

        assertTrue(Equality.bagsEqual(a, b));
    }

    @Test
    public void testEmptyQueuesEqual() {
        assertTrue(Equality.queuesEqual(new Queue<>(), new Queue<>()));
    }

    @Test
    public void testQueuesWithSingleItemEqual() {
        Queue<Integer> a = new Queue<>();
        a.enqueue(10);

        Queue<Integer> b = new Queue<>();
        b.enqueue(10);

        assertTrue(Equality.queuesEqual(a, b));
    }

    @Test
    public void testQueuesWithSingleItemNotEqual() {
        Queue<Integer> a = new Queue<>();
        a.enqueue(10);

        Queue<Integer> b = new Queue<>();
        b.enqueue(11);

        assertFalse(Equality.queuesEqual(a, b));
    }

    @Test
    public void testQueuesWithDifferentSizesNotEqual() {
        Queue<Integer> a = new Queue<>();
        a.enqueue(10);
        a.enqueue(20);
        a.enqueue(30);

        Queue<Integer> b = new Queue<>();
        b.enqueue(11);
        b.enqueue(21);

        assertFalse(Equality.queuesEqual(a, b));
    }

    @Test
    public void testQueuesWithSameItemsEqual() {
        Queue<Integer> a = new Queue<>();
        a.enqueue(10);
        a.enqueue(20);
        a.enqueue(30);
        a.enqueue(30);
        a.enqueue(30);

        Queue<Integer> b = new Queue<>();
        b.enqueue(10);
        b.enqueue(20);
        b.enqueue(30);
        b.enqueue(30);
        b.enqueue(30);

        assertTrue(Equality.queuesEqual(a, b));
    }

    @Test
    public void testQueuesWithDifferentItemsNotEqual() {
        Queue<Integer> a = new Queue<>();
        a.enqueue(10);
        a.enqueue(20);
        a.enqueue(30);
        a.enqueue(30);
        a.enqueue(30);

        Queue<Integer> b = new Queue<>();
        b.enqueue(10);
        b.enqueue(20);
        b.enqueue(30);
        b.enqueue(30);
        b.enqueue(40);

        assertFalse(Equality.queuesEqual(a, b));
    }
}
