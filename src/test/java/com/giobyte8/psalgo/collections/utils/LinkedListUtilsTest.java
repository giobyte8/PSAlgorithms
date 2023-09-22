package com.giobyte8.psalgo.collections.utils;

import com.giobyte8.psalgo.collections.LinkedList;
import com.giobyte8.psalgo.collections.LinkedList.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListUtilsTest {

    @Test
    void hasCycleSingleNode() {
        Node<Integer> node = new Node<>(5);
        assertFalse(LinkedListUtils.hasCycle(node));
    }

    @Test
    void hasCycleSingleNodeCircular() {
        Node<Integer> node = new Node<>(5);
        node.next = node;

        assertTrue(LinkedListUtils.hasCycle(node));
    }

    @Test
    void hasCycleMultiNode() {
        LinkedList<Integer> list = LinkedList.from(new Integer[]{5, 6});
        assertFalse(LinkedListUtils.hasCycle(list.getHead()));

        list = LinkedList.from(new Integer[]{5, 6, 7});
        assertFalse(LinkedListUtils.hasCycle(list.getHead()));
    }

    @Test
    void hasCycleMultiNodeCircular() {
        LinkedList<Integer> list = LinkedList.from(new Integer[]{5, 6, 7, 8, 9, 10});

        // Create cycle in list
        Node<Integer> seven = list.getHead().next.next;
        Node<Integer> ten = seven.next.next.next;
        ten.next = seven;

        assertTrue(LinkedListUtils.hasCycle(list.getHead()));
    }

    @Test
    void reverseSingleNode() {
        LinkedList<Integer> list = LinkedList.from(new Integer[]{1});
        Node<Integer> reversedHead = LinkedListUtils.reverse(list.getHead());

        assertEquals(reversedHead, list.getHead());
    }

    @Test
    void reverseMultiNode() {
        LinkedList<Integer> list = LinkedList.from(new Integer[]{1, 2, 3, 4});

        Node<Integer> iterator = LinkedListUtils.reverse(list.getHead());
        assertEquals(4, iterator.value);

        iterator = iterator.next;
        assertEquals(3, iterator.value);

        iterator = iterator.next;
        assertEquals(2, iterator.value);

        iterator = iterator.next;
        assertEquals(1, iterator.value);

        iterator = iterator.next;
        assertNull(iterator);
    }
}