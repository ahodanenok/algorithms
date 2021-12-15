package ahodanenok.algs4.ch_3_1;

public class OrderedSequentialSearchStTest extends StTests {

    @Override
    protected <K extends Comparable<K>, V> ST<K, V> createST(int capacity) {
        return new OrderedSequentialSearchST<>();
    }

    @Override
    protected boolean isCapacityBounded() {
        return false;
    }
}
