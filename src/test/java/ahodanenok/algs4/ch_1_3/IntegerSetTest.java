package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    public void testEmpty() {
        assertEquals(0, new IntegerSet(100).size());
    }

    @Test
    public void testExistsEmpty() {
        assertFalse(new IntegerSet(10).exists(9));
    }

    @Test
    public void testRemoveEmpty() {
        assertFalse(new IntegerSet(64).remove(63));
    }

    @Test
    public void testAdd() {
        IntegerSet set = new IntegerSet(10);

        assertFalse(set.exists(0));
        assertTrue(set.add(0));
        assertTrue(set.exists(0));
        assertEquals(1, set.size());

        assertFalse(set.exists(1));
        assertTrue(set.add(1));
        assertTrue(set.exists(1));
        assertEquals(2, set.size());

        assertFalse(set.exists(2));
        assertTrue(set.add(2));
        assertTrue(set.exists(2));
        assertEquals(3, set.size());

        assertFalse(set.add(2));
        assertEquals(3, set.size());

        assertFalse(set.add(1));
        assertEquals(3, set.size());

        assertFalse(set.add(0));
        assertEquals(3, set.size());
    }

    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet(128);

        assertFalse(set.remove(10));
        assertEquals(0, set.size());

        assertTrue(set.add(10));
        assertTrue(set.add(11));
        assertEquals(2, set.size());

        assertTrue(set.remove(10));
        assertFalse(set.exists(10));
        assertFalse(set.remove(10));
        assertEquals(1, set.size());

        assertTrue(set.remove(11));
        assertFalse(set.exists(11));
        assertFalse(set.remove(11));
        assertEquals(0, set.size());
    }

    @Test
    public void testIsSubset() {
        IntegerSet a = new IntegerSet(10);
        IntegerSet b = new IntegerSet(6);

        assertTrue(a.isSubsetOf(a));
        assertTrue(a.isSubsetOf(b));
        assertTrue(b.isSubsetOf(a));
        assertTrue(b.isSubsetOf(b));

        a.add(3);
        assertFalse(a.isSubsetOf(b));
        assertTrue(a.isSubsetOf(a));
        assertTrue(b.isSubsetOf(a));

        b.add(3);
        b.add(4);
        assertTrue(a.isSubsetOf(b));
        assertFalse(b.isSubsetOf(a));
        assertTrue(b.isSubsetOf(b));

        a.add(8);
        assertTrue(a.isSubsetOf(a));
        assertFalse(a.isSubsetOf(b));
        assertFalse(b.isSubsetOf(a));
    }

    @Test
    public void testIsSuperset() {
        IntegerSet a = new IntegerSet(5);
        IntegerSet b = new IntegerSet(7);

        assertTrue(a.isSupersetFor(a));
        assertTrue(a.isSupersetFor(b));
        assertTrue(b.isSupersetFor(a));
        assertTrue(b.isSupersetFor(b));

        b.add(3);
        assertFalse(a.isSupersetFor(b));
        assertTrue(b.isSupersetFor(a));
        assertTrue(b.isSupersetFor(b));

        a.add(2);
        a.add(4);
        assertTrue(a.isSupersetFor(a));
        assertFalse(a.isSupersetFor(b));
        assertFalse(b.isSupersetFor(a));

        a.add(3);
        assertTrue(a.isSupersetFor(a));
        assertTrue(a.isSupersetFor(b));
        assertFalse(b.isSupersetFor(a));
    }

    @Test
    public void testIsDisjoint() {
        IntegerSet a = new IntegerSet(7);
        IntegerSet b = new IntegerSet(8);

        assertTrue(a.isDisjointFrom(a));
        assertTrue(a.isDisjointFrom(b));
        assertTrue(b.isDisjointFrom(a));
        assertTrue(b.isDisjointFrom(b));

        a.add(1);
        assertFalse(a.isDisjointFrom(a));
        assertTrue(a.isDisjointFrom(b));
        assertTrue(b.isDisjointFrom(a));

        b.add(6);
        assertTrue(a.isDisjointFrom(b));
        assertTrue(b.isDisjointFrom(a));
        assertFalse(b.isDisjointFrom(b));

        a.add(4);
        assertFalse(a.isDisjointFrom(a));
        assertTrue(a.isDisjointFrom(b));
        assertTrue(b.isDisjointFrom(a));

        b.add(4);
        assertFalse(a.isDisjointFrom(b));
        assertFalse(b.isDisjointFrom(a));
        assertFalse(b.isDisjointFrom(b));
    }

    @Test
    public void testIntersect() {
        IntegerSet a = new IntegerSet(7);
        IntegerSet b = new IntegerSet(8);

        IntegerSet s1 = a.intersect(b);
        assertEquals(0, s1.size());
        IntStream.range(0, 8).forEach(n -> assertFalse(s1.exists(n)));

        IntegerSet s2 = b.intersect(a);
        assertEquals(0, s2.size());
        IntStream.range(0, 8).forEach(n -> assertFalse(s2.exists(n)));


        a.add(1);
        b.add(7);
        b.add(8);

        IntegerSet s3 = a.intersect(b);
        assertEquals(0, s3.size());
        IntStream.range(0, 8).forEach(n -> assertFalse(s3.exists(n)));

        IntegerSet s4 = b.intersect(a);
        assertEquals(0, s4.size());
        IntStream.range(0, 8).forEach(n -> assertFalse(s4.exists(n)));


        a.add(4);
        b.add(4);

        IntegerSet s5 = a.intersect(b);
        assertEquals(1, s5.size());
        assertTrue(s5.exists(4));
        Arrays.asList(0, 1, 2, 3, 5, 6, 7, 8).forEach(n -> assertFalse(s5.exists(n)));

        IntegerSet s6 = b.intersect(a);
        assertEquals(1, s6.size());
        assertTrue(s6.exists(4));
        Arrays.asList(0, 1, 2, 3, 5, 6, 7, 8).forEach(n -> assertFalse(s6.exists(n)));


        a.add(0);
        a.add(7);
        b.add(0);
        b.add(2);

        IntegerSet s7 = a.intersect(b);
        assertEquals(3, s7.size());
        assertTrue(s7.exists(0));
        assertTrue(s7.exists(4));
        assertTrue(s7.exists(7));
        Arrays.asList(1, 2, 3, 5, 6, 8).forEach(n -> assertFalse(s7.exists(n)));

        IntegerSet s8 = b.intersect(a);
        assertEquals(3, s8.size());
        assertTrue(s8.exists(0));
        assertTrue(s8.exists(4));
        assertTrue(s8.exists(7));
        Arrays.asList(1, 2, 3, 5, 5, 6, 8).forEach(n -> assertFalse(s8.exists(n)));


        a.remove(0);

        IntegerSet s9 = a.intersect(b);
        assertEquals(2, s9.size());
        assertTrue(s9.exists(4));
        assertTrue(s9.exists(7));
        Arrays.asList(0, 1, 2, 3, 5, 6, 8).forEach(n -> assertFalse(s9.exists(n)));

        IntegerSet s10 = b.intersect(a);
        assertEquals(2, s10.size());
        assertTrue(s10.exists(4));
        assertTrue(s10.exists(7));
        Arrays.asList(0, 1, 2, 3, 5, 5, 6, 8).forEach(n -> assertFalse(s10.exists(n)));
    }

    @Test
    public void testUnion() {
        IntegerSet a = new IntegerSet(6);
        IntegerSet b = new IntegerSet(9);

        IntegerSet s1 = a.union(b);
        assertEquals(0, s1.size());
        IntStream.range(0, 9).forEach(n -> assertFalse(s1.exists(n)));

        IntegerSet s2 = b.union(a);
        assertEquals(0, s2.size());
        IntStream.range(0, 9).forEach(n -> assertFalse(s2.exists(n)));


        a.add(3);

        IntegerSet s3 = a.union(b);
        assertEquals(1, s3.size());
        Arrays.asList(0, 1, 2, 4, 5, 6, 7, 8).forEach(n -> assertFalse(s3.exists(n)));

        IntegerSet s4 = b.union(a);
        assertEquals(1, s4.size());
        Arrays.asList(0, 1, 2, 4, 5, 6, 7, 8).forEach(n -> assertFalse(s4.exists(n)));


        a.add(1);
        b.add(3);
        b.add(8);

        IntegerSet s5 = a.union(b);
        assertEquals(3, s5.size());
        Arrays.asList(0, 2, 4, 5, 6, 7).forEach(n -> assertFalse(s5.exists(n)));

        IntegerSet s6 = b.union(a);
        assertEquals(3, s6.size());
        Arrays.asList(0, 2, 4, 5, 6, 7).forEach(n -> assertFalse(s6.exists(n)));


        a.remove(1);

        IntegerSet s7 = a.union(b);
        assertEquals(2, s7.size());
        Arrays.asList(0, 1, 2, 4, 5, 6, 7).forEach(n -> assertFalse(s7.exists(n)));

        IntegerSet s8 = b.union(a);
        assertEquals(2, s8.size());
        Arrays.asList(0, 1, 2, 4, 5, 6, 7).forEach(n -> assertFalse(s8.exists(n)));
    }

    @Test
    public void testDifference() {
        IntegerSet a = new IntegerSet(8);
        IntegerSet b = new IntegerSet(5);

        IntegerSet s1 = a.difference(b);
        assertEquals(0, s1.size());
        IntStream.range(0, 7).forEach(n -> assertFalse(s1.exists(n)));

        IntegerSet s2 = b.difference(a);
        assertEquals(0, s2.size());
        IntStream.range(0, 7).forEach(n -> assertFalse(s2.exists(n)));

        a.add(2);
        a.add(5);
        b.add(0);
        b.add(2);

        IntegerSet s3 = a.difference(b);
        assertEquals(1, s3.size());
        assertTrue(s3.exists(5));
        Arrays.asList(0, 1, 2, 3, 4, 6).forEach(n -> assertFalse(s3.exists(n)));

        IntegerSet s4 = b.difference(a);
        assertEquals(1, s4.size());
        assertTrue(s4.exists(0));
        Arrays.asList(1, 2, 3, 4, 5, 6, 7).forEach(n -> assertFalse(s4.exists(n)));


        a.add(7);
        a.add(4);
        b.add(3);
        b.add(1);

        IntegerSet s5 = a.difference(b);
        assertEquals(3, s5.size());
        assertTrue(s5.exists(4));
        assertTrue(s5.exists(5));
        assertTrue(s5.exists(7));
        Arrays.asList(0, 1, 2, 3, 6).forEach(n -> assertFalse(s5.exists(n)));

        IntegerSet s6 = b.difference(a);
        assertEquals(3, s6.size());
        assertTrue(s6.exists(0));
        assertTrue(s6.exists(1));
        assertTrue(s6.exists(3));
        Arrays.asList(2, 4, 5, 6, 7).forEach(n -> assertFalse(s6.exists(n)));

        a.remove(5);
        b.add(4);

        IntegerSet s7 = a.difference(b);
        assertEquals(1, s7.size());
        assertTrue(s7.exists(7));
        Arrays.asList(0, 1, 2, 3, 4, 5, 6).forEach(n -> assertFalse(s7.exists(n)));

        IntegerSet s8 = b.difference(b);
        assertEquals(0, s8.size());
        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7).forEach(n -> assertFalse(s8.exists(n)));
    }

    @Test
    public void testSymmetricDifference() {
        IntegerSet a = new IntegerSet(8);
        IntegerSet b = new IntegerSet(9);

        IntegerSet s1 = a.symmetricDifference(b);
        assertEquals(0, s1.size());
        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(n -> assertFalse(s1.exists(n)));

        IntegerSet s2 = b.symmetricDifference(a);
        assertEquals(0, s2.size());
        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(n -> assertFalse(s2.exists(n)));


        a.add(1);
        a.add(3);
        a.add(7);

        IntegerSet s3 = a.symmetricDifference(b);
        assertEquals(3, s3.size());
        assertTrue(s3.exists(1));
        assertTrue(s3.exists(3));
        assertTrue(s3.exists(7));
        Arrays.asList(0, 2, 4, 5, 6, 8).forEach(n -> assertFalse(s3.exists(n)));

        IntegerSet s4 = a.symmetricDifference(a);
        assertEquals(0, s4.size());
        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(n -> assertFalse(s4.exists(n)));


        b.add(5);
        b.add(2);
        b.add(7);
        b.add(8);

        IntegerSet s5 = a.symmetricDifference(b);
        assertEquals(5, s5.size());
        assertTrue(s5.exists(1));
        assertTrue(s5.exists(2));
        assertTrue(s5.exists(3));
        assertTrue(s5.exists(5));
        assertTrue(s5.exists(8));
        Arrays.asList(0, 4, 6, 7).forEach(n -> assertFalse(s5.exists(n)));

        IntegerSet s6 = b.symmetricDifference(a);
        assertEquals(5, s6.size());
        assertTrue(s6.exists(1));
        assertTrue(s6.exists(2));
        assertTrue(s6.exists(3));
        assertTrue(s6.exists(5));
        assertTrue(s6.exists(8));
        Arrays.asList(0, 4, 6, 7).forEach(n -> assertFalse(s6.exists(n)));
    }

    @Test
    public void iterator() {
        IntegerSet set = new IntegerSet(130);

        Iterator<Integer> i1 = set.iterator();
        assertFalse(i1.hasNext());

        Set<Integer> expected = new HashSet<>(Arrays.asList(0, 10, 32, 20, 62, 63, 64, 65, 127, 128, 129));
        for (int n : expected) {
            set.add(n);
        }

        List<Integer> actual = new ArrayList<>();
        for (int n : set) {
            actual.add(n);
        }

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, new HashSet<>(actual));
    }
}
