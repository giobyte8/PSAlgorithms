package com.giobyte8.psalgo.self_proposed;

import com.giobyte8.psalgo.collections.LinkedList;

public class ReverseSinglyLinkedList {

    public static class LNode {
        int value;
        LNode next;

        public LNode(int value) {
            this.value = value;
        }
    }

    public static LNode reverse(LNode head) {
        LNode pointer = head;
        LNode previous = null;

        while (pointer != null) {
            LNode tmp = pointer.next;

            pointer.next = previous;
            previous = pointer;
            pointer = tmp;
        }

        return previous != null ? previous : head;
    }
}
