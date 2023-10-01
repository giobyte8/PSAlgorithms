package com.giobyte8.psalgo.gtci.fast_slow_pointers;

import com.giobyte8.psalgo.collections.LinkedList.Node;
import com.giobyte8.psalgo.collections.utils.LinkedListUtils;

public class PalindromicLinkedList2 {

    private PalindromicLinkedList2() {}

    public static <T> boolean palindrome(Node<T> head) {
        if (head == null) return true;
        if (head.next == null) return true;

        // Find second half of list
        Node<T> fast = head;
        Node<T> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half
        Node<T> secondHalfHead = fast == null ? slow : slow.next;
        Node<T> reversedHead = LinkedListUtils.reverse(secondHalfHead);

        // Verify if linked list is palindrome
        boolean isPalindrome = true;
        fast = reversedHead;
        slow = head;

        while (fast != null && isPalindrome) {
            isPalindrome = slow.value.equals(fast.value);

            fast = fast.next;
            slow = slow.next;
        }

        // Restore reversed second half
        LinkedListUtils.reverse(reversedHead);
        return isPalindrome;
    }
}
