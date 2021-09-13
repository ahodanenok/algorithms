package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {

    @Test
    public void testAddAllToEmpty() {
        Bag<String> a = new Bag<>();
        Bag<String> b = new Bag<>();

        List<String> expected = Arrays.asList("b1", "b2", "b3");
        for (String item : expected) {
            b.add(item);
        }

        a.addAll(b);

        assertEquals(3, a.size());
        assertEquals(3, b.size());

        List<String> actual = new ArrayList<>();
        for (String item : a) {
            actual.add(item);
        }

        expected.sort(String::compareTo);
        actual.sort(String::compareTo);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        Bag<String> a = new Bag<>();
        a.add("a");
        a.add("c");
        a.add("b");

        Bag<String> b = new Bag<>();
        b.add("d");
        b.add("b");
        b.add("f");

        a.addAll(b);

        assertEquals(6, a.size());
        List<String> actualA = new ArrayList<>();
        for (String item : a) {
            actualA.add(item);
        }

        assertEquals(3, b.size());
        List<String> actualB = new ArrayList<>();
        for (String item : b) {
            actualB.add(item);
        }

        List<String> expectedA = Arrays.asList("a", "b", "b", "c", "d", "f");
        expectedA.sort(String::compareTo);
        actualA.sort(String::compareTo);
        assertEquals(expectedA, actualA);

        List<String> expectedB = Arrays.asList("b", "d", "f");
        expectedB.sort(String::compareTo);
        actualB.sort(String::compareTo);
        assertEquals(expectedB, actualB);
    }
}
