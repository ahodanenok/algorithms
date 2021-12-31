package ahodanenok.algs4.ch_3_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchStTest extends StTests {

    @Override
    protected <K extends Comparable<K>, V> ST<K, V> createST(int capacity) {
        return new BinarySearchST<>(capacity);
    }

    @Override
    protected boolean isCapacityBounded() {
        return true;
    }

    @Test
    public void testFloor() {
        BinarySearchST<Integer, Character> st = new BinarySearchST<>(5);
        assertNull(st.floor(3));

        st.put(3, 'a');
        assertNull(st.floor(2));
        assertEquals('a', st.floor(3));
        assertEquals('a', st.floor(4));

        st.put(5, 'b');
        assertEquals('a', st.floor(3));
        assertEquals('a', st.floor(4));
        assertEquals('b', st.floor(5));
        assertEquals('b', st.floor(6));

        st.put(7, 'c');
        assertEquals('a', st.floor(3));
        assertEquals('a', st.floor(4));
        assertEquals('b', st.floor(5));
        assertEquals('b', st.floor(6));
        assertEquals('c', st.floor(7));
        assertEquals('c', st.floor(8));
        assertEquals('c', st.floor(Integer.MAX_VALUE));
    }
}
