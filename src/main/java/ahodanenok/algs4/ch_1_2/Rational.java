package ahodanenok.algs4.ch_1_2;

import ahodanenok.algs4.ch_1_1.Euclid;

/**
 * Book, exercise 1.2.16
 */
public class Rational {

    public static final Rational ZERO = new Rational(0, 1);

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);

        System.out.println(new Rational(n, d));
    }

    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be zero");
        }

        // normalize rational number by excluding common factors
        int gcd = Euclid.gcd(numerator, denominator);
        int n = numerator / gcd;
        int d = denominator / gcd;
        if (d < 0) {
            n *= -1;
            d *= -1;
        }

        this.numerator = n;
        this.denominator = d;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational plus(Rational other) {
        CommonDenominator cd = withCommonDenominator(other);
        return new Rational(cd.thisNumerator + cd.otherNumerator, cd.denominator);
    }

    public Rational minus(Rational other) {
        CommonDenominator cd = withCommonDenominator(other);
        return new Rational(cd.thisNumerator - cd.otherNumerator, cd.denominator);
    }

    public Rational times(Rational other) {
        if (numerator == 0 || other.numerator == 0) {
            return ZERO;
        }

        int gcdThis = Euclid.gcd(numerator, other.denominator);
        int gcdOther = Euclid.gcd(other.numerator, denominator);

        int n = (numerator / gcdThis) * (other.numerator / gcdOther);
        int d = (denominator / gcdOther) * (other.denominator / gcdThis);

        return new Rational(n, d);
    }

    public Rational divides(Rational other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Can't divide by zero");
        }

        return times(new Rational(other.denominator, other.numerator));
    }

    public boolean equals(Rational other) {
        if (numerator == 0 && other.numerator == 0) {
            return true;
        }

        CommonDenominator cd = withCommonDenominator(other);
        return cd.thisNumerator == cd.otherNumerator;
    }

    private int lcm(int a, int b) {
        return Math.abs(Math.max(a, b) / Euclid.gcd(a, b)) * Math.abs(Math.min(a, b));
    }

    private CommonDenominator withCommonDenominator(Rational other) {
        int commonDenominator = lcm(denominator, other.denominator);
        int thisNumerator = numerator * (commonDenominator / denominator);
        int otherNumerator = other.numerator * (commonDenominator / other.denominator);

        return new CommonDenominator(thisNumerator, otherNumerator, commonDenominator);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    private static class CommonDenominator {
        final int thisNumerator;
        final int otherNumerator;
        final int denominator;

        public CommonDenominator(int thisNumerator, int bn, int lcm) {
            this.thisNumerator = thisNumerator;
            this.otherNumerator = bn;
            this.denominator = lcm;
        }
    }
}
