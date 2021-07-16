package ahodanenok.algs4.ch_1_1;

import java.util.Random;

/**
 * Book, exercise 1.1.11
 */
public class PrintBooleanArray {

    public static void main(String[] args) throws Exception {
        int rowsCount = Integer.parseInt(args[0]);
        int maxColumnsCount = Integer.parseInt(args[1]);
        print(generateArray(rowsCount, maxColumnsCount), System.out);
    }

    static boolean[][] generateArray(int rowsCount, int maxColumnsCount) {
        Random random = new Random();

        boolean[][] array = new boolean[rowsCount][];
        for (int r = 0; r < rowsCount; r++) {
            // +1 because bound in nextInt is exclusive and we want to include it
            int columnsCount = random.nextInt(maxColumnsCount + 1);
            boolean[] columns = new boolean[columnsCount];
            for (int c = 0; c < columnsCount; c++) {
                columns[c] = random.nextBoolean();
            }

            array[r] = columns;
        }

        return array;
    }

    static void print(boolean[][] array, Appendable out) throws Exception {
        if (array.length == 0) {
            return;
        }

        int rowsCount = array.length;
        int columnsCount = 0;
        for (boolean[] row : array) {
            columnsCount = Math.max(row.length, columnsCount);
        }

        if (columnsCount == 0) {
            return;
        }

        // adding one because columns/rows will be printed starting from 1 (ie. 0 -> "1", 1 -> "2", etc)
        // and it can increase width when count for example is 9
        int columnWidth = Integer.toString(columnsCount + 1).length();
        int rowsColumnWidth = Integer.toString(rowsCount + 1).length();

        // print header
        out.append(pad(" ", rowsColumnWidth));
        for (int c = 0; c < columnsCount; c++) {
            out.append(" ");
            out.append(pad(Integer.toString(c + 1), columnWidth));
        }
        out.append(System.lineSeparator());

        // print rows
        int lastRowIndex = rowsCount - 1;
        for (int r = 0; r < rowsCount; r++) {
            out.append(pad(Integer.toString(r + 1), rowsColumnWidth));

            boolean[] row = array[r];
            for (int c = 0; c < columnsCount; c++) {
                // if there are not enough items in a row - treat remaining as false
                boolean b = c < row.length && row[c];
                String symbol = b ? "*" : " ";

                out.append(" ");
                out.append(pad(symbol, columnWidth));
            }

            if (r < lastRowIndex) {
                out.append(System.lineSeparator());
            }
        }
    }

    static String pad(String s, int length) {
        String result = s;
        while (result.length() < length) {
            result = " " + result;
        }

        return result;
    }
}
