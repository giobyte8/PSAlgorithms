package com.giobyte8.psalgo.gtci.fast_slow_pointers;

import com.giobyte8.psalgo.gtci.fast_slow_pointers.PalindromicLinkedList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicLinkedListTest {

    @Test
    void nonPalindrome() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        assertFalse(PalindromicLinkedList.isPalindrome(head));
    }

    @Test
    void singleElement() {
        ListNode head = new ListNode(1);

        assertTrue(PalindromicLinkedList.isPalindrome(head));
    }

    @Test
    void twoElements() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        assertFalse(PalindromicLinkedList.isPalindrome(head));
    }

    @Test
    void palindromeSymmetric() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        assertTrue(PalindromicLinkedList.isPalindrome(head));
    }

    @Test
    void palindromeAsymmetric() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        assertTrue(PalindromicLinkedList.isPalindrome(head));
    }

    void assertOrderKept(ListNode originalHead, ListNode head) {
        while (originalHead != null) {
            assertEquals(originalHead, head);

            originalHead = originalHead.next;
            head = head.next;
        }
    }

}