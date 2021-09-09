package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BagTriplicatesTest {

    @Test
    public void testEmpty() {
        assertFalse(BagTriplicates.containsTriplicates(new Bag<>()));
    }

    @Test
    public void testSingleElement() {
        Bag<String> bag = new Bag<>();
        bag.add("a");

        assertFalse(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testTwoElements() {
        Bag<String> bag = new Bag<>();
        bag.add("a");
        bag.add("a");

        assertFalse(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testThreeElementsEqual() {
        Bag<String> bag = new Bag<>();
        bag.add("b");
        bag.add("b");
        bag.add("b");

        assertTrue(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testThreeElementsNotEqual() {
        Bag<String> bag = new Bag<>();
        bag.add("c");
        bag.add("d");
        bag.add("c");

        assertFalse(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testMultipleElementsNotEqual() {
        Bag<String> bag = new Bag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("a");
        bag.add("e");

        assertFalse(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualAtStart() {
        Bag<String> bag = new Bag<>();
        bag.add("c");
        bag.add("c");
        bag.add("c");
        bag.add("a");
        bag.add("b");

        assertTrue(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualAtEnd() {
        Bag<String> bag = new Bag<>();
        bag.add("a");
        bag.add("b");
        bag.add("d");
        bag.add("d");
        bag.add("d");

        assertTrue(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualAtStartEnd() {
        Bag<String> bag = new Bag<>();
        bag.add("f");
        bag.add("f");
        bag.add("c");
        bag.add("e");
        bag.add("f");

        assertTrue(BagTriplicates.containsTriplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualInMiddle() {
        Bag<String> bag = new Bag<>();
        bag.add("e");
        bag.add("c");
        bag.add("c");
        bag.add("c");
        bag.add("f");

        assertTrue(BagTriplicates.containsTriplicates(bag));
    }
}
