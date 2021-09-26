package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Book, exercise 1.4.3
 */
public class DoublingTest {

    public static void main(String[] args) {
        int doublingCount = 30;
        int inputSize = 1;

        StdDraw.setCanvasSize(1000, 800);

        List<Integer> sizes = new ArrayList<>();
        sizes.add(0);

        List<Long> times = new ArrayList<>();
        times.add(0L);

        long prevTime = 0;
        for (int n = 0; n < doublingCount; n++) {
            long time = execute(inputSize);

            double ratio = prevTime > 0 ? (double) time / prevTime : 1;
            System.out.printf("%5d %5d %.1f%n", inputSize, time, ratio);

            sizes.add(inputSize);
            times.add(time);
            drawPlot(sizes, times);

            inputSize *= 2;
            prevTime = time;
        }
    }

    private static long execute(int inputSize) {
        int[] numbers = new int[inputSize];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = StdRandom.uniform(-100, 100);
        }

        long t = System.currentTimeMillis();
        ThreeSum.count(numbers);
        return System.currentTimeMillis() - t;
    }

    private static void drawPlot(List<Integer> sizes, List<Long> times) {
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        for (int size : sizes) {
            xMin = Math.min(size, xMin);
            xMax = Math.max(size, xMax);
        }

        long yMin = Integer.MAX_VALUE;
        long yMax = Integer.MIN_VALUE;
        for (long time : times) {
            yMin = Math.min(time, yMin);
            yMax = Math.max(time, yMax);
        }

        double xPad = (xMax - xMin) * 0.1;
        double xEnd = xMax != xMin ? xMax : xMin + 1;
        StdDraw.setXscale(xMin - xPad, xEnd + xPad);

        double yPad = (yMax - yMin) * 0.1;
        double yEnd = yMax != yMin ? yMax : yMin + 1;
        StdDraw.setYscale(yMin - yPad, yEnd + yPad);

        StdDraw.clear();
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(0, 0, xMax, 0);
        StdDraw.line(0, 0, 0, yMax);

        int sizePrev = 0;
        long timePrev = 0;
        StdDraw.setPenColor(Color.RED);
        for (int i = 0; i < sizes.size(); i++) {
            int sizeCurr = sizes.get(i);
            long timeCurr = times.get(i);

            StdDraw.setPenRadius(0.002);
            StdDraw.line(sizePrev, timePrev, sizeCurr, timeCurr);

            StdDraw.setPenRadius(0.01);
            StdDraw.point(sizeCurr, timeCurr);

            sizePrev = sizeCurr;
            timePrev = timeCurr;
        }
    }
}
