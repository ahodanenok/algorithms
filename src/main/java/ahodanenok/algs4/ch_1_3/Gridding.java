package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Web, exercise 1.3.45
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class Gridding {

    public static void main(String[] args) {
        List<PointsPair> pairs = findPairs(Arrays.asList(
                new Point2D(-1, 3),
                new Point2D(5, 4),
                new Point2D(2, 2),
                new Point2D(2, -3),
                new Point2D(0, 5),
                new Point2D(2, 3),
                new Point2D(2, 4)
        ), 2);

        for (PointsPair p : pairs) {
            System.out.println(p.left + " " + p.right);
        }
    }

    public static class PointsPair {

        public final Point2D left;
        public final Point2D right;

        public PointsPair(Point2D left, Point2D right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int hashCode() {
            return 31 * left.hashCode() + right.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            PointsPair other = (PointsPair) obj;
            return left.equals(other.left) && right.equals(other.right);
        }
    }

    public static List<PointsPair> findPairs(List<Point2D> points, double distance) {
        double xMin = Double.MAX_VALUE;
        double xMax = Double.MIN_VALUE;
        double yMin = Double.MAX_VALUE;
        double yMax = Double.MIN_VALUE;
        for (Point2D p : points) {
            xMin = Math.min(p.x(), xMin);
            xMax = Math.max(p.x(), xMax);
            yMin = Math.min(p.y(), yMin);
            yMax = Math.max(p.y(), yMax);
        }

        double cellWidth = (xMax - xMin) / distance;
        int xCellsCount = (int) Math.floor((xMax - xMin) / cellWidth) + 1;

        double cellHeight = (yMax - yMin) / distance;
        int yCellsCount = (int) Math.floor((yMax - yMin) / cellHeight) + 1;

        @SuppressWarnings("unchecked")
        List<Point2D>[][] cells = new ArrayList[xCellsCount][yCellsCount];

        for (Point2D p : points) {
            int x = (int) Math.floor((p.x() - xMin) / cellWidth);
            int y = (int) Math.floor((p.y() - yMin) / cellHeight);
            if (cells[x][y] == null) {
                cells[x][y] = new ArrayList<>();
            }

            cells[x][y].add(p);
        }

        List<PointsPair> result = new ArrayList<>();
        for (int y = 0; y < yCellsCount; y++) {
            for (int x = 0; x < xCellsCount; x++) {
                List<Point2D> cellPoints = cells[x][y];
                if (cellPoints == null) {
                    continue;
                }

                for (int i = 0; i < cellPoints.size(); i++) {
                    Point2D a = cellPoints.get(i);
                    for (int j = i + 1; j < cellPoints.size(); j++) {
                        Point2D b = cellPoints.get(j);
                        if (a.distanceTo(b) <= distance) {
                            result.add(new PointsPair(a, b));
                        }
                    }
                }

                for (Point2D p : cellPoints) {
                    if (x + 1 < xCellsCount) {
                        collect(p, cells[x + 1][y], distance, result);
                    }

                    if (x + 1 < xCellsCount && y + 1 < yCellsCount) {
                        collect(p, cells[x + 1][y + 1], distance, result);
                    }

                    if (y + 1 < yCellsCount) {
                        collect(p, cells[x][y + 1], distance, result);
                    }

                    if (x - 1 >= 0 && y + 1 < yCellsCount) {
                        collect(p, cells[x - 1][y + 1], distance, result);
                    }
                }
            }
        }

        return result;
    }

    private static void collect(Point2D point, List<Point2D> neighbourCellPoints, double distance, List<PointsPair> result) {
        if (neighbourCellPoints != null) {
            for (Point2D np : neighbourCellPoints) {
                if (point.distanceTo(np) <= distance) {
                    result.add(new PointsPair(point, np));
                }
            }
        }
    }
}
