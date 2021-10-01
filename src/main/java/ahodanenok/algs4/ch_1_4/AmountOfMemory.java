package ahodanenok.algs4.ch_1_4;

import ahodanenok.algs4.ch_1_3.FixedCapacityStackOfStrings;
import edu.princeton.cs.algs4.*;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * Book, exercise 1.4.13
 */
public class AmountOfMemory {

    public static void main(String[] args) {
        System.out.println(VM.current().details());

        // a) edu.princeton.cs.algs4.Accumulator
        //
        // estimate:
        //   16 (object overhead)
        // +  4 (field `n` of type int)
        // +  8 (field `sum` of type double)
        // +  8 (field `mu` of type double)
        // +  4 (padding)
        // = 40 bytes
        //
        // jol gives 32 bytes
        System.out.println(ClassLayout.parseClass(Accumulator.class).toPrintable());

        // b) ahodanenok.algs4.ch_1_2.Transaction
        //
        // estimate:
        //   16 (object overhead)
        // +  8 (reference to java.lang.String)
        // +  8 (reference to type edu.princeton.cs.algs4.Date)
        // +  8 (field of type double)
        // = 40 bytes
        //
        // jol gives 32 bytes
        System.out.println(ClassLayout.parseClass(Transaction.class).toPrintable());

        // c) ahodanenok.algs4.ch_1_3.FixedCapacityStackOfStrings
        //
        // estimate:
        //   16 (object overhead)
        // +  8 (reference to java.lang.String array)
        // +  4 (field of type int)
        // +  4 (padding)
        // = 32 bytes
        //
        // jol gives 24 bytes
        System.out.println(ClassLayout.parseClass(FixedCapacityStackOfStrings.class).toPrintable());

        // d) edu.princeton.cs.algs4.Point2D
        //
        // estimate:
        //   16 (object overhead)
        // +  8 (field x of type double)
        // +  8 (field y of type double)
        // = 32 bytes
        //
        // jol gives 32 bytes
        System.out.println(ClassLayout.parseClass(Point2D.class).toPrintable());

        // e) edu.princeton.cs.algs4.Interval1D
        //
        // estimate:
        //   16 (object overhead)
        // +  8 (field min of type double)
        // +  8 (field max of type double)
        // = 32 bytes
        //
        // jol gives 32 bytes
        System.out.println(ClassLayout.parseClass(Interval1D.class).toPrintable());

        // f) edu.princeton.cs.algs4.Interval2D
        //
        // estimate:
        //   16 (object overhead)
        // +  8 (reference x to edu.princeton.cs.algs4.Interval1D)
        // +  8 (reference y to edu.princeton.cs.algs4.Interval1D)
        // = 32 bytes
        //
        // jol gives 24 bytes
        System.out.println(ClassLayout.parseClass(Interval2D.class).toPrintable());

        // g) java.lang.Double
        //
        // estimate:
        //   16 (object overhead)
        // +  8 (field value of type double)
        // = 24 bytes
        //
        // jol gives 24 bytes
        System.out.println(ClassLayout.parseClass(Double.class).toPrintable());
    }
}
