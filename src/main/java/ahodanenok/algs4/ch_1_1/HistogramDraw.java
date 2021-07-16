package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.awt.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Book, exercise 1.1.32
 */
public class HistogramDraw {

    private static final int CANVAS_WIDTH = 1280;
    private static final int CANVAS_HEIGHT = 800;

    private static final Color AXIS_COLOR = Color.BLACK;
    private static final Color BAR_COLOR = Color.ORANGE;

    private static final Font AXIS_FONT = new Font("SansSerif", Font.PLAIN, 12);

    private static final double X_MARGIN_PERCENT = 0.1;
    private static final double Y_MARGIN_PERCENT = 0.1;

    private static final double X_AXIS_TICK_LENGTH_PERCENT = 0.01;
    private static final double Y_AXIS_TICK_LENGTH_PERCENT = 0.01;

    private static final double X_AXIS_LABEL_OFFSET_PERCENT = 0.05;
    private static final double Y_AXIS_LABEL_OFFSET_PERCENT = 0.05;

    public static void main(String[] args) {
        double lo = Double.parseDouble(args[0]);
        double hi = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        NavigableMap<Double, Integer> data = getData(lo, hi, n);
        drawData(data);
    }

    private static NavigableMap<Double, Integer> getData(double lo, double hi, int n) {
        double step = (hi - lo) / n;

        TreeMap<Double, Integer> counts = new TreeMap<>();
        if (step == 0) {
            return counts;
        }

        for (double x = lo; x < hi; x += step) {
            counts.put(x, 0);
        }

        double[] values = StdIn.readAllDoubles();
        for (double v : values) {
            if (v < lo || v > hi) {
                continue;
            }

            Map.Entry<Double, Integer> entry = counts.floorEntry(v);
            counts.put(entry.getKey(), entry.getValue() + 1);
        }

        counts.put(hi, 0);
        return counts;
    }

    private static void drawData(NavigableMap<Double, Integer> data) {
        if (data.isEmpty()) {
            return;
        }

        int yMin = 0;
        int yMax = data.values().stream().max(Integer::compare).get();
        int yLength = yMax - yMin;

        double xMin = data.firstKey();
        double xMax = data.lastKey();
        double xLength = xMax - xMin;

        StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        StdDraw.setYscale(yMin - yLength * Y_MARGIN_PERCENT, yMax + yLength * Y_MARGIN_PERCENT);
        StdDraw.setXscale(xMin - xLength * X_MARGIN_PERCENT, xMax + xLength * X_MARGIN_PERCENT);

        // Y axis
        StdDraw.line(xMin, yMin, xMin, yMax);
        Stream.of(yMin, yMin + yLength / 2, yMax).distinct().forEach(y -> drawYTick(xMin, xMax, y));

        // X axis
        StdDraw.setPenColor(AXIS_COLOR);
        StdDraw.line(xMin, yMin, xMax, yMin);
        Stream.of(xMin, data.floorKey(xMin + xLength * 0.33),  data.ceilingKey(xMin + xLength * 0.66), xMax)
            .distinct().forEach(x -> drawXTick(yMin, yMax, x));

        Iterator<Map.Entry<Double, Integer>> dataIterator = data.entrySet().iterator();
        Map.Entry<Double, Integer> prevBar = dataIterator.next();

        // bars
        while (dataIterator.hasNext()) {
            Map.Entry<Double, Integer> bar = dataIterator.next();

            double halfWidth = (bar.getKey() - prevBar.getKey()) / 2.0;
            double halfHeight = prevBar.getValue() / 2.0;
            StdDraw.setPenColor(BAR_COLOR);
            StdDraw.filledRectangle(prevBar.getKey() + halfWidth, yMin + halfHeight, halfWidth, halfHeight);

            prevBar = bar;
        }
    }

    private static void drawYTick(double xMin, double xMax, int count) {
        double xLength = xMax - xMin;

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(xMin - xLength * Y_AXIS_TICK_LENGTH_PERCENT, count, xMin, count);

        StdDraw.setPenColor(AXIS_COLOR);
        StdDraw.setFont(AXIS_FONT);
        StdDraw.text(xMin - xLength * Y_AXIS_LABEL_OFFSET_PERCENT, count, count + "");
    }

    private static void drawXTick(int yMin, int yMax, double range) {
        int yLength = yMax - yMin;

        StdDraw.setPenColor(AXIS_COLOR);
        StdDraw.line(range, yMin, range, yMin - yLength * X_AXIS_TICK_LENGTH_PERCENT);

        StdDraw.setPenColor(AXIS_COLOR);
        StdDraw.setFont(AXIS_FONT);
        StdDraw.text(range, yMin - yLength * X_AXIS_LABEL_OFFSET_PERCENT, String.format("%.2f", range));
    }
}
