package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertParenthesesTest {

    @Test
    public void test_1() {
        assertEquals("( 1 + 2 )", InsertParentheses.insert("1+2)"));
    }

    @Test
    public void test_2() {
        assertEquals("1 + ( ( 2 + 3 ) + 4 )", InsertParentheses.insert("1+2+3)+4)"));
    }

    @Test
    public void test_3() {
        assertEquals("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )", InsertParentheses.insert("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
    }

    @Test
    public void test_4() {
        assertEquals("( 1 + 2 ) + ( 3 + 4 )", InsertParentheses.insert("1+2)+3+4)"));
    }

    @Test
    public void test_5() {
        assertEquals("( 1 + 2 ) + ( 3 + 4 ) + 5", InsertParentheses.insert("1+2)+3+4)+5"));
    }

    @Test
    public void test_6() {
        assertEquals("1 + ( 2 + 3 ) + ( 4 + 5 ) + 6", InsertParentheses.insert("1+2+3)+4+5)+6"));
    }

    @Test
    public void test_7() {
        assertEquals("( 1 + ( 2 + 3 ) ) + ( 4 + 5 ) + 6", InsertParentheses.insert("1+2+3))+4+5)+6"));
    }

    @Test
    public void test_8() {
        assertEquals("1 + ( ( 2 + 3 ) + ( 4 + 5 ) ) + 6", InsertParentheses.insert("1+2+3)+4+5))+6"));
    }

    @Test
    public void test_9() {
        assertEquals("1 + ( ( 2 + 3 ) + ( 4 + 5 ) ) + 6", InsertParentheses.insert("1+2+3)+4+5))+6"));
    }

    @Test
    public void test_10() {
        assertEquals("1 + ( ( ( ( 2 + 3 ) + ( 4 + 5 ) ) + ( 6 + 7 ) ) + 8 )", InsertParentheses.insert("1+2+3)+4+5))+6+7))+8)"));
    }
}
