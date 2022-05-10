package com.giobyte8.psalgo.collections;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayHeap<T> {
    private static final int INITIAL_CAPACITY = 20;
    private T[] heapElements;
    private int size = 0;

    private final Comparator<T> comparator;

    public ArrayHeap(Comparator<T> comparator) {
        this(comparator, INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayHeap(Comparator<T> comparator, int initialCapacity) {
        this.comparator = comparator;
        heapElements = (T[]) new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        if (value == null) throw new NullPointerException(
                "Null values are not supported"
        );

        if (size == heapElements.length) grow();

        heapElements[size++] = value;

        // Move new item to its right position
        int i = size - 1;
        while (i > 0 && comparator.compare(heapElements[i], parent(i)) < 0) {
            swap(i, parentIdx(i));
            i = parentIdx(i);
        }
    }

    public T peek() {
        if (size == 0) return null;
        return heapElements[0];
    }

    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (heapElements[i].equals(value)) {

                // Move item until root
                int idx = i;
                while (idx > 0) {
                    swap(idx, parentIdx(idx));
                    idx = parentIdx(idx);
                }

                // Remove root item
                removeMin();
                break;
            }
        }
    }

    public T removeMin() {
        if (size == 0) return null;
        if (size == 1) {
            size = 0;
            return heapElements[0];
        }

        T min = heapElements[0];
        heapElements[0] = heapElements[size - 1];
        size--;
        heapify(0);

        return min;
    }

    public List<T> levelOrder() {
        List<T> levelOrdered = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            levelOrdered.add(heapElements[i]);
        }

        return levelOrdered;
    }

    /**
     * Increases capacity of container array by half of its current
     * capacity or by INITIAL_CAPACITY if current capacity is less
     * than INITIAL_CAPACITY
     */
    private void grow() {
        int delta = heapElements.length < INITIAL_CAPACITY
                ? INITIAL_CAPACITY
                : heapElements.length / 2;

        heapElements =  Arrays.copyOf(
                heapElements,
                heapElements.length + delta
        );
    }

    private void swap(int pos1, int pos2) {
        T tmp = heapElements[pos1];
        heapElements[pos1] = heapElements[pos2];
        heapElements[pos2] = tmp;
    }

    /**
     * Makes sure element at given idx and all of its children
     * follow the heap required structure
     *
     * @param idx Index where heapify process will start
     */
    private void heapify(int idx) {
        if (leftChild(idx) == null && rightChild(idx) == null)
            return;

        T value = heapElements[idx];

        // has left child only
        if (rightChild(idx) == null) {
            if (comparator.compare(value, leftChild(idx)) > 0) {
                swap(idx, leftChildIdx(idx));
                heapify(leftChildIdx(idx));
            }
        }

        // has right child only
        else if (leftChild(idx) == null) {
            if (comparator.compare(value, rightChild(idx)) > 0) {
                swap(idx, rightChildIdx(idx));
                heapify(rightChildIdx(idx));
            }
        }

        // has both children
        else {
            T min = computeMin(
                    value,
                    computeMin(leftChild(idx), rightChild(idx))
            );

            if (min == leftChild(idx)) {
                swap(idx, leftChildIdx(idx));
                heapify(leftChildIdx(idx));
            }

            else if (min == rightChild(idx)) {
                swap(idx, rightChildIdx(idx));
                heapify(rightChildIdx(idx));
            }

            // Otherwise, item is in right position and there's nothing to do
        }
    }

    private T computeMin(T val1, T val2) {
        if (comparator.compare(val1, val2) < 0) {
            return val1;
        }

        return val2;
    }

    private T parent(int idx) {
        int pIdx = parentIdx(idx);
        if (pIdx == -1) return null;

        return heapElements[pIdx];
    }

    private T leftChild(int idx) {
        int lIdx = leftChildIdx(idx);

        return (lIdx > size - 1)
                ? null
                : heapElements[lIdx];
    }

    private T rightChild(int idx) {
        int rIdx = rightChildIdx(idx);

        return (rIdx > size - 1)
                ? null
                : heapElements[rIdx];
    }

    private int parentIdx(int idx) {
        if (idx == 0) return -1;
        return Math.floorDiv(idx - 1, 2);
    }

    private int leftChildIdx(int idx) {
        return 2 * idx + 1;
    }

    private int rightChildIdx(int idx) {
        return 2 * idx + 2;
    }
}
