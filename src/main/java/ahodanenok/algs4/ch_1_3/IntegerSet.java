package ahodanenok.algs4.ch_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Web, exercise 1.3.19
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class IntegerSet implements Iterable<Integer> {

    // a block is represented by a long (which is 64 bits), so the number of bits
    // required to navigate in it (express offset) is log2(64) = 6
    private static final int BLOCK_OFFSET_BIT_COUNT = 6;
    // a mask to extract from a number its bit index within a block
    private static final int BLOCK_OFFSET_MASK = (1 << BLOCK_OFFSET_BIT_COUNT) - 1;
    private static final int MAX_BLOCK_OFFSET = BLOCK_OFFSET_MASK;

    private static int blockIndex(int n) {
        // divide n by 2 `BLOCK_OFFSET_BIT_COUNT` times
        return n >> BLOCK_OFFSET_BIT_COUNT;
    }

    private static long bitMask(int n) {
        // by applying the offset mask we get a number indicating bit index within a block
        return 1L << (n & BLOCK_OFFSET_MASK);
    }


    // using a bitmap to store numbers in the set
    private long[] blocks;
    private int size;

    public IntegerSet(int to) {
        init(blockIndex(to) + 1);
    }

    private IntegerSet() { }

    private void init(int blocksCount) {
        this.blocks = new long[blocksCount];
    }

    public boolean add(int n) {
        int blockIdx = blockIndex(n);
        if (blockIdx >= blocks.length) {
            throw new IllegalArgumentException("Number is too big for this set");
        }

        long bitMask = bitMask(n);

        // check if the number has been already added
        if ((blocks[blockIdx] & bitMask) != 0) {
            return false;
        }

        blocks[blockIdx] |= bitMask;
        size++;

        return true;
    }

    public boolean remove(int n) {
        int blockIdx = blockIndex(n);
        if (blockIdx >= blocks.length) {
            return false;
        }

        long bitMask = bitMask(n);

        // nothing to remove if the number is not present
        if ((blocks[blockIdx] & bitMask) == 0) {
            return false;
        }

        // invert bit mask to remove only particular bit and leave others the same
        blocks[blockIdx] &= ~bitMask;
        size--;

        return true;
    }

    public boolean exists(int n) {
        int blockIdx = blockIndex(n);
        if (blockIdx >= blocks.length) {
            return false;
        }

        long bitMask = bitMask(n);

        return (blocks[blockIdx] & bitMask )!= 0;
    }

    public int size() {
        return size;
    }

    public IntegerSet intersect(IntegerSet other) {
        int blocksCount = Math.min(blocks.length, other.blocks.length);

        IntegerSet newSet = new IntegerSet();
        newSet.init(blocksCount);

        for (int i = 0; i < blocksCount; i++) {
            newSet.blocks[i] = blocks[i] & other.blocks[i];
            newSet.size += Long.bitCount(newSet.blocks[i]);
        }

        return newSet;
    }

    public IntegerSet difference(IntegerSet other) {
        IntegerSet newSet = new IntegerSet();
        newSet.init(blocks.length);

        for (int i = 0; i < blocks.length; i++) {
            long a = blocks[i];
            long b = i < other.blocks.length ? other.blocks[i] : 0;
            newSet.blocks[i] = a & ~b;
            newSet.size += Long.bitCount(newSet.blocks[i]);
        }

        return newSet;
    }

    public IntegerSet symmetricDifference(IntegerSet other) {
        int blocksCount = Math.max(blocks.length, other.blocks.length);

        IntegerSet newSet = new IntegerSet();
        newSet.init(blocksCount);

        for (int i = 0; i < blocksCount; i++) {
            long a = i < blocks.length ? blocks[i] : 0;
            long b = i < other.blocks.length ? other.blocks[i] : 0;
            newSet.blocks[i] = (a | b) & ~(a & b); // a bit of magic :)
            newSet.size += Long.bitCount(newSet.blocks[i]);
        }

        return newSet;
    }

    public IntegerSet union(IntegerSet other) {
        int blocksCount = Math.max(blocks.length, other.blocks.length);

        IntegerSet newSet = new IntegerSet();
        newSet.init(blocksCount);

        for (int i = 0; i < blocksCount; i++) {
            long a = i < blocks.length ? blocks[i] : 0;
            long b = i < other.blocks.length ? other.blocks[i] : 0;
            newSet.blocks[i] = a | b;
            newSet.size = Long.bitCount(newSet.blocks[i]);
        }

        return newSet;
    }

    public boolean isSubsetOf(IntegerSet other) {
        int blocksCount = Math.max(blocks.length, other.blocks.length);
        for (int i = 0; i < blocksCount; i++) {
            long a = i < blocks.length ? blocks[i] : 0;
            long b = i < other.blocks.length ? other.blocks[i] : 0;
            if ((a & b) != a) {
                return false;
            }
        }

        return true;
    }

    public boolean isSupersetFor(IntegerSet other) {
       return other.isSubsetOf(this);
    }

    public boolean isDisjointFrom(IntegerSet other) {
        int blocksCount = Math.min(blocks.length, other.blocks.length);
        for (int i = 0; i < blocksCount; i++) {
            if ((blocks[i] & other.blocks[i]) != 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int blockIdx = -1;
            long block = 0;

            @Override
            public boolean hasNext() {
                advanceToTheNextBlock();
                return blockIdx < blocks.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no more");
                }

                int offset = Long.numberOfTrailingZeros(block);
                int n = (blockIdx << BLOCK_OFFSET_BIT_COUNT) | offset;
                // flip number's bit to 0 in the block to go to the next number on the next call
                block &= ~(1L << offset);

                return n;
            }

            private void advanceToTheNextBlock() {
                if (block != 0) {
                    return;
                }

                do {
                    blockIdx++;
                } while (blockIdx < blocks.length && blocks[blockIdx] == 0);

                if (blockIdx < blocks.length) {
                    block = blocks[blockIdx];
                }
            }
        };
    }
}
