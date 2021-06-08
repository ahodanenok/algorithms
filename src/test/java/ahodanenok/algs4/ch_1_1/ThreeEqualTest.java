package ahodanenok.algs4.ch_1_1;

import java.io.StringWriter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ThreeEqualTest {

    public void testEqual_All() throws Exception {
        StringWriter sw = new StringWriter();
        ThreeEqual.impl(new String[] { "5", "5", "5" }, sw);
        assertEquals("equal", sw.toString());
    }

    public void testDifferent_All() throws Exception {
        StringWriter sw = new StringWriter();
        ThreeEqual.impl(new String[] { "1", "2", "3" }, sw);
        assertEquals("not equal", sw.toString());
    }

    public void testDifferent_A() throws Exception {
        StringWriter sw = new StringWriter();
        ThreeEqual.impl(new String[] { "2", "4", "4" }, sw);
        assertEquals("not equal", sw.toString());
    }

    public void testDifferent_B() throws Exception {
        StringWriter sw = new StringWriter();
        ThreeEqual.impl(new String[] { "7", "5", "7" }, sw);
        assertEquals("not equal", sw.toString());
    }

    public void testDifferent_C() throws Exception {
        StringWriter sw = new StringWriter();
        ThreeEqual.impl(new String[] { "9", "9", "0" }, sw);
        assertEquals("not equal", sw.toString());
    }
}
