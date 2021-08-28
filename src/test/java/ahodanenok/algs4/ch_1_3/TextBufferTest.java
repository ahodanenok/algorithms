package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextBufferTest {

    @Test
    public void testSizeWhenEmpty() {
        TextBuffer buffer = new TextBuffer();
        assertEquals(0, buffer.size());
    }

    @Test
    public void testInitialPosition() {
        TextBuffer buffer = new TextBuffer();
        assertEquals(0, buffer.position());
    }

    @Test
    public void testLeftOverflowWhenEmpty() {
        TextBuffer buffer = new TextBuffer();
        assertDoesNotThrow(() -> buffer.left(10));
        assertEquals(0, buffer.position());
    }

    @Test
    public void testLeftOverflowWhenNotEmpty() {
        TextBuffer buffer = new TextBuffer("word");
        assertDoesNotThrow(() -> buffer.left(123));
        assertEquals(0, buffer.position());
    }

    @Test
    public void testRightOverflowWhenEmpty() {
        TextBuffer buffer = new TextBuffer();
        assertDoesNotThrow(() -> buffer.right(1));
        assertEquals(0, buffer.position());
    }

    @Test
    public void testRightOverflowWhenNotEmpty() {
        TextBuffer buffer = new TextBuffer("msg");
        assertDoesNotThrow(() -> buffer.right(300));
        assertEquals(3, buffer.position());

        buffer.left(2);
        assertDoesNotThrow(() -> buffer.right(100));
        assertEquals(3, buffer.position());
    }

    @Test
    public void testInitialString() {
        TextBuffer buffer = new TextBuffer("hello!");
        assertEquals("hello!", buffer.content());
    }

    @Test
    public void testMoveCursor() {
        TextBuffer buffer = new TextBuffer("abcdef");

        buffer.left(4);
        assertEquals(2, buffer.position());

        buffer.right(2);
        assertEquals(4, buffer.position());
    }

    @Test
    public void testInsertToEmpty() {
        TextBuffer buffer = new TextBuffer();
        buffer.insert('a');
        assertEquals(1, buffer.position());
        assertEquals(1, buffer.size());
        assertEquals("a", buffer.content());
    }

    @Test
    public void testInsertStart() {
        TextBuffer buffer = new TextBuffer("a");

        buffer.left(1);
        buffer.insert('b');
        assertEquals("ba", buffer.content());
        assertEquals(1, buffer.position());
        assertEquals(2, buffer.size());

        buffer.left(1);
        buffer.insert('c');
        assertEquals("cba", buffer.content());
        assertEquals(1, buffer.position());
        assertEquals(3, buffer.size());
    }

    @Test
    public void testInsertEnd() {
        TextBuffer buffer = new TextBuffer("a");

        buffer.insert('b');
        assertEquals("ab", buffer.content());
        assertEquals(2, buffer.position());
        assertEquals(2, buffer.size());

        buffer.insert('c');
        assertEquals("abc", buffer.content());
        assertEquals(3, buffer.position());
        assertEquals(3, buffer.size());
    }

    @Test
    public void testInsertMiddle() {
        TextBuffer buffer = new TextBuffer("world");

        buffer.left(3);
        buffer.insert('-');
        assertEquals("wo-rld", buffer.content());
        assertEquals(3, buffer.position());
        assertEquals(6, buffer.size());

        buffer.right(2);
        buffer.insert('+');
        assertEquals("wo-rl+d", buffer.content());
        assertEquals(6, buffer.position());
        assertEquals(7, buffer.size());
    }

    @Test
    public void testDeleteWhenEmpty() {
        TextBuffer buffer = new TextBuffer();
        assertDoesNotThrow(buffer::delete);
        assertEquals('\0', buffer.delete());
    }

    @Test
    public void testDeleteStart() {
        TextBuffer buffer = new TextBuffer("abc");

        buffer.left(3);
        assertEquals('a', buffer.delete());
        assertEquals("bc", buffer.content());
        assertEquals(0, buffer.position());
        assertEquals(2, buffer.size());

        assertEquals('b', buffer.delete());
        assertEquals("c", buffer.content());
        assertEquals(0, buffer.position());
        assertEquals(1, buffer.size());

        assertEquals('c', buffer.delete());
        assertEquals("", buffer.content());
        assertEquals(0, buffer.position());
        assertEquals(0, buffer.size());
    }

    @Test
    public void testDeleteEnd() {
        TextBuffer buffer = new TextBuffer("abc");

        assertEquals('\0', buffer.delete());
        assertEquals("abc", buffer.content());
        assertEquals(3, buffer.position());
        assertEquals(3, buffer.size());

        buffer.left(1);
        assertEquals('c', buffer.delete());
        assertEquals("ab", buffer.content());
        assertEquals(2, buffer.position());
        assertEquals(2, buffer.size());

        buffer.left(1);
        assertEquals('b', buffer.delete());
        assertEquals("a", buffer.content());
        assertEquals(1, buffer.position());
        assertEquals(1, buffer.size());

        buffer.left(1);
        assertEquals('a', buffer.delete());
        assertEquals("", buffer.content());
        assertEquals(0, buffer.position());
        assertEquals(0, buffer.size());
    }

    @Test
    public void testDeleteMiddle() {
        TextBuffer buffer = new TextBuffer("abcdefg");

        buffer.left(3);
        assertEquals('e', buffer.delete());
        assertEquals("abcdfg", buffer.content());
        assertEquals(4, buffer.position());
        assertEquals(6, buffer.size());

        assertEquals('f', buffer.delete());
        assertEquals("abcdg", buffer.content());
        assertEquals(4, buffer.position());
        assertEquals(5, buffer.size());

        buffer.left(3);
        assertEquals('b', buffer.delete());
        assertEquals("acdg", buffer.content());
        assertEquals(1, buffer.position());
        assertEquals(4, buffer.size());

        buffer.right(1);
        assertEquals('d', buffer.delete());
        assertEquals("acg", buffer.content());
        assertEquals(2, buffer.position());
        assertEquals(3, buffer.size());

        buffer.left(1);
        assertEquals('c', buffer.delete());
        assertEquals("ag", buffer.content());
        assertEquals(1, buffer.position());
        assertEquals(2, buffer.size());
    }
}
