package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

/**
 * Web, exercise 1.3.10
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class Palindrome {

    public static void main(String[] args) {
        String str = args[0];
        boolean palindrome = isPalindrome(str);
        System.out.println(palindrome ? "Palindrome" : "Not a palindrome");
    }

    public static boolean isPalindrome(String str) {
        Queue<Character> queue = new Queue<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                queue.enqueue(ch);
                stack.push(ch);
            }
        }

        while (stack.size() > 0) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }

        return true;
    }
}
