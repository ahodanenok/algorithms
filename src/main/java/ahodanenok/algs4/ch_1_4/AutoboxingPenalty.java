package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.37
 */
public class AutoboxingPenalty {

    public static void main(String[] args) {
        DoublingTestClient doublingTest = new DoublingTestClient();
        doublingTest.setTrialsPerInputSize(10);
        doublingTest.addAlgorithm(new DoublingTestClient.Algorithm() {
            @Override
            public String getName() {
                return "primitives";
            }

            @Override
            public long execute(int n) {
                FixedCapacityStackInts stack = new FixedCapacityStackInts(n);
                long t = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    stack.push(i);
                }
                for (int i = 0; i < n; i++) {
                    stack.pop();
                }

                return System.currentTimeMillis() - t;
            }
        });
        doublingTest.addAlgorithm(new DoublingTestClient.Algorithm() {
            @Override
            public String getName() {
                return "autoboxing";
            }

            @Override
            public long execute(int n) {
                FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(n);
                long t = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    stack.push(i);
                }
                for (int i = 0; i < n; i++) {
                    stack.pop();
                }

                return System.currentTimeMillis() - t;
            }
        });
        doublingTest.run();
    }

    public static class FixedCapacityStack<T> {

        private final T[] items;
        private int size = 0;

        @SuppressWarnings("unchecked") // items will contain only T instances
        public FixedCapacityStack(int capacity) {
            this.items = (T[]) new Object[capacity];
        }

        public void push(T item) {
            items[size] = item;
            size++;
        }

        public T pop() {
            T item = items[--size];
            items[size] = null;
            return item;
        }
    }

    public static class FixedCapacityStackInts {

        private final int[] items;
        private int size;

        public FixedCapacityStackInts(int capacity) {
            this.items = new int[capacity];
        }

        public void push(int item) {
            items[size] = item;
            size++;
        }

        public int pop() {
            return items[--size];
        }
    }
}
