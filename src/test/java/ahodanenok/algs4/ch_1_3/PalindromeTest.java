package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    public void testPalindromes() {
        assertTrue(Palindrome.isPalindrome("A"));
        assertTrue(Palindrome.isPalindrome("121"));
        assertTrue(Palindrome.isPalindrome("LEVEL!"));
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindrome("Was it a car or a cat I saw?"));
        assertTrue(Palindrome.isPalindrome("Rats live on no evil star"));
        assertTrue(Palindrome.isPalindrome("A MAN, A PLAN, A CANAL - PANAMA"));
    }

    @Test
    public void testNotPalindromes() {
        assertFalse(Palindrome.isPalindrome("AB"));
        assertFalse(Palindrome.isPalindrome("1321"));
        assertFalse(Palindrome.isPalindrome("wo0w"));
        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("level to level"));
    }
}
