package ahodanenok.algs4.ch_1_4;

public class StaticSETofInts extends edu.princeton.cs.algs4.StaticSETofInts {

    public StaticSETofInts(int[] keys) {
        super(keys);
    }

    /**
     * Book, exercise 1.4.11
     */
    public int howMany(int n) {
        // numbers are distinct :)
        return rank(n) != -1 ? 1 : 0;
    }
}
