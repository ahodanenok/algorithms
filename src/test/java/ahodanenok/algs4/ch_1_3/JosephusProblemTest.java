package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class JosephusProblemTest {

    @Test
    public void testWhenNoParticipants() {
        assertTrue(JosephusProblem.determineEliminationOrder(0, 1).isEmpty());
    }

    @Test
    public void testErrorWhenIllegalOffset() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> JosephusProblem.determineEliminationOrder(10, 0));
        assertEquals("Elimination offset must be > 0", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
                () -> JosephusProblem.determineEliminationOrder(10, -1));
        assertEquals("Elimination offset must be > 0", e.getMessage());
    }

    @Test
    public void testErrorWhenIllegalParticipantsCount() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> JosephusProblem.determineEliminationOrder(-1, 1));
        assertEquals("Participants count must be >= 0", e.getMessage());
    }

    @Test
    public void testWhenOneParticipant() {
        assertEquals(Collections.singletonList(0), JosephusProblem.determineEliminationOrder(1, 1));
        assertEquals(Collections.singletonList(0), JosephusProblem.determineEliminationOrder(1, 2));
        assertEquals(Collections.singletonList(0), JosephusProblem.determineEliminationOrder(1, 5));
        assertEquals(Collections.singletonList(0), JosephusProblem.determineEliminationOrder(1, Integer.MAX_VALUE));
    }

    @Test
    public void testWhenTwoParticipants() {
        assertEquals(Arrays.asList(0, 1), JosephusProblem.determineEliminationOrder(2, 1));
        assertEquals(Arrays.asList(1, 0), JosephusProblem.determineEliminationOrder(2, 2));
        assertEquals(Arrays.asList(0, 1), JosephusProblem.determineEliminationOrder(2, 5));
        assertEquals(Arrays.asList(1, 0), JosephusProblem.determineEliminationOrder(2, 10));
    }

    @Test
    public void testWhenOddParticipants() {
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), JosephusProblem.determineEliminationOrder(5, 1));
        assertEquals(Arrays.asList(1, 3, 0, 4, 2), JosephusProblem.determineEliminationOrder(5, 2));
        assertEquals(Arrays.asList(4, 0, 2, 3, 1), JosephusProblem.determineEliminationOrder(5, 5));
        assertEquals(Arrays.asList(4, 1, 2, 0, 3), JosephusProblem.determineEliminationOrder(5, 10));
    }

    @Test
    public void testWhenEvenParticipants() {
        assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7), JosephusProblem.determineEliminationOrder(8, 1));
        assertEquals(Arrays.asList(1, 3, 5, 7, 2, 6, 4, 0), JosephusProblem.determineEliminationOrder(8, 2));
        assertEquals(Arrays.asList(2, 5, 0, 4, 1, 7, 3, 6), JosephusProblem.determineEliminationOrder(8, 3));
        assertEquals(Arrays.asList(3, 0, 7, 2, 1, 6, 5, 4), JosephusProblem.determineEliminationOrder(8, 12));
        assertEquals(Arrays.asList(4, 2, 3, 7, 0, 1, 5, 6), JosephusProblem.determineEliminationOrder(8, 13));
    }
}
