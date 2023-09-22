package com.giobyte8.psalgo.collections.utils;

import com.giobyte8.psalgo.collections.LinkedList.Node;

import java.util.logging.Logger;

public class LinkedListUtils {
    private static final Logger logger = Logger
            .getLogger(LinkedListUtils.class.getName());

    private LinkedListUtils() {}

    public static <T> Node<T> reverse(Node<T> head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (hasCycle(head)) {
            logger.warning("Provided list has a cycle. Reverse not supported");
            return head;
        }

        Node<T> slow = head;
        Node<T> fast = head.next;

        slow.next = null;
        while (fast != null) {
            Node<T> tmp = fast.next;
            fast.next = slow;

            slow = fast;
            fast = tmp;
        }

        return slow;
    }

    public static boolean hasCycle(Node<?> head) {
        if (head == null) return false;
        if (head.next == null) return false;

        Node<?> fast = head;
        Node<?> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
