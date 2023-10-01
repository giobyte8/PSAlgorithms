package com.giobyte8.psalgo.gtci.fast_slow_pointers;

import com.giobyte8.psalgo.collections.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicLinkedList2Test {

    @Test
    void palindromeSingleNode() {
        LinkedList<Integer> list = LinkedList.from(new Integer[]{500});
        assertTrue(PalindromicLinkedList2.palindrome(list.getHead()));
    }

    @Test
    void palindromeTwoNodePositive() {
        LinkedList<Integer> list = LinkedList.from(new Integer[]{500, 500});
        assertTrue(PalindromicLinkedList2.palindrome(list.getHead()));
    }

    @Test
    void palindromeTwoNodeNegative() {
        LinkedList<Integer> list = LinkedList.from(new Integer[]{500, 501});
        assertFalse(PalindromicLinkedList2.palindrome(list.getHead()));
    }

    @Test
    void palindromeEvenNodesCountPositive() {
        LinkedList<Integer> list = LinkedList
                .from(new Integer[]{500, 501, 502, 502, 501, 500});
        assertTrue(PalindromicLinkedList2.palindrome(list.getHead()));
    }


    @Test
    void palindromeEvenNodesCountNegative() {
        LinkedList<Integer> list = LinkedList
                .from(new Integer[]{500, 501, 502, 9, 501, 500});
        assertFalse(PalindromicLinkedList2.palindrome(list.getHead()));
    }

    @Test
    void palindromeOddNodesCountPositive() {
        LinkedList<Integer> list = LinkedList
                .from(new Integer[]{1, 2, 3, 0, 3, 2, 1});
        assertTrue(PalindromicLinkedList2.palindrome(list.getHead()));
    }

    @Test
    void palindromeOddNodesCountNegative() {
        LinkedList<Integer> list = LinkedList
                .from(new Integer[]{1, 2, 3, 4, 5});
        assertFalse(PalindromicLinkedList2.palindrome(list.getHead()));
    }
}