package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Book, exercise 1.1.31
 */
public class RandomConnections {

    private static final int MARGIN = 50;

    private static final int CIRCLE_RADIUS = 800;
    private static final double CIRCLE_PEN_RADIUS = 0.01;
    private static final Color CIRCLE_COLOR = Color.LIGHT_GRAY;

    private static final double DOT_PEN_RADIUS = 0.03;
    private static final Color DOT_COLOR = Color.BLUE;

    private static final double LINE_PEN_RADIUS = 0.001;
    private static final Color LINE_COLOR = Color.BLUE;

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double offsetAngle = 2 * Math.PI / n;

        StdDraw.setCanvasSize(CIRCLE_RADIUS + MARGIN * 2, CIRCLE_RADIUS + MARGIN * 2);
        StdDraw.setScale(-CIRCLE_RADIUS - MARGIN * 2, CIRCLE_RADIUS + MARGIN * 2);

        // drawing a circumference
        StdDraw.setPenRadius(CIRCLE_PEN_RADIUS);
        StdDraw.setPenColor(CIRCLE_COLOR);
        StdDraw.circle(0, 0, CIRCLE_RADIUS);

        // generating points of interest
        double a = 0;
        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point2D(CIRCLE_RADIUS * Math.cos(a), CIRCLE_RADIUS * Math.sin(a)));
            a += offsetAngle;
        }

        // drawing points on the circumference
        StdDraw.setPenColor(DOT_COLOR);
        StdDraw.setPenRadius(DOT_PEN_RADIUS);
        for (Point2D point : points) {
            StdDraw.point(point.x(), point.y());
        }

        // drawing random connections between the points
        StdDraw.setPenColor(LINE_COLOR);
        StdDraw.setPenRadius(LINE_PEN_RADIUS);
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (Math.random() < p) {
                    Point2D from = points.get(i);
                    Point2D to = points.get(j);
                    StdDraw.line(from.x(), from.y(), to.x(), to.y());
                }
            }
        }
    }
}
