package ahodanenok.algs4.ch_3_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SequentialSearchStTest extends StTests {

    @Override
    protected <K extends Comparable<K>, V> ST<K, V> createST(int capacity) {
        return new SequentialSearchST<>();
    }

    @Test
    public void testKeys() {
        SequentialSearchST<Character, Integer> st = new SequentialSearchST<>();

        Iterator<Character> keys1 = st.keys();
        assertFalse(keys1.hasNext());

        st.put('a', 10);
        st.put('b', 20);
        st.put('c', 30);

        Iterator<Character> keys2 = st.keys();
        Set<Character> actualKeys = new HashSet<>();
        assertTrue(keys2.hasNext());
        actualKeys.add(keys2.next());
        assertTrue(keys2.hasNext());
        actualKeys.add(keys2.next());
        assertTrue(keys2.hasNext());
        actualKeys.add(keys2.next());
        assertFalse(keys2.hasNext());
        assertEquals(new HashSet<>(Arrays.asList('a', 'b', 'c')), actualKeys);

        st.delete('a');
        st.delete('c');

        Iterator<Character> keys3 = st.keys();
        assertTrue(keys3.hasNext());
        assertEquals('b', keys3.next());
        assertFalse(keys3.hasNext());
    }
}
