package com.giobyte8.psalgo.self_proposed;

import com.giobyte8.psalgo.self_proposed.ReverseSinglyLinkedList.LNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseSinglyLinkedListTest {

    @Test
    void reverseDigits() {
        LNode head = new LNode(1);
        head.next = new LNode(2);
        head.next.next = new LNode(3);
        head.next.next.next = new LNode(4);
        head.next.next.next.next = new LNode(5);

        // Verify list natural order
        LNode pointer = head;
        for (int i = 1; i <= 5; i++, pointer = pointer.next) {
            assertEquals(i, pointer.value);
        }

        head = ReverseSinglyLinkedList.reverse(head);

        // Verify list is now in reversed order
        pointer = head;
        for (int i = 5; i >= 1; i--, pointer = pointer.next) {
            assertEquals(i, pointer.value);
        }
    }
}