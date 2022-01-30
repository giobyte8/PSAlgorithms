package com.giobyte8.psalgo.dcp;

import com.giobyte8.psalgo.collections.BTreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteBinaryTreeCountNodesTest {

    /**
     * Binary tree:
     *
     *           1
     *          / \
     *         /   \
     *        /     \
     *       2        3
     *      / \    /
     *     /   \  /
     *   4      5
     *  / \    /
     * 8   9  10
     */
    @Test
    void countNodes() {
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

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node1.left = node2;
        node1.right = node3;

        CompleteBinaryTreeCountNodes nodeCounter = new CompleteBinaryTreeCountNodes();
        assertEquals(10, nodeCounter.countNodes(node1));
    }
}