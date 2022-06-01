package com.giobyte8.psalgo.gtci.fast_slow_pointers;

import com.giobyte8.psalgo.gtci.fast_slow_pointers.MiddleOfLinkedList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleOfLinkedListTest {

    @Test
    void findMiddle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 3 should be the middle
        assertEquals(head.next.next, MiddleOfLinkedList.findMiddle(head));
    }

    @Test
    void findMiddle2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // 4 should be the middle
        assertEquals(4, MiddleOfLinkedList.findMiddle(head).value);
    }

    @Test
    void findMiddle3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        // 4 should be the middle
        assertEquals(4, MiddleOfLinkedList.findMiddle(head).value);
    }
}