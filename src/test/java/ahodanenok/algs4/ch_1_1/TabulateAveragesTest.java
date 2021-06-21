package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class TabulateAveragesTest {

    @Test
    public void testNoLines() throws Exception {
        StringWriter sw = new StringWriter();
        TabulateAverages.tabulate(Collections.emptyIterator(), sw);
        assertEquals("", sw.toString());
    }

    @Test
    public void testEmptyLine() throws Exception {
        StringWriter sw = new StringWriter();
        TabulateAverages.tabulate(Collections.singletonList("  ").iterator(), sw);
        assertEquals("", sw.toString());
    }

    @Test
    public void testRoundedDownIf4() throws Exception {
        StringWriter sw = new StringWriter();
        TabulateAverages.tabulate(Collections.singletonList("test 11 27").iterator(), sw);
        assertEquals(String.format("test 11 27 %.3f%n", 0.407), sw.toString());
    }

    @Test
    public void testRoundedUpIf5() throws Exception {
        StringWriter sw = new StringWriter();
        TabulateAverages.tabulate(Collections.singletonList("test 110 323").iterator(), sw);
        assertEquals(String.format("test 110 323 %.3f%n", 0.341), sw.toString());
    }

    @Test
    public void testRoundedUpIf6() throws Exception {
        StringWriter sw = new StringWriter();
        TabulateAverages.tabulate(Collections.singletonList("test 125 378").iterator(), sw);
        assertEquals(String.format("test 125 378 %.3f%n", 0.331), sw.toString());
    }

    @Test
    public void testMultipleLines() throws Exception {
        StringWriter sw = new StringWriter();
        TabulateAverages.tabulate(Arrays.asList("test 37 82", "abc 1 2").iterator(), sw);
        assertEquals(
            String.format("test 37 82 %.3f%n", 0.451) +
            String.format("abc 1 2 %.3f%n", 0.5),
            sw.toString());
    }

    @Test
    public void testLinesTrimmed() throws Exception {
        StringWriter sw = new StringWriter();
        TabulateAverages.tabulate(Arrays.asList(" a    4   2   ", "   b 6 3   ").iterator(), sw);
        assertEquals(
                String.format("a 4 2 %.3f%n", 2.0) +
                String.format("b 6 3 %.3f%n", 2.0),
                sw.toString());
    }
}
