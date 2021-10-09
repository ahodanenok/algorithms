package ahodanenok.algs4.ch_1_4;

public class Pair {

    public static Pair INFINITY = new Pair(0, Double.POSITIVE_INFINITY);

    final double a;
    final double b;

    public Pair(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double distance() {
        return Math.abs(a - b);
    }

    @Override
    // hashCode not needed yet
    public boolean equals(Object obj) {
        Pair other = (Pair) obj;
        return a == other.a && b == other.b;
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}
