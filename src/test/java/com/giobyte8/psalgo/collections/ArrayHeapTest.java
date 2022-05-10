package com.giobyte8.psalgo.collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHeapTest {

    @Test
    void add5Elements() {
        ArrayHeap<Integer> intHeap = new ArrayHeap<>(
                Comparator.comparingInt(value -> value)
        );

        intHeap.add(5);
        intHeap.add(3);
        intHeap.add(4);
        intHeap.add(-1);
        intHeap.add(0);
        assertEquals(5, intHeap.size(), "Unexpected heap size");

        Integer[] expectedOrder = new Integer[]{-1, 0, 3, 4, 5};
        assertHeapOrder(intHeap, expectedOrder);
    }

    @Test
    void add1Element() {
        ArrayHeap<Integer> intHeap = new ArrayHeap<>(
                Comparator.comparingInt(value -> value)
        );

        intHeap.add(5);
        assertEquals(1, intHeap.size(), "Unexpected heap size");
        assertEquals(5, intHeap.removeMin(), "Unexpected heap min value");
    }

    @Test
    void add2Elements() {
        ArrayHeap<Integer> intHeap = new ArrayHeap<>(
                Comparator.comparingInt(value -> value)
        );

        intHeap.add(Integer.MIN_VALUE);
        intHeap.add(Integer.MIN_VALUE + 1);

        assertEquals(2, intHeap.size());
        assertEquals(Integer.MIN_VALUE, intHeap.removeMin());
        assertEquals(Integer.MIN_VALUE + 1, intHeap.removeMin());
    }

    @Test
    void remove() {
        ArrayHeap<Integer> intHeap = new ArrayHeap<>(
                Comparator.comparingInt(value -> value)
        );

        intHeap.add(Integer.MAX_VALUE);
        intHeap.add(Integer.MAX_VALUE - 1);
        intHeap.add(Integer.MAX_VALUE - 2);
        assertEquals(3, intHeap.size());

        intHeap.remove(Integer.MAX_VALUE - 1);
        assertEquals(2, intHeap.size());

        Integer[] expectedOrder = new Integer[]{Integer.MAX_VALUE - 2, Integer.MAX_VALUE};
        assertHeapOrder(intHeap, expectedOrder);
    }

    private <T> void assertHeapOrder(ArrayHeap<T> heap, T[] expectedOrder) {
        for (T t : expectedOrder) {
            assertEquals(
                    t,
                    heap.removeMin(),
                    "Unexpected heap element"
            );
        }
    }
}