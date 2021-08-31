package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackGenerabilityTest {

    @Test
    public void testUnderflowEmpty() {
        assertFalse(StackGenerability.isUnderflow(""));
    }

    @Test
    public void testUnderflowOnlyPush() {
        assertFalse(StackGenerability.isUnderflow("1"));
        assertFalse(StackGenerability.isUnderflow("2 3"));
        assertFalse(StackGenerability.isUnderflow("4 5 6 7 8 9"));
    }

    @Test
    public void testUnderflowOnlyPop() {
        assertTrue(StackGenerability.isUnderflow("-"));
    }

    @Test
    public void testUnderflowNotBalanced() {
        assertTrue(StackGenerability.isUnderflow("1 - -"));
        assertTrue(StackGenerability.isUnderflow("2 - 3 - -"));
        assertTrue(StackGenerability.isUnderflow("4 - 5 - 6 - -"));
    }

    @Test
    public void testUnderflowBalanced() {
        assertFalse(StackGenerability.isUnderflow("1 -"));
        assertFalse(StackGenerability.isUnderflow("2 - 3 -"));
        assertFalse(StackGenerability.isUnderflow("4 - 5 - 6 -"));
    }

    @Test
    public void testValidEmpty() {
        assertTrue(StackGenerability.isValidPermutation(""));
    }

    @Test
    public void testValidOneNumber() {
        assertTrue(StackGenerability.isValidPermutation("1"));
    }

    @Test
    public void testValidIncreasing() {
        assertTrue(StackGenerability.isValidPermutation("1 2"));
        assertTrue(StackGenerability.isValidPermutation("1 2 3 4"));
        assertTrue(StackGenerability.isValidPermutation("0 1 2 3 4 5 6 7 8 9"));
    }

    @Test
    public void testValidDecreasing() {
        assertTrue(StackGenerability.isValidPermutation("2 1"));
        assertTrue(StackGenerability.isValidPermutation("4 3 2 1"));
        assertTrue(StackGenerability.isValidPermutation("9 8 7 6 5 4 3 2 1 0"));
    }

    @Test
    public void testValidLegal() {
        assertTrue(StackGenerability.isValidPermutation("2 3 1"));
        assertTrue(StackGenerability.isValidPermutation("2 1 3"));
        assertTrue(StackGenerability.isValidPermutation("1 3 2"));
        assertTrue(StackGenerability.isValidPermutation("1 2 4 3"));
        assertTrue(StackGenerability.isValidPermutation("1 3 2 4"));
        assertTrue(StackGenerability.isValidPermutation("1 3 4 2"));
        assertTrue(StackGenerability.isValidPermutation("1 4 3 2"));
        assertTrue(StackGenerability.isValidPermutation("2 1 3 4"));
        assertTrue(StackGenerability.isValidPermutation("2 1 4 3"));
        assertTrue(StackGenerability.isValidPermutation("2 3 1 4"));
        assertTrue(StackGenerability.isValidPermutation("2 3 4 1"));
        assertTrue(StackGenerability.isValidPermutation("2 4 3 1"));
        assertTrue(StackGenerability.isValidPermutation("3 2 1 4"));
        assertTrue(StackGenerability.isValidPermutation("3 2 4 1"));
        assertTrue(StackGenerability.isValidPermutation("3 4 2 1"));
    }

    @Test
    public void testValidIllegal() {
        assertFalse(StackGenerability.isValidPermutation("3 1 2"));
        assertFalse(StackGenerability.isValidPermutation("1 4 2 3"));
        assertFalse(StackGenerability.isValidPermutation("2 4 1 3"));
        assertFalse(StackGenerability.isValidPermutation("3 1 2 4"));
        assertFalse(StackGenerability.isValidPermutation("3 1 4 2"));
        assertFalse(StackGenerability.isValidPermutation("3 4 1 2"));
        assertFalse(StackGenerability.isValidPermutation("4 1 2 3"));
        assertFalse(StackGenerability.isValidPermutation("4 1 3 2"));
        assertFalse(StackGenerability.isValidPermutation("4 2 1 3"));
        assertFalse(StackGenerability.isValidPermutation("4 2 3 1"));
        assertFalse(StackGenerability.isValidPermutation("4 3 1 2"));
    }
}
