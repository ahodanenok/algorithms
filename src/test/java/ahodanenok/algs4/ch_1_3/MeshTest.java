package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class MeshTest {

    // Because of the issues with floating-point precision,
    // calculated points could differ from expected values,
    // but should be close enough to them for tests to pass.
    private static final double COMPARING_DELTA = 10e-10;

    @Test
    public void testStartLtEndPositive() {
        Iterator<Double> iterator = new Mesh(1, 2, 0.1).iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1.0, iterator.next(), COMPARING_DELTA);
        assertEquals(1.1, iterator.next(), COMPARING_DELTA);
        assertEquals(1.2, iterator.next(), COMPARING_DELTA);
        assertEquals(1.3, iterator.next(), COMPARING_DELTA);
        assertEquals(1.4, iterator.next(), COMPARING_DELTA);
        assertEquals(1.5, iterator.next(), COMPARING_DELTA);
        assertEquals(1.6, iterator.next(), COMPARING_DELTA);
        assertEquals(1.7, iterator.next(), COMPARING_DELTA);
        assertEquals(1.8, iterator.next(), COMPARING_DELTA);
        assertEquals(1.9, iterator.next(), COMPARING_DELTA);
        assertEquals(2.0, iterator.next(), COMPARING_DELTA);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStartLtEndNegative() {
        Iterator<Double> iterator = new Mesh(-5, -2, 0.15).iterator();
        assertTrue(iterator.hasNext());
        assertEquals(-5.0, iterator.next(), COMPARING_DELTA);
        assertEquals(-4.85, iterator.next(), COMPARING_DELTA);
        assertEquals(-4.7, iterator.next(), COMPARING_DELTA);
        assertEquals(-4.55, iterator.next(), COMPARING_DELTA);
        assertEquals(-4.4, iterator.next(), COMPARING_DELTA);
        assertEquals(-4.25, iterator.next(), COMPARING_DELTA);
        assertEquals(-4.1, iterator.next(), COMPARING_DELTA);
        assertEquals(-3.95, iterator.next(), COMPARING_DELTA);
        assertEquals(-3.8, iterator.next(), COMPARING_DELTA);
        assertEquals(-3.65, iterator.next(), COMPARING_DELTA);
        assertEquals(-3.5, iterator.next(), COMPARING_DELTA);
        assertEquals(-3.35, iterator.next(), COMPARING_DELTA);
        assertEquals(-3.2, iterator.next(), COMPARING_DELTA);
        assertEquals(-3.05, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.9, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.75, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.6, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.45, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.3, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.15, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.0, iterator.next(), COMPARING_DELTA);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStartLtEndMixed() {
        Iterator<Double> iterator = new Mesh(-3, 2, 0.3).iterator();
        assertTrue(iterator.hasNext());
        assertEquals(-3.0, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.7, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.4, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.1, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.8, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.5, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.2, iterator.next(), COMPARING_DELTA);
        assertEquals(-0.9, iterator.next(), COMPARING_DELTA);
        assertEquals(-0.6, iterator.next(), COMPARING_DELTA);
        assertEquals(-0.3, iterator.next(), COMPARING_DELTA);
        assertEquals(0.0, iterator.next(), COMPARING_DELTA);
        assertEquals(0.3, iterator.next(), COMPARING_DELTA);
        assertEquals(0.6, iterator.next(), COMPARING_DELTA);
        assertEquals(0.9, iterator.next(), COMPARING_DELTA);
        assertEquals(1.2, iterator.next(), COMPARING_DELTA);
        assertEquals(1.5, iterator.next(), COMPARING_DELTA);
        assertEquals(1.8, iterator.next(), COMPARING_DELTA);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStartLtEndPositiveInfiniteLoop() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Mesh(1, 2, -0.1).iterator());
        assertEquals("Forever Loop!", e.getMessage());
    }

    @Test
    public void testStartLtEndNegativeInfiniteLoop() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Mesh(-5, -2, -0.15).iterator());
        assertEquals("Forever Loop!", e.getMessage());
    }

    @Test
    public void testStartLtEndMixedInfiniteLoop() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Mesh(-5, -2, -0.15).iterator());
        assertEquals("Forever Loop!", e.getMessage());
    }

    @Test
    public void testDeltaEqualZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Mesh(-3, -2, -0.3));
        assertEquals("Forever Loop!", e.getMessage());
    }

    @Test
    public void testStartEqualEnd() {
        Iterator<Double> iterator = new Mesh(0.3, 0.3, 0.01).iterator();
        assertTrue(iterator.hasNext());
        assertEquals(0.3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStartGtEndPositive() {
        Iterator<Double> iterator = new Mesh(5, 4, -0.1).iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5.0, iterator.next(), COMPARING_DELTA);
        assertEquals(4.9, iterator.next(), COMPARING_DELTA);
        assertEquals(4.8, iterator.next(), COMPARING_DELTA);
        assertEquals(4.7, iterator.next(), COMPARING_DELTA);
        assertEquals(4.6, iterator.next(), COMPARING_DELTA);
        assertEquals(4.5, iterator.next(), COMPARING_DELTA);
        assertEquals(4.4, iterator.next(), COMPARING_DELTA);
        assertEquals(4.3, iterator.next(), COMPARING_DELTA);
        assertEquals(4.2, iterator.next(), COMPARING_DELTA);
        assertEquals(4.1, iterator.next(), COMPARING_DELTA);
        assertEquals(4.0, iterator.next(), COMPARING_DELTA);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStartGtEndNegative() {
        Iterator<Double> iterator = new Mesh(-1, -2.5, -0.2).iterator();
        assertTrue(iterator.hasNext());
        assertEquals(-1.0, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.2, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.4, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.6, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.8, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.0, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.2, iterator.next(), COMPARING_DELTA);
        assertEquals(-2.4, iterator.next(), COMPARING_DELTA);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStartGtEndMixed() {
        Iterator<Double> iterator = new Mesh(1.6, -1.7, -0.5).iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1.6, iterator.next(), COMPARING_DELTA);
        assertEquals(1.1, iterator.next(), COMPARING_DELTA);
        assertEquals(0.6, iterator.next(), COMPARING_DELTA);
        assertEquals(0.1, iterator.next(), COMPARING_DELTA);
        assertEquals(-0.4, iterator.next(), COMPARING_DELTA);
        assertEquals(-0.9, iterator.next(), COMPARING_DELTA);
        assertEquals(-1.4, iterator.next(), COMPARING_DELTA);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStartGtEndPositiveInfiniteLoop() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Mesh(5, 4, 0.1));
        assertEquals("Forever Loop!", e.getMessage());
    }

    @Test
    public void testStartGtEndNegativeInfiniteLoop() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Mesh(-1, -2.5, 0.2));
        assertEquals("Forever Loop!", e.getMessage());
    }

    @Test
    public void testStartGtEndMixedInfiniteLoop() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Mesh(1.6, -1.7, 0.5));
        assertEquals("Forever Loop!", e.getMessage());
    }
}
