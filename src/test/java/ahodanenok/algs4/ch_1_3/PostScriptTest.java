package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

public class PostScriptTest {

    @Test
    public void testEmptyExpression() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("");

        assertEquals("", out.toString());
    }

    @Test
    public void testPSTACK() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("1 2 3 pstack");

        String expected =
                "[NUMBER] 3" + System.lineSeparator() +
                "[NUMBER] 2" + System.lineSeparator() +
                "[NUMBER] 1" + System.lineSeparator();

        assertEquals(expected, out.toString());
    }

    @Test
    public void testWhitespaces() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("  1\n 2\t 3 \r pstack   ");

        String expected =
                "[NUMBER] 3" + System.lineSeparator() +
                "[NUMBER] 2" + System.lineSeparator() +
                "[NUMBER] 1" + System.lineSeparator();

        assertEquals(expected, out.toString());
    }

    @Test
    public void testCLEAR() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("1 clear pstack");

        assertEquals("Stack is empty" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testQUIT() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("1 pstack quit ERROR123");

        assertEquals("[NUMBER] 1" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testEXEC() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("{ 1 2 add } exec { 3 5 add } pstack");

        String expected =
                "[FUNCTION] ' 3 5 add '" + System.lineSeparator() +
                "[NUMBER] 3" + System.lineSeparator();

        assertEquals(expected, out.toString());
    }

    @Test
    public void testEXCH() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 5 exch 1 pstack");

        String expected =
                "[NUMBER] 1" + System.lineSeparator() +
                "[NUMBER] 3" + System.lineSeparator() +
                "[NUMBER] 5" + System.lineSeparator();

        assertEquals(expected, out.toString());
    }

    @Test
    public void testADD() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("10 20 add pstack");

        assertEquals("[NUMBER] 30" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testMUL() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 5 mul pstack");

        assertEquals("[NUMBER] 15" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testSUB() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("7 3 sub pstack");

        assertEquals("[NUMBER] 4" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testDIV() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("9 3 div pstack");

        assertEquals("[NUMBER] 3" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testDUP() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("5 dup pstack");

        String expected =
                "[NUMBER] 5" + System.lineSeparator() +
                "[NUMBER] 5" + System.lineSeparator();

        assertEquals(expected, out.toString());
    }

    @Test
    public void testPOP() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("-100 3 pop pstack");

        assertEquals("[NUMBER] -100" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testIF_TRUE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 true { 5 add } if pstack");

        assertEquals("[NUMBER] 8" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testIF_FALSE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 false { 5 add } if pstack");

        assertEquals("[NUMBER] 3" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testIFELSE_TRUE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("7 true { 3 add } { 2 sub } ifelse pstack");

        assertEquals("[NUMBER] 10" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testIFELSE_FALSE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("7 false { 3 add } { 2 sub } ifelse pstack");

        assertEquals("[NUMBER] 5" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testEQ_TRUE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 3 eq pstack");

        assertEquals("[BOOLEAN] true" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testEQ_FALSE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 4 eq pstack");

        assertEquals("[BOOLEAN] false" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testNE_TRUE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 4 ne pstack");

        assertEquals("[BOOLEAN] true" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testNE_FALSE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 3 ne pstack");

        assertEquals("[BOOLEAN] false" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testGT_TRUE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 4 gt pstack");

        assertEquals("[BOOLEAN] true" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testGT_FALSE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("4 3 gt pstack");

        assertEquals("[BOOLEAN] false" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testLT_TRUE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("4 3 lt pstack");

        assertEquals("[BOOLEAN] true" + System.lineSeparator(), out.toString());
    }

    @Test
    public void testLT_FALSE() {
        StringWriter out = new StringWriter();
        PostScript ps = new PostScript();
        ps.setOut(out);
        ps.execute("3 4 lt pstack");

        assertEquals("[BOOLEAN] false" + System.lineSeparator(), out.toString());
    }
}
