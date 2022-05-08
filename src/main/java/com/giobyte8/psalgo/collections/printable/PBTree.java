package com.giobyte8.psalgo.collections.printable;

import com.giobyte8.psalgo.collections.BTree;
import com.giobyte8.psalgo.collections.BTree.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class PBTree<T> implements PrintableCollection {
    private final Node<T> root;

    public PBTree(BTree<T> tree) {
        root = tree.root();
    }

    public PBTree(Node<T> root) {
        this.root = root;
    }

    @Override
    public String toPrintableString() {
        if (root == null) return "<Empty tree>";

        int height = root.height();
        int width = computePrintableWidth(root);

        Map<Integer, StringBuilder> lineBuilders = new HashMap<>(height);
        for (int i = 0; i <= height; i++) {
            lineBuilders.put(i, new StringBuilder(width));
        }

        toPrintableString(root, lineBuilders, 0, 0, false);

        StringJoiner joiner = new StringJoiner("\n");
        lineBuilders.forEach((l, strBuilder) -> joiner.add(strBuilder));
        return joiner.toString();
    }

    /**
     * The width required in spaces for a node to be printed
     * formula is: left child width + content width + right child width
     *
     * @param node Node which width will be computed
     * @return Total required spaces for this node
     */
    private int computePrintableWidth(Node<T> node) {
        // TODO Use hashmap to cache precomputed node widths

        int width = node.value.toString().length();

        if (node.left != null) {
            width += computePrintableWidth(node.left);
        }

        if (node.right != null) {
            width += computePrintableWidth(node.right);
        }

        if (node.left == null && node.right == null) {
            width += 1;
        }

        return width;
    }

    private void toPrintableString(
            Node<T> node,
            Map<Integer, StringBuilder> lines,
            int level,
            int extraLeftMargin,
            boolean isLeftChild) {
        StringBuilder lineBuilder = lines.get(level);
        lineBuilder.append(" ".repeat(extraLeftMargin));

        if (node.left == null) {
            if (isLeftChild) lineBuilder.append(" ");
        } else {
            addLeftArm(lineBuilder, node);
            toPrintableString(
                    node.left,
                    lines,
                    level + 1,
                    extraLeftMargin,
                    true
            );
        }

        lineBuilder.append(node.value.toString());

        if (node.right == null) {
            if (!isLeftChild) lineBuilder.append(" ");
        } else {
            addRightArm(lineBuilder, node);
            toPrintableString(
                    node.right,
                    lines,
                    level + 1,
                    node.value.toString().length(),
                    false
            );
        }
    }

    /**
     * Adds the characters for the 'arm' placed before
     * the value of each non leave node that connects it
     * with its left child, e.g.
     *
     * <pre>
     *   ┌--29
     *  280
     * </pre>
     *
     * @param lineBuilder Where the characters will be added
     * @param node Tree node which left arm will be added to line builder
     */
    private void addLeftArm(StringBuilder lineBuilder, Node<T> node) {
        if (node.left == null) return;

        int armLeftMargin;

        // Left leaves have a whitespace before its value
        if (node.left.left == null) {
            armLeftMargin = 1;
        }

        // Otherwise, before its content there are as many
        // whitespaces as their right grandchildren width
        else {
            armLeftMargin = computePrintableWidth(node.left.left);
        }

        // Finally, center arm above children content width
        armLeftMargin += Math.floorDiv(node.left.value.toString().length(), 2);

        // Line of '-' until node value
        int armLength = computePrintableWidth(node.left) - armLeftMargin - 1;

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
     * @param node Tree node which left arm will be added to line builder
     */
    private void addRightArm(StringBuilder lineBuilder, Node<T> node) {
        if (node.right == null) return;

        int armRightMargin;

        // Right leaves have a whitespace after its value
        if (node.right.right == null) {
            armRightMargin = 1;
        }

        // Otherwise, after its content there are as many
        // whitespaces as their right grandchildren width
        else {
            armRightMargin = computePrintableWidth(node.right.right);
        }

        // Finally, center arm above children content width
        armRightMargin += Math.floorDiv(node.right.value.toString().length(), 2);

        // Line of '-' from node value until 'hand'
        int armLength = computePrintableWidth(node.right) - armRightMargin - 1;

        String rightArm = "┐";
        lineBuilder
                .append("-".repeat(armLength))
                .append(rightArm)
                .append(" ".repeat(armRightMargin));
    }
}
