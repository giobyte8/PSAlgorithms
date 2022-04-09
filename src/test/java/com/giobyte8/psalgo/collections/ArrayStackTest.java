package com.giobyte8.psalgo.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void stackCapacityRemainsWhileStackNotFull() {
        int initialCapacity = 5;
        ArrayStack<Integer> stack = new ArrayStack<>(initialCapacity);
        assertEquals(0, stack.size(), "Size of empty stack should be 0");

        stack.push(4);
        stack.push(5);
        stack.push(6);

        assertEquals(
                3,
                stack.size(),
                "Size of stack with n elements should be n"
        );
        assertEquals(
                initialCapacity,
                stack.capacity(),
                "Capacity should not grow until initial capacity if full"
        );
    }

    @Test
    void stackCapacityGrowsWhenLessThanDefaultCapacity() {
        int initialCapacity = 5;
        ArrayStack<Integer> stack = new ArrayStack<>(initialCapacity);

        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }

        assertEquals(
                25,
                stack.capacity(),
                "Capacity should had grow by default initial capacity"
        );
    }

    @Test
    void stackCapacityGrowsWhenGreaterThanDefaultCapacity() {
        int initialCapacity = 30;
        ArrayStack<Integer> stack = new ArrayStack<>(initialCapacity);

        for (int i = 0; i < initialCapacity + 1; i++) {
            stack.push(i);
        }

        assertEquals(
                initialCapacity * 1.5,
                stack.capacity(),
                "Capacity should had grow by half its current capacity"
        );
    }

    @Test
    void stackPopOrder() {
        Stack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 9; i >= 0; i--) {
            assertEquals(
                    i,
                    stack.pop(),
                    "pop() method should return elements in LIFO order"
            );
        }

        assertEquals(
                0,
                stack.size(),
                "Stack should be empty after pop all its elements"
        );
    }
}