package com.giobyte8.psalgo.gtci.fast_slow_pointers;

public class PalindromicLinkedList {

    public static class ListNode {
        int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode reversedHead = reverse(middle);

        ListNode lIterator = head;
        ListNode rIterator = reversedHead;

        boolean palindromeCheck = true;
        while (lIterator != middle) {
            if (lIterator.value != rIterator.value) {
                palindromeCheck = false;
                break;
            }

            lIterator = lIterator.next;
            rIterator = rIterator.next;
        }

        ListNode unReversedHead = reverse(reversedHead);
        return palindromeCheck;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode previous = null;

        while (head != null) {
            ListNode currentNode = head;
            head = head.next;

            currentNode.next = previous;
            previous = currentNode;
        }

        return previous;
    }
}
