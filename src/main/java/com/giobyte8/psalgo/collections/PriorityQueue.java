package com.giobyte8.psalgo.collections;

import java.util.Comparator;

public class PriorityQueue<T> implements Queue<T> {
    private final ArrayHeap<T> heap;

    public PriorityQueue(Comparator<T> comparator) {
        this.heap = new ArrayHeap<>(comparator);
    }

    public PriorityQueue(Comparator<T> comparator, int initialCapacity) {
        this.heap = new ArrayHeap<>(comparator, initialCapacity);
    }

    @Override
    public void add(T element) {
        heap.add(element);
    }

    @Override
    public T poll() {
        return heap.removeMin();
    }

    @Override
    public T peek() {
        return heap.peek();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
