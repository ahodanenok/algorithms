package ahodanenok.algs4.ch_3_1;

public class ArrayStTest extends StTests {

    @Override
    protected <K extends Comparable<K>, V> ST<K, V> createST(int capacity) {
        return new ArrayST<>(capacity);
    }

    @Override
    protected boolean isCapacityBounded() {
        return true;
    }
}
