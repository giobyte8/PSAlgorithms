package com.giobyte8.psalgo.collections;

import java.util.Arrays;

/**
 * Stack implementation that uses an internal array
 * to store stack elements.
 *
 * It offers an amortized time for add operations
 * and constant time for pop element operation
 *
 * @param <T> Type of stack elements
 */
public class ArrayStack<T> implements Stack<T> {
    private static final int INITIAL_CAPACITY = 20;

    private T[] stackElements;
    private int top = -1;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        stackElements = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T value) {
        if (top == stackElements.length - 1) grow();
        stackElements[++top] = value;
    }

    @Override
    public T pop() {
        if (top < 0) {
            return null;
        }

        return stackElements[top--];
    }

    @Override
    public int size() {
        return top + 1;
    }

    /**
     * Returns the current capacity of stack.
     * Note that this capacity will be automatically increased
     * under demand
     *
     * @return Current stack capacity
     */
    public int capacity() {
        return stackElements.length;
    }

    /**
     * Increases capacity of container array by half of its current
     * capacity or by INITIAL_CAPACITY if current capacity is less
     * than INITIAL_CAPACITY
     */
    private void grow() {
        int delta = stackElements.length < INITIAL_CAPACITY
            ? INITIAL_CAPACITY
            : stackElements.length / 2;

        stackElements =  Arrays.copyOf(
                stackElements,
                stackElements.length + delta
        );
    }
}
