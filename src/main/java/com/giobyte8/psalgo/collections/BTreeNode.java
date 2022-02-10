package com.giobyte8.psalgo.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringJoiner;

public class BTreeNode<T> {

    public BTreeNode<T> left;
    public BTreeNode<T> right;

    public T value;

    // Shortcut & cache for value string repr
    private final String strVal;
    private int printableWidth;

    public BTreeNode(T value) {
        this.value = value;
        this.strVal = value.toString();
    }

    public BTreeNode(
            T value,
            BTreeNode<T> left,
            BTreeNode<T> right
    ) {
        this(value);
        this.left = left;
        this.right = right;
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

    public void print() {
        System.out.println(toPrintableString());
    }

    public String toPrintableString() {
        int height = height();
        int width = computePrintableWidth();

        Map<Integer, StringBuilder> lineBuilders = new HashMap<>(height);
        for (int i = 0; i <= height; i++) {
            lineBuilders.put(i, new StringBuilder(width));
        }

        toPrintableString(lineBuilders, 0, 0, false);

        StringJoiner joiner = new StringJoiner("\n");
        lineBuilders.forEach((l, strBuilder) -> joiner.add(strBuilder));
        return joiner.toString();
    }

    private void toPrintableString(Map<Integer, StringBuilder> lines,
                                   int level,
                                   int extraLeftMargin,
                                   boolean isLeftChild) {
        StringBuilder lineBuilder = lines.get(level);
        lineBuilder.append(" ".repeat(extraLeftMargin));

        if (left == null) {
            if (isLeftChild) lineBuilder.append(" ");
        } else {
            addLeftArm(lineBuilder);
            left.toPrintableString(
                    lines,
                    level + 1,
                    extraLeftMargin,
                    true
            );
        }

        lineBuilder.append(strVal);

        if (right == null) {
            if (!isLeftChild) lineBuilder.append(" ");
        } else {
            addRightArm(lineBuilder);
            right.toPrintableString(
                    lines,
                    level + 1, strVal.length(),
                    false
            );
        }
    }

    /**
     * Adds the characters for the 'arm' to goes before
     * the value of each non leave node that connects it
     * with its left child, e.g.
     *
     * <pre>
     *   ┌--29
     *  280
     * </pre>
     *
     * @param lineBuilder Where the characters will be added
     */
    private void addLeftArm(StringBuilder lineBuilder) {
        if (left == null) return;

        int armLeftMargin;

        // Left leaves have a whitespace before its value
        if (left.left == null) {
            armLeftMargin = 1;
        }

        // Otherwise, before its content there are as many
        // whitespaces as their right grandchildren width
        else {
            armLeftMargin = left.left.printableWidth;
        }

        // Finally, center arm above children content width
        armLeftMargin += Math.floorDiv(left.strVal.length(), 2);

        // Line of '-' until node value
        int armLength = left.printableWidth - armLeftMargin - 1;

        String leftArm = "┌";
        lineBuilder
                .append(" ".repeat(armLeftMargin))
                .append(leftArm)
                .append("-".repeat(armLength));
    }

    /**
     * Adds the characters for the 'arm' to goes after
     * the value of each non leave node that connects it
     * with its right child, e.g.
     *
     * <pre>
     * 29--┐
     *    280
     * </pre>
     *
     * @param lineBuilder Where the characters will be added
     */
    private void addRightArm(StringBuilder lineBuilder) {
        if (right == null) return;

        int armRightMargin;

        // Right leaves have a whitespace after its value
        if (right.right == null) {
            armRightMargin = 1;
        }

        // Otherwise, after its content there are as many
        // whitespaces as their right grandchildren width
        else {
            armRightMargin = right.right.printableWidth;
        }

        // Finally, center arm above children content width
        armRightMargin += Math.floorDiv(right.strVal.length(), 2);

        // Line of '-' from node value until 'hand'
        int armLength = right.printableWidth - armRightMargin - 1;

        String rightArm = "┐";
        lineBuilder
                .append("-".repeat(armLength))
                .append(rightArm)
                .append(" ".repeat(armRightMargin));
    }

    /**
     * The width required in spaces for a node to be printed
     * formula is: left child width + content width + right child width
     *
     * @return Total required spaces for this node
     */
    private int computePrintableWidth() {
        printableWidth = strVal.length();

        if (left != null) {
            printableWidth += left.computePrintableWidth();
        }

        if (right != null) {
            printableWidth += right.computePrintableWidth();
        }

        if (left == null && right == null) {
            printableWidth += 1;
        }

        return printableWidth;
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
