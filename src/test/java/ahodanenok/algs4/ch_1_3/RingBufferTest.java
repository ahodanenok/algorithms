package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class RingBufferTest {

    @Test
    @DisplayName("When buffer doesn't contain any items then isEmpty() should return `true`")
    public void testIsEmptyWhenEmpty() {
        RingBuffer<String> buffer = new RingBuffer<>();
        assertTrue(buffer.isEmpty());
    }

    @Test
    @DisplayName("When buffer contains at least one item then isEmpty() should return `false`")
    public void testIsEmptyWhenNotEmpty() {
        RingBuffer<String> buffer = new RingBuffer<>();
        buffer.push("a");
        assertFalse(buffer.isEmpty());

        buffer.push("b");
        assertFalse(buffer.isEmpty());
    }

    @Test
    @DisplayName("Given some items in buffer when all of them removed then isEmpty() should return `true`")
    public void testIsEmptyAllRemoved() {
        RingBuffer<String> buffer = new RingBuffer<>();
        buffer.push("a");
        buffer.push("b");
        buffer.push("c");

        buffer.poll();
        buffer.poll();
        buffer.poll();
        assertTrue(buffer.isEmpty());
    }

    @Test
    @DisplayName("Given no initial capacity then capacity() should return default capacity despite number of items added to buffer")
    public void testDefaultCapacity() {
        RingBuffer<Integer> buffer = new RingBuffer<>();
        assertEquals(10, buffer.capacity());

        for (int n = 0; n < 20; n++) {
            buffer.push(n);
            assertEquals(10, buffer.capacity());
        }
    }

    @Test
    @DisplayName("Given initial capacity then capacity() should return it despite number of items added to buffer")
    public void testCapacity() {
        RingBuffer<Integer> buffer = new RingBuffer<>(5);
        assertEquals(5, buffer.capacity());

        for (int n = 0; n < 10; n++) {
            buffer.push(n);
            assertEquals(5, buffer.capacity());
        }
    }

    @Test
    @DisplayName("Given buffer is empty then poll() should throw error")
    public void testPollWhenEmpty() {
        RingBuffer<String> buffer = new RingBuffer<>();
        NoSuchElementException e = assertThrows(NoSuchElementException.class, buffer::poll);
        assertEquals("Buffer is empty", e.getMessage());
    }

    @Test
    @DisplayName("Given one item in buffer then poll() should return it")
    public void testPollWhenOneElement() {
        RingBuffer<String> buffer = new RingBuffer<>();
        buffer.push("a");
        assertEquals("a", buffer.poll());
    }

    @Test
    @DisplayName("Given some items in buffer then poll() should return them in fifo order")
    public void testPollWhenMultipleElements() {
        RingBuffer<String> buffer = new RingBuffer<>();
        buffer.push("a");
        buffer.push("b");
        buffer.push("c");
        buffer.push("d");

        assertEquals("a", buffer.poll());
        assertEquals("b", buffer.poll());
        assertEquals("c", buffer.poll());
        assertEquals("d", buffer.poll());
    }

    @Test
    @DisplayName("When there are more items than buffer's capacity then the oldest items should be replaced with the new ones")
    public void testBufferOverflow() {
        RingBuffer<String> buffer = new RingBuffer<>(3);

        buffer.push("a");
        buffer.push("b");
        buffer.push("c");
        buffer.push("d");
        assertEquals("b", buffer.poll());
        assertEquals("c", buffer.poll());
        assertEquals("d", buffer.poll());
        assertTrue(buffer.isEmpty());

        buffer.push("a");
        buffer.push("b");
        buffer.push("c");
        buffer.push("d");
        buffer.push("e");
        assertEquals("c", buffer.poll());
        assertEquals("d", buffer.poll());
        assertEquals("e", buffer.poll());
        assertTrue(buffer.isEmpty());

        buffer.push("a");
        buffer.push("b");
        buffer.push("c");
        buffer.push("d");
        buffer.push("e");
        buffer.push("f");
        assertEquals("d", buffer.poll());
        assertEquals("e", buffer.poll());
        assertEquals("f", buffer.poll());
        assertTrue(buffer.isEmpty());
    }
}
