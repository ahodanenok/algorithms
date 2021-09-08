package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BagDuplicatesTest {

    @Test
    public void testEmpty() {
        assertFalse(BagDuplicates.containsDuplicates(new Bag<>()));
    }

    @Test
    public void testSingleElement() {
        Bag<String> bag = new Bag<>();
        bag.add("a");

        assertFalse(BagDuplicates.containsDuplicates(bag));
    }

    @Test
    public void testTwoElementsEqual() {
        Bag<String> bag = new Bag<>();
        bag.add("b");
        bag.add("b");

        assertTrue(BagDuplicates.containsDuplicates(bag));
    }

    @Test
    public void testTwoElementsNotEqual() {
        Bag<String> bag = new Bag<>();
        bag.add("c");
        bag.add("d");

        assertFalse(BagDuplicates.containsDuplicates(bag));
    }

    @Test
    public void testMultipleElementsNotEqual() {
        Bag<String> bag = new Bag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        assertFalse(BagDuplicates.containsDuplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualAtStart() {
        Bag<String> bag = new Bag<>();
        bag.add("c");
        bag.add("c");
        bag.add("a");

        assertTrue(BagDuplicates.containsDuplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualAtEnd() {
        Bag<String> bag = new Bag<>();
        bag.add("b");
        bag.add("d");
        bag.add("d");

        assertTrue(BagDuplicates.containsDuplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualAtStartEnd() {
        Bag<String> bag = new Bag<>();
        bag.add("f");
        bag.add("c");
        bag.add("f");

        assertTrue(BagDuplicates.containsDuplicates(bag));
    }

    @Test
    public void testMultipleElementsEqualInMiddle() {
        Bag<String> bag = new Bag<>();
        bag.add("e");
        bag.add("c");
        bag.add("c");
        bag.add("f");

        assertTrue(BagDuplicates.containsDuplicates(bag));
    }
}
