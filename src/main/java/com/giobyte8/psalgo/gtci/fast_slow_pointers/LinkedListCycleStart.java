package com.giobyte8.psalgo.gtci.fast_slow_pointers;

import java.util.HashSet;

/**
 * Given the head of a Singly LinkedList that contains a cycle, write a
 * function to find the starting node of the cycle.
 *
 * Example 1
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 ↴
 *                  ↑ <- --- --- --- ↲
 * Output: 3
 *
 * Example 2
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 ↴
 *                       ↑ <- -- --- ↲
 * Output: 4
 */
public class LinkedListCycleStart {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode findCycleStart(ListNode head) {
        int cycleLength = findCycleLength(head);
        if (cycleLength == -1) return null;

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        // Advance pointer1 as many nodes as the length of cycle
        for (int i = 0; i < cycleLength; i++) {
            pointer1 = pointer1.next;
        }

        // Advance both pointers until they meet
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    private static int findCycleLength(ListNode head) {
        if (head.next == null) return -1;

        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null) return -1;

            fast = fast.next.next;
            slow = slow.next;
        }

        // slow and fast have meet
        int counter = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            counter++;
        }

        return counter;
    }
}
