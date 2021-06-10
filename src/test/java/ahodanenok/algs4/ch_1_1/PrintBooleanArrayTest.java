package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Test;
import java.io.StringWriter;
import static org.junit.jupiter.api.Assertions.*;

public class PrintBooleanArrayTest {

    @Test
    public void testEmptyArray() throws Exception {
        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[0][0], sw);
        assertEquals("", sw.toString());
    }

    @Test
    public void testNoColumns() throws Exception {
        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[10][0], sw);
        assertEquals("", sw.toString());
    }

    @Test
    public void testOneRowAllFalse() throws Exception {
        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[][] {
            { false, false, false, false }
        }, sw);

        String expected =
            "  1 2 3 4" + System.lineSeparator() +
            "1        ";
        assertEquals(expected, sw.toString());
    }

    @Test
    public void testOneRowAllTrue() throws Exception {
        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[][] {
            { true, true, true, true }
        }, sw);

        String expected =
            "  1 2 3 4" + System.lineSeparator() +
            "1 * * * *";
        assertEquals(expected, sw.toString());
    }

    @Test
    public void testOneColumnAllFalse() throws Exception {
        StringWriter sw = new StringWriter();

        boolean[][] array = {
            { false },
            { false },
            { false },
            { false },
            { false }
        };
        PrintBooleanArray.print(array, sw);

        String expected =
            "  1" + System.lineSeparator() +
            "1  " + System.lineSeparator() +
            "2  " + System.lineSeparator() +
            "3  " + System.lineSeparator() +
            "4  " + System.lineSeparator() +
            "5  ";
        assertEquals(expected, sw.toString());
    }

    @Test
    public void testOneColumnAllTrue() throws Exception {
        StringWriter sw = new StringWriter();

        boolean[][] array = {
            { true },
            { true },
            { true },
            { true },
            { true }
        };
        PrintBooleanArray.print(array, sw);

        String expected =
            "  1" + System.lineSeparator() +
            "1 *" + System.lineSeparator() +
            "2 *" + System.lineSeparator() +
            "3 *" + System.lineSeparator() +
            "4 *" + System.lineSeparator() +
            "5 *";
        assertEquals(expected, sw.toString());
    }

    @Test
    public void testGaps() throws Exception {
        StringWriter sw = new StringWriter();

        boolean[][] array = {
            { true },
            { },
            { true, false, true },
            { false, true, true, false },
            { false }
        };
        PrintBooleanArray.print(array, sw);

        String expected =
            "  1 2 3 4" + System.lineSeparator() +
            "1 *      " + System.lineSeparator() +
            "2        " + System.lineSeparator() +
            "3 *   *  " + System.lineSeparator() +
            "4   * *  " + System.lineSeparator() +
            "5        ";
        assertEquals(expected, sw.toString());
    }

    @Test
    public void testNoGaps() throws Exception {
        StringWriter sw = new StringWriter();

        boolean[][] array = {
            { true, true, false, true, true },
            { false, true, false, true, false },
            { true, false, true, false, true },
            { false, false, true, false, false },
        };
        PrintBooleanArray.print(array, sw);

        String expected =
            "  1 2 3 4 5" + System.lineSeparator() +
            "1 * *   * *" + System.lineSeparator() +
            "2   *   *  " + System.lineSeparator() +
            "3 *   *   *" + System.lineSeparator() +
            "4     *    ";
        assertEquals(expected, sw.toString());
    }


    @Test
    public void testRowsColumnWidthTwoDigitsRolling() throws Exception {
        int rowsCount = 9;

        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[rowsCount][1], sw);
        assertEquals(generateExpectedRowsWithSingleFalseColumn(rowsCount), sw.toString());
    }

    @Test
    public void testRowsColumnWidthTwoDigits() throws Exception {
        int rowsCount = 21;

        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[rowsCount][1], sw);
        assertEquals(generateExpectedRowsWithSingleFalseColumn(rowsCount), sw.toString());
    }

    @Test
    public void testRowsColumnWidthThreeDigits() throws Exception {
        int rowsCount = 153;

        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[rowsCount][1], sw);
        assertEquals(generateExpectedRowsWithSingleFalseColumn(rowsCount), sw.toString());
    }

    private String generateExpectedRowsWithSingleFalseColumn(int rowsCount) {
        int width = Integer.toString(rowsCount + 1).length();
        String expected = String.format("%" + width + "s 1%n", " ");
        for (int r = 0; r < rowsCount; r++) {
            expected += String.format("%" + width + "d  ", r + 1);
            if (r < rowsCount - 1) {
                expected += System.lineSeparator();
            }
        }

        return expected;
    }


    @Test
    public void testColumnWidthTwoDigitsRolling() throws Exception {
        int columnsCount = 9;

        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[1][columnsCount], sw);
        assertEquals(generateExpectedColumnWithSingleFalseRow(columnsCount), sw.toString());
    }

    @Test
    public void testColumnWidthTwoDigits() throws Exception {
        int columnsCount = 15;

        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[1][columnsCount], sw);
        assertEquals(generateExpectedColumnWithSingleFalseRow(columnsCount), sw.toString());
    }

    @Test
    public void testColumnWidthThreeDigits() throws Exception {
        int columnsCount = 137;

        StringWriter sw = new StringWriter();
        PrintBooleanArray.print(new boolean[1][columnsCount], sw);
        assertEquals(generateExpectedColumnWithSingleFalseRow(columnsCount), sw.toString());
    }

    private String generateExpectedColumnWithSingleFalseRow(int columnsCount) {
        int width = Integer.toString(columnsCount + 1).length();
        String expected = " ";
        for (int c = 0; c < columnsCount; c++) {
            expected += String.format(" %" + width + "d", c + 1);
        }
        expected += System.lineSeparator();
        expected += "1";
        for (int c = 0; c < columnsCount; c++) {
            expected += String.format(" %" + width + "s", " ");
        }

        return expected;
    }
}
