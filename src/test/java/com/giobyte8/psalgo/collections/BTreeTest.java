package com.giobyte8.psalgo.collections;

import com.giobyte8.psalgo.collections.BTree.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {

    @Test
    void heightPerfectTree() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        BTree<Integer> tree = new BTree<>(root);

        int expectedHeight = 2;
        assertEquals(expectedHeight, tree.height(), "Unexpected tree height");
    }

    @Test
    void heightDegenerateTree() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        root.left = node2;
        node2.left = node3;
        node3.right = node4;

        BTree<Integer> tree = new BTree<>(root);
        int expectedHeight = 3;
        assertEquals(expectedHeight, root.height(), "Unexpected tree height");
    }

    @Test
    void heightSingleNodeTree() {
        Node<Integer> root = new Node<>(1);
        BTree<Integer> tree = new BTree<>(root);

        assertEquals(0, tree.height(), "Unexpected tree height");
    }

    @Test
    void inorderPerfectTree() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        BTree<Integer> tree = new BTree<>(node1);
        int[] expectedOrder = new int[]{ 4, 2, 5, 1, 6, 3, 7 };

        assertInOrder(
                expectedOrder,
                tree
        );
    }

    @Test
    void inorderCompleteTree() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        Node<Integer> node9 = new Node<>(9);
        Node<Integer> node10 = new Node<>(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;

        BTree<Integer> tree = new BTree<>(node1);
        int[] expectedOrder = new int[]{ 8, 4, 9, 2, 10, 5, 1, 6, 3, 7 };
        assertInOrder(
                expectedOrder,
                tree
        );
    }

    @Test
    void inorderDegenerateTree() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);

        node1.left = node2;
        node2.left = node3;
        node3.right = node4;
        node4.right = node5;
        node5.left = node6;
        node6.right = node7;

        BTree<Integer> tree = new BTree<>(node1);
        int[] expectedOrder = new int[]{ 3, 4, 6, 7, 5, 2, 1 };
        assertInOrder(
                expectedOrder,
                tree
        );
    }

    @Test
    void toPerfectBTreeCompleteTree() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        Node<Integer> node9 = new Node<>(9);
        Node<Integer> node10 = new Node<>(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;

        BTree<Integer> tree = new BTree<>(node1);
        int fillerValue = 0;

        BTree<Integer> perfectBTree = tree.toPerfectBTree(fillerValue);
        int[] expectedPerfectInorder = new int[]{
                8, 4, 9, 2, 10, 5, 0, 1, 0, 6, 0, 3, 0, 7, 0
        };

        assertInOrder(expectedPerfectInorder, perfectBTree);
    }

    @Test
    void toPerfectBTreePerfectTree() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node1.left = node2;
        node1.right = node3;

        BTree<Integer> tree = new BTree<>(node1);
        BTree<Integer> perfectBTree = tree.toPerfectBTree(0);
        int[] expectedPerfectInorder = new int[]{ 2, 1, 3 };

        assertInOrder(expectedPerfectInorder, perfectBTree);
    }

    @Test
    void toPerfectBTreeDegenerateTree() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node1.left = node2;
        node2.right = node3;

        int fillerValue = 0;
        BTree<Integer> tree = new BTree<>(node1);
        BTree<Integer> perfectBTree = tree.toPerfectBTree(fillerValue);
        int[] expectedPerfectInorder = new int[]{
                fillerValue, 2, 3, 1, fillerValue, fillerValue, fillerValue
        };

        assertInOrder(expectedPerfectInorder, perfectBTree);
    }

    private void assertInOrder(
            int[] expectedOrder,
            BTree<Integer> tree) {
        Queue<Integer> inorder = tree.inorder();
        Arrays.stream(expectedOrder).forEach(expectedValue -> {
            Integer inorderValue = inorder.poll();

            assertNotNull(
                    inorderValue,
                    "Inorder queue does not include all expected nodes"
            );
            assertEquals(
                    expectedValue,
                    inorderValue,
                    "Unexpected node for inorder traversal"
            );
        });
    }
}