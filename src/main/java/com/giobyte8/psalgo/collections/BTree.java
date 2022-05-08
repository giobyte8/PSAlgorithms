package com.giobyte8.psalgo.collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO Replace java.util.Queue by custom queue implementations
 *
 * @param <T>
 */
public record BTree<T>(com.giobyte8.psalgo.collections.BTree.Node<T> root) {

    public int height() {
        return this.root.height();
    }

    public Queue<T> inorder() {
        Queue<T> inorderValues = new LinkedList<>();
        root.inorder(inorderValues);

        return inorderValues;
    }

    /**
     * Creates a perfect binary tree of same height, based on this tree,
     * gaps in tree will be filled with given <code>fillerValue</code>
     * in generated tree.
     * <p>
     * Note: Original tree structure will not be modified
     * <p>
     * Example given:
     * <pre>
     * An input tree like:
     *        a
     *      /   \
     *    b       c
     *   /
     *  d
     *
     * Will produce an output perfect tree like:
     *        a
     *      /   \
     *    b       c
     *   / \     / \
     *  d   #   #   #
     *
     *  * In above example '#' is used as filler value
     * </pre>
     *
     * @return Perfect binary tree
     */
    public BTree<T> toPerfectBTree(T fillerValue) {
        Node<T> perfectTreeRoot = toPerfectBTreeNode(
                root,
                height(),
                fillerValue
        );

        return new BTree<>(perfectTreeRoot);
    }

    private Node<T> toPerfectBTreeNode(
            Node<T> node,
            int height,
            T fillerValue) {
        Node<T> perfectNode = new Node<>(
                node != null ? node.value : fillerValue
        );

        if (height > 0) {
            perfectNode.left = toPerfectBTreeNode(
                    node != null ? node.left : null,
                    height - 1,
                    fillerValue
            );

            perfectNode.right = toPerfectBTreeNode(
                    node != null ? node.right : null,
                    height - 1,
                    fillerValue
            );
        }

        return perfectNode;
    }

    public static class Node<T> {
        public Node<T> left;
        public Node<T> right;

        public T value;

        public Node(T value) {
            this.value = value;
        }

        public int height() {
            int leftHeight = left != null
                    ? left.height() + 1
                    : 0;

            int rightHeight = right != null
                    ? right.height() + 1
                    : 0;

            return Math.max(leftHeight, rightHeight);
        }

        public void inorder(Queue<T> inorderValues) {
            if (left != null) {
                left.inorder(inorderValues);
            }

            inorderValues.add(this.value);

            if (right != null) {
                right.inorder(inorderValues);
            }
        }
    }
}
