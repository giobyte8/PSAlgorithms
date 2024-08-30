package com.giobyte8.psalgo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JCFTest {

    @Test
    void arrayDeck() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Deque<Integer> deck = new ArrayDeque<>(numbers);

        assertEquals(1, deck.pop());
        assertEquals(2, deck.pop());
        assertEquals(3, deck.pop());
        assertEquals(2, deck.size());
    }

    @Test
    void linkedListWithNulls() {
        List<Integer> numbers = Arrays.asList(1, 2, null, 4, null);
        Queue<Integer> deck = new LinkedList<>(numbers);

        assertEquals(1, deck.poll());
        assertEquals(2, deck.poll());
        assertNull(deck.poll());
        assertEquals(2, deck.size());
    }
}
