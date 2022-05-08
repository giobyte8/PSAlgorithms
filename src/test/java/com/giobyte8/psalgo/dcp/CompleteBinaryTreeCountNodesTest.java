package com.giobyte8.psalgo.dcp;

import com.giobyte8.psalgo.collections.BTree;
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
        BTree.Node<Integer> node1 = new BTree.Node<>(1);
        BTree.Node<Integer> node2 = new BTree.Node<>(2);
        BTree.Node<Integer> node3 = new BTree.Node<>(3);
        BTree.Node<Integer> node4 = new BTree.Node<>(4);
        BTree.Node<Integer> node5 = new BTree.Node<>(5);
        BTree.Node<Integer> node6 = new BTree.Node<>(6);
        BTree.Node<Integer> node7 = new BTree.Node<>(7);
        BTree.Node<Integer> node8 = new BTree.Node<>(8);
        BTree.Node<Integer> node9 = new BTree.Node<>(9);
        BTree.Node<Integer> node10 = new BTree.Node<>(10);

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