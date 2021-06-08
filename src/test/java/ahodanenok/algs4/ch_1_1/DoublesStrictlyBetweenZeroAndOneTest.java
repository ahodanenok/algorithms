package ahodanenok.algs4.ch_1_1;

import java.io.StringWriter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublesStrictlyBetweenZeroAndOneTest {

    @Test
    public void testInRange_All() throws Exception {
        StringWriter sw = new StringWriter();
        DoublesStrictlyBetweenZeroAndOne.impl(new String[] { "0.01", "0.99" }, sw);
        assertEquals("true", sw.toString());
    }

    @Test
    public void testNotInRange_Zero() throws Exception {
        StringWriter sw = new StringWriter();
        DoublesStrictlyBetweenZeroAndOne.impl(new String[] { "0", "0.0" }, sw);
        assertEquals("false", sw.toString());
    }

    @Test
    public void testNotInRange_One() throws Exception {
        StringWriter sw = new StringWriter();
        DoublesStrictlyBetweenZeroAndOne.impl(new String[] { "1.0", "1" }, sw);
        assertEquals("false", sw.toString());
    }

    @Test
    public void testNotInRange_All() throws Exception {
        StringWriter sw = new StringWriter();
        DoublesStrictlyBetweenZeroAndOne.impl(new String[] { "-0.1", "1.5" }, sw);
        assertEquals("false", sw.toString());
    }

    @Test
    public void testNotInRange_X() throws Exception {
        StringWriter sw = new StringWriter();
        DoublesStrictlyBetweenZeroAndOne.impl(new String[] { "2", "0.5" }, sw);
        assertEquals("false", sw.toString());
    }

    @Test
    public void testNotInRange_Y() throws Exception {
        StringWriter sw = new StringWriter();
        DoublesStrictlyBetweenZeroAndOne.impl(new String[] { "0.3", "10" }, sw);
        assertEquals("false", sw.toString());
    }
}
