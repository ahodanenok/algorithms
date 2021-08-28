package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class MoveToFrontTest {

    @Test
    @DisplayName("Given an empty list of strings then should return an empty list also")
    public void testEmpty() {
        assertEquals(0, MoveToFront.applyTo(Collections.emptyList()).size());
    }

    @Test
    @DisplayName("Given a list with one string should return list with the same string")
    public void testOneElement() {
        assertEquals(Collections.singletonList("a"), MoveToFront.applyTo(Collections.singletonList("a")));
    }

    @Test
    @DisplayName("Given a list with multiple strings without duplicates then should return a list with the same strings in reversed order")
    public void testMultipleElementsNoDuplicates() {
        assertEquals(Arrays.asList("e", "d", "c", "b", "a"), MoveToFront.applyTo(Arrays.asList("a", "b", "c", "d", "e")));
    }

    @Test
    @DisplayName("Given a list of duplicates then should return a list with one item")
    public void testMultipleElementsAllDuplicates() {
        assertEquals(Collections.singletonList("b"), MoveToFront.applyTo(Arrays.asList("b", "b", "b", "b")));
    }

    @Test
    @DisplayName("Given a list with multiple strings with duplicates then should return a list with strings in reversed order with duplicates removed")
    public void testMultipleElementsWithDuplicates() {
        assertEquals(Arrays.asList("b", "a"), MoveToFront.applyTo(Arrays.asList("a", "a", "b")));
        assertEquals(Arrays.asList("b", "a"), MoveToFront.applyTo(Arrays.asList("a", "b", "b")));
        assertEquals(Arrays.asList("c", "a", "b"), MoveToFront.applyTo(Arrays.asList("c", "b", "a", "b", "a", "c")));
    }
}
