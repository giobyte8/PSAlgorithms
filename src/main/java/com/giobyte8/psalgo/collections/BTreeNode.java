package com.giobyte8.psalgo.collections;


import java.util.LinkedList;
import java.util.Queue;

public class BTreeNode<T> {

    public BTreeNode<T> left;
    public BTreeNode<T> right;

    public T value;

    public BTreeNode(T value) {
        this.value = value;
    }

    public BTreeNode(
            T value,
            BTreeNode<T> left,
            BTreeNode<T> right
    ) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int height() {
        int leftHeight = this.left != null
                ? this.left.height() + 1
                : 0;

        int rightHeight = this.right != null
                ? this.right.height() + 1
                : 0;

        return Math.max(leftHeight, rightHeight);
    }

    public Queue<BTreeNode<T>> inorder() {
        Queue<BTreeNode<T>> inorderNodes = new LinkedList<>();
        this.inorder(inorderNodes);

        return inorderNodes;
    }

    private void inorder(Queue<BTreeNode<T>> inorderNodes) {
        if (left != null) {
            left.inorder(inorderNodes);
        }

        inorderNodes.add(this);

        if (right != null) {
            right.inorder(inorderNodes);
        }
    }

    /**
     * Takes this node as root of tree and convert it into a perfect binary
     * tree of same height, gaps in tree will be filled with given
     * <code>fillerValue</code> in generated perfect tree.
     *
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
     * @return root of perfect tree
     */
    public BTreeNode<T> toPerfectBTree(T fillerValue) {
        return this.toPerfectBTree(this, this.height(), fillerValue);
    }

    /**
     * Takes a binary tree and convert it into a perfect binary tree
     * of given height, gaps in original tree will be filled with given
     * <code>fillerValue</code> in perfect tree.
     *
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
     * @param root Source binary tree root
     * @param height Height of desired perfect tree
     * @return root of perfect tree
     */
    private BTreeNode<T> toPerfectBTree(
            BTreeNode<T> root,
            int height,
            T fillerValue
    ) {
        BTreeNode<T> perfectTreeNode = new BTreeNode<>(
                root != null
                        ? root.value
                        : fillerValue
        );

        if (height > 0) {
            perfectTreeNode.left = toPerfectBTree(
                    root != null ? root.left : null,
                    height - 1,
                    fillerValue
            );

            perfectTreeNode.right = toPerfectBTree(
                    root != null ? root.right : null,
                    height - 1,
                    fillerValue
            );
        }

        return perfectTreeNode;
    }
}
