package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClosestPointsTest {

    @Order(1)
    @ParameterizedTest
    @MethodSource("getPoints")
    public void testDistance(double distance, Point2D[] points) {
        assertEquals(distance, ClosestPoints.distance(points));
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("getPoints")
    public void testBruteForceDistance(double distance, Point2D[] points) {
        assertEquals(distance, ClosestPoints.bruteForceDistance(points));
    }

    @Test
    @Order(3)
    public void testRandomPoints(TestReporter reporter) {
        Point2D[] points;
        for (int i = 0; i < 100_000; i++) {
            points = new Point2D[StdRandom.uniform(1, 100)];
            for (int j = 0; j < points.length; j++) {
                points[j] = new Point2D(
                        StdRandom.uniform(-points.length, points.length),
                        StdRandom.uniform(-points.length, points.length));
            }

            // using more simple algorithm (brute force version) as a reference implementation
            // to check divide-and-conquer implementation
            double d1 = ClosestPoints.bruteForceDistance(Arrays.copyOf(points, points.length));
            double d2 = ClosestPoints.distance(Arrays.copyOf(points, points.length));
            if (d1 != d2) {
                reporter.publishEntry(i + ".points=", Arrays.toString(points) + "\n");
            }

            Assertions.assertEquals(d1, d2);
        }
    }

    public static Stream<Arguments> getPoints() {
        return Stream.of(
            Arguments.of(0, new Point2D[0]),
            Arguments.of(0, new Point2D[] {
                new Point2D(1, 1)
            }),
            Arguments.of(5, new Point2D[] {
                new Point2D(3, 3),
                new Point2D(6, 7)
            }),
            Arguments.of(5, new Point2D[] {
                new Point2D(5, 6),
                new Point2D(8, 10),
                new Point2D(10, 18)
            }),
            Arguments.of(5, new Point2D[] {
                new Point2D(5, 6),
                new Point2D(10, 18),
                new Point2D(8, 10)
            }),
            Arguments.of(5, new Point2D[] {
                new Point2D(10, 18),
                new Point2D(5, 6),
                new Point2D(8, 10)
            }),
            Arguments.of(1.4142135623730951, new Point2D[] {
                new Point2D(-2, 2),
                new Point2D(-2, 0),
                new Point2D(0, 0),
                new Point2D(1, 1),
                new Point2D(3, 3),
                new Point2D(5, 2),
                new Point2D(4, 0)
            }),
            Arguments.of(1.118033988749895, new Point2D[] {
                new Point2D(4, 2),
                new Point2D(2, -1),
                new Point2D(-1, 3),
                new Point2D(4, -0.5),
                new Point2D(1, 1),
                new Point2D(-1, -1),
                new Point2D(3, 3),
                new Point2D(2, 0.5)
            }));
    }
}
