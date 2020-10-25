package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParenthesesTest {

    @Test
    public void testEmpty() {
        assertTrue(Parentheses.isBalanced(""));
    }

    @Test
    public void testSquareBalanced() {
        assertTrue(Parentheses.isBalanced("[]"));
    }

    @Test
    public void testSquareNotBalancedSingleOpening() {
        assertFalse(Parentheses.isBalanced("["));
    }

    @Test
    public void testSquareNotBalancedSingleClosing() {
        assertFalse(Parentheses.isBalanced("]"));
    }

    @Test
    public void testSquareNotBalancedOpening() {
        assertFalse(Parentheses.isBalanced("[[]"));
    }

    @Test
    public void testSquareNotBalancedClosing() {
        assertFalse(Parentheses.isBalanced("[]]"));
    }

    @Test
    public void testCurlyBalanced() {
        assertTrue(Parentheses.isBalanced("{}"));
    }

    @Test
    public void testCurlyNotBalancedSingleOpening() {
        assertFalse(Parentheses.isBalanced("{"));
    }

    @Test
    public void testCurlyNotBalancedSingleClosing() {
        assertFalse(Parentheses.isBalanced("}"));
    }

    @Test
    public void testCurlyNotBalancedOpening() {
        assertFalse(Parentheses.isBalanced("{{}"));
    }

    @Test
    public void testCurlyNotBalancedClosing() {
        assertFalse(Parentheses.isBalanced("{}}"));
    }

    @Test
    public void testRoundBalanced() {
        assertTrue(Parentheses.isBalanced("()"));
    }

    @Test
    public void testRoundNotBalancedSingleOpening() {
        assertFalse(Parentheses.isBalanced("("));
    }

    @Test
    public void testRoundNotBalancedSingleClosing() {
        assertFalse(Parentheses.isBalanced(")"));
    }

    @Test
    public void testRoundNotBalancedOpening() {
        assertFalse(Parentheses.isBalanced("(()"));
    }

    @Test
    public void testRoundNotBalancedClosing() {
        assertFalse(Parentheses.isBalanced("())"));
    }

    @Test
    public void testAngleBalanced() {
        assertTrue(Parentheses.isBalanced("<>"));
    }

    @Test
    public void testAngleNotBalancedSingleOpening() {
        assertFalse(Parentheses.isBalanced("<"));
    }

    @Test
    public void testAngleNotBalancedSingleClosing() {
        assertFalse(Parentheses.isBalanced(">"));
    }

    @Test
    public void testAngleNotBalancedOpening() {
        assertFalse(Parentheses.isBalanced("<<>"));
    }

    @Test
    public void testAngleNotBalancedClosing() {
        assertFalse(Parentheses.isBalanced("<>>"));
    }

    @Test
    public void testMixed_1() {
        assertTrue(Parentheses.isBalanced("[()]<{}>{[()()]()}"));
    }

    @Test
    public void testMixed_2() {
        assertFalse(Parentheses.isBalanced("[(])"));
    }
}
