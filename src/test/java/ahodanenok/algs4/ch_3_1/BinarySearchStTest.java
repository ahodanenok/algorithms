package ahodanenok.algs4.ch_3_1;

public class BinarySearchStTest extends StTests {

    @Override
    protected <K extends Comparable<K>, V> ST<K, V> createST(int capacity) {
        return new BinarySearchST<>(capacity);
    }

    @Override
    protected boolean isCapacityBounded() {
        return true;
    }
}
