package ahodanenok.algs4.ch_3_1;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class StTests {

    protected abstract <K extends Comparable<K>, V> ST<K, V> createST(int capacity);

    protected boolean isCapacityBounded() {
        return false;
    }

    @Test
    public void testEmpty() {
        ST<String, Boolean> st = createST(10);
        assertEquals(0, st.size());
        assertNull(st.get("test"));
    }

    @Test
    public void testAddElements() {
        ST<Character, Integer> st = createST(5);

        st.put('a', 10);
        assertEquals(10, st.get('a'));
        assertNull(st.get('b'));
        assertEquals(1, st.size());

        st.put('b', 20);
        assertEquals(10, st.get('a'));
        assertEquals(20, st.get('b'));
        assertNull(st.get('c'));
        assertEquals(2, st.size());

        st.put('c', 30);
        assertEquals(10, st.get('a'));
        assertEquals(20, st.get('b'));
        assertEquals(30, st.get('c'));
        assertNull(st.get('d'));
        assertEquals(3, st.size());
    }

    @Test
    public void testUpdateElements() {
        ST<String, Character> st = createST(3);

        st.put("s1", 'a');
        st.put("s2", 'b');
        assertEquals('a', st.get("s1"));
        assertEquals('b', st.get("s2"));
        assertEquals(2, st.size());

        st.put("s1", 'a');
        st.put("s2", 'b');
        assertEquals('a', st.get("s1"));
        assertEquals('b', st.get("s2"));
        assertEquals(2, st.size());
    }

    @Test
    public void testRemoveElements() {
        ST<Integer, String> st = createST(5);

        st.put(100, "a");
        st.put(200, "b");
        st.put(300, "c");
        st.put(400, "d");
        st.put(500, "e");

        assertEquals(5, st.size());

        st.put(200, null);
        assertEquals(4, st.size());
        assertEquals("a", st.get(100));
        assertNull(st.get(200));
        assertEquals("c", st.get(300));
        assertEquals("d", st.get(400));
        assertEquals("e", st.get(500));

        st.put(400, null);
        assertEquals(3, st.size());
        assertEquals("a", st.get(100));
        assertNull(st.get(200));
        assertEquals("c", st.get(300));
        assertNull(st.get(400));
        assertEquals("e", st.get(500));

        st.put(100, null);
        assertEquals(2, st.size());
        assertNull(st.get(100));
        assertNull(st.get(200));
        assertEquals("c", st.get(300));
        assertNull(st.get(400));
        assertEquals("e", st.get(500));

        st.put(500, null);
        assertEquals(1, st.size());
        assertNull(st.get(100));
        assertNull(st.get(200));
        assertEquals("c", st.get(300));
        assertNull(st.get(400));
        assertNull(st.get(500));

        st.put(300, null);
        assertEquals(0, st.size());
        assertNull(st.get(100));
        assertNull(st.get(200));
        assertNull(st.get(300));
        assertNull(st.get(400));
        assertNull(st.get(500));
    }

    @Test
    public void testRemoveNotExistingMapping() {
        ST<String, String> st = createST(5);
        assertEquals(0, st.size());

        st.put("a", null);
        assertEquals(0, st.size());

        st.put("b", "c");
        assertEquals(1, st.size());

        st.put("c", null);
        assertEquals(1, st.size());
        assertEquals("c", st.get("b"));
    }

    @Test
    public void testCapacity() {
        Assumptions.assumeTrue(isCapacityBounded());

        ST<String, Integer> st1 = createST(0);
        IllegalStateException e1 = assertThrows(IllegalStateException.class, () -> st1.put("a", 10));
        assertEquals("ST is full", e1.getMessage());

        ST<String, Integer> st2 = createST(4);
        st2.put("a", 1);
        st2.put("b", 2);
        st2.put("c", 3);
        st2.put("d", 4);
        IllegalStateException e2 = assertThrows(IllegalStateException.class, () -> st2.put("e", 5));
        assertEquals("ST is full", e2.getMessage());
    }

    @Test
    public void testContains() {
        ST<String, Integer> st = createST(5);
        assertFalse(st.contains("a"));
        assertNull(st.get("a"));

        st.put("a", 1);
        assertTrue(st.contains("a"));
        assertEquals(1, st.get("a"));
        assertNull(st.get("b"));
        assertFalse(st.contains("b"));

        st.put("b", 2);
        assertTrue(st.contains("b"));
        assertEquals(2, st.get("b"));

        assertTrue(st.contains("b"));
        assertTrue(st.contains("a"));
        assertEquals(2, st.get("b"));
        assertEquals(1, st.get("a"));
    }
}
