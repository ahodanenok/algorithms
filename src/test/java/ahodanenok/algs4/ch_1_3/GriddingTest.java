package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GriddingTest {

    @RepeatedTest(1000)
    public void test() {
        double distance = StdRandom.uniform(0.1, 0.6);
        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < StdRandom.uniform(10, 100); i++) {
            points.add(new Point2D(StdRandom.uniform(-1, 1), StdRandom.uniform(-1, 1)));
        }

        List<Gridding.PointsPair> expected = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (points.get(i).distanceTo(points.get(j)) <= distance) {
                    expected.add(new Gridding.PointsPair(points.get(i), points.get(j)));
                }
            }
        }

        Assertions.assertEquals(new HashSet<>(expected), new HashSet<>(Gridding.findPairs(points, distance)));
    }
}
