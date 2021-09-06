package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TuringTapeTest {

    @Test
    public void testMovingEmpty() {
        TuringTape tape = new TuringTape();
        for (int i = 0; i > -100; i--) {
            assertEquals(i, tape.position());
            assertEquals(0, tape.look());
            tape.moveLeft();
        }

        for (int i = -100; i < 100; i++) {
            assertEquals(i, tape.position());
            assertEquals(0, tape.look());
            tape.moveRight();
        }
    }

    @Test
    public void testWriting() {
        TuringTape tape = new TuringTape();
        for (int i = 0; i > -1000; i--) {
            tape.write(1000 + i);
            tape.moveLeft();
        }
        while (tape.position() != 1) {
            tape.moveRight();
        }
        for (int i = 1; i < 1000; i++) {
            tape.write(1000 + i);
            tape.moveRight();
        }

        assertEquals(1000, tape.position());
        assertEquals(0, tape.look());
        tape.moveLeft();
        for (int i = 999; i >= -999; i--) {
            assertEquals(i, tape.position());
            assertEquals(1000 + i, tape.look());
            tape.moveLeft();
        }

        assertEquals(-1000, tape.position());
        assertEquals(0, tape.look());
        tape.moveRight();
        for (int i = -999; i <= 999; i++) {
            assertEquals(i, tape.position());
            assertEquals(1000 + i, tape.look());
            tape.moveRight();
        }

        assertEquals(1000, tape.position());
        assertEquals(0, tape.look());
    }
}
