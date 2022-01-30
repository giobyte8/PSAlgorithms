package com.giobyte8.psalgo.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BTreeNodeTest {

    @Test
    void heightPerfectTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);
        BTreeNode<Integer> node4 = new BTreeNode<>(4);
        BTreeNode<Integer> node5 = new BTreeNode<>(5);
        BTreeNode<Integer> node6 = new BTreeNode<>(6);
        BTreeNode<Integer> node7 = new BTreeNode<>(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        assertEquals(2, node1.height(), "Unexpected tree height");
    }

    @Test
    void heightDegenerateTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);
        BTreeNode<Integer> node4 = new BTreeNode<>(4);

        node1.left = node2;
        node2.left = node3;
        node3.right = node4;

        assertEquals(3, node1.height(), "Unexpected tree height");
    }

    @Test
    void heightSingleNodeTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        assertEquals(0, node1.height(), "Unexpected tree height");
    }

    @Test
    void inorderPerfectTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);
        BTreeNode<Integer> node4 = new BTreeNode<>(4);
        BTreeNode<Integer> node5 = new BTreeNode<>(5);
        BTreeNode<Integer> node6 = new BTreeNode<>(6);
        BTreeNode<Integer> node7 = new BTreeNode<>(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Queue<BTreeNode<Integer>> inorderNodes = node1.inorder();
        int[] expectedOrder = new int[]{ 4, 2, 5, 1, 6, 3, 7 };
        assertInOrder(
                expectedOrder,
                inorderNodes
        );
    }

    @Test
    void inorderCompleteTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);
        BTreeNode<Integer> node4 = new BTreeNode<>(4);
        BTreeNode<Integer> node5 = new BTreeNode<>(5);
        BTreeNode<Integer> node6 = new BTreeNode<>(6);
        BTreeNode<Integer> node7 = new BTreeNode<>(7);
        BTreeNode<Integer> node8 = new BTreeNode<>(8);
        BTreeNode<Integer> node9 = new BTreeNode<>(9);
        BTreeNode<Integer> node10 = new BTreeNode<>(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;

        Queue<BTreeNode<Integer>> inorderNodes = node1.inorder();
        int[] expectedOrder = new int[]{ 8, 4, 9, 2, 10, 5, 1, 6, 3, 7 };
        assertInOrder(
                expectedOrder,
                inorderNodes
        );
    }

    @Test
    void inorderDegenerateTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);
        BTreeNode<Integer> node4 = new BTreeNode<>(4);
        BTreeNode<Integer> node5 = new BTreeNode<>(5);
        BTreeNode<Integer> node6 = new BTreeNode<>(6);
        BTreeNode<Integer> node7 = new BTreeNode<>(7);

        node1.left = node2;
        node2.left = node3;
        node3.right = node4;
        node4.right = node5;
        node5.left = node6;
        node6.right = node7;

        Queue<BTreeNode<Integer>> inorderNodes = node1.inorder();
        int[] expectedOrder = new int[]{ 3, 4, 6, 7, 5, 2, 1 };
        assertInOrder(
                expectedOrder,
                inorderNodes
        );
    }

    @Test
    void toPerfectBTreeCompleteTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);
        BTreeNode<Integer> node4 = new BTreeNode<>(4);
        BTreeNode<Integer> node5 = new BTreeNode<>(5);
        BTreeNode<Integer> node6 = new BTreeNode<>(6);
        BTreeNode<Integer> node7 = new BTreeNode<>(7);
        BTreeNode<Integer> node8 = new BTreeNode<>(8);
        BTreeNode<Integer> node9 = new BTreeNode<>(9);
        BTreeNode<Integer> node10 = new BTreeNode<>(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;

        int fillerValue = 0;
        BTreeNode<Integer> perfectTreeRoot = node1.toPerfectBTree(fillerValue);
        int[] expectedPerfectInorder = new int[]{
                8, 4, 9, 2, 10, 5, 0, 1, 0, 6, 0, 3, 0, 7, 0
        };

        assertInOrder(expectedPerfectInorder, perfectTreeRoot.inorder());
    }

    @Test
    void toPerfectBTreePerfectTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);

        node1.left = node2;
        node1.right = node3;

        BTreeNode<Integer> perfectTreeRoot = node1.toPerfectBTree(0);
        int[] expectedPerfectInorder = new int[]{ 2, 1, 3 };

        assertInOrder(expectedPerfectInorder, perfectTreeRoot.inorder());
    }

    @Test
    void toPerfectBTreeDegenerateTree() {
        BTreeNode<Integer> node1 = new BTreeNode<>(1);
        BTreeNode<Integer> node2 = new BTreeNode<>(2);
        BTreeNode<Integer> node3 = new BTreeNode<>(3);

        node1.left = node2;
        node2.right = node3;

        int fillerValue = 0;
        BTreeNode<Integer> perfectTreeRoot = node1.toPerfectBTree(fillerValue);
        int[] expectedPerfectInorder = new int[]{
                fillerValue, 2, 3, 1, fillerValue, fillerValue, fillerValue
        };

        assertInOrder(expectedPerfectInorder, perfectTreeRoot.inorder());
    }

    private void assertInOrder(int[] expectedOrder,
                               Queue<BTreeNode<Integer>> inorderNodes) {
        Arrays.stream(expectedOrder).forEach(expectedValue -> {
            BTreeNode<Integer> inorderNode = inorderNodes.poll();

            assertNotNull(
                    inorderNode,
                    "Inorder queue does not include all expected nodes"
            );
            assertEquals(
                    expectedValue,
                    inorderNode.value,
                    "Unexpected node for inorder traversal"
            );
        });
    }
}