package com.giobyte8.psalgo.collections;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        List<Integer> list = new LinkedList<>();
        list.add(1);

        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        list.add(2);
        assertEquals(2, list.size());
        assertEquals(2, list.get(1));
    }

    @Test
    void addAtIndex() {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(3);
        list.add(4);
        assertEquals(3, list.size());

        // Add at head
        list.add(0, 0);
        assertEquals(4, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));

        // Add in the middle
        list.add(2, 2);
        assertEquals(5, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));

        // Add at tail
        list.add(list.size(), 5);
        assertEquals(6, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(5, list.get(5));
    }

    @Test
    void iterateElements() {
        List<Integer> digits = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        ArrayPStack<Integer> digitsStack = new ArrayPStack<>();
        for (int i = 9; i >= 0; i--) {
            digitsStack.push(i);
        }

        for (Integer digit : digits) {
            assertEquals(digitsStack.pop(), digit);
        }
    }

    @Test
    void forEachWithIdx() {
        List<Integer> digits = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        AtomicInteger expectedIdx = new AtomicInteger();
        digits.forEachIdx((el, idx) -> {
            assertEquals(expectedIdx.getAndIncrement(), idx);

            // For this list each item should be equals to its idx
            assertEquals(idx, el);
        });
    }
}
