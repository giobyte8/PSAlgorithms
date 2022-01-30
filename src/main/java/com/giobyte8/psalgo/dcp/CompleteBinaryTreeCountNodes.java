package com.giobyte8.psalgo.dcp;

import com.giobyte8.psalgo.collections.BTreeNode;

/**
 * Given a complete binary tree, count the number of nodes in faster
 * than O(n) time.
 *
 * Recall that a complete binary tree has every level
 * filled except the last, and the nodes in the last level are filled
 * starting from the left.
 */
public class CompleteBinaryTreeCountNodes {

    static class CountStatus {
        int leavesCount = 0;
        int maxDepthLevel = 0;
        boolean lastLevelLastNodeFound = false;
    }

    public int countNodes(BTreeNode<Integer> root) {
        CountStatus countStatus = new CountStatus();
        countLeaves(root, -1, countStatus);

        int nodesCount = countStatus.leavesCount;
        for (int i = 0; i < countStatus.maxDepthLevel; i++) {
            nodesCount += Math.pow(2, i);
        }

        return nodesCount;
    }

    private void countLeaves(BTreeNode<Integer> root,
                             int previousLevel,
                             CountStatus countStatus) {
        if (countStatus.lastLevelLastNodeFound) return;

        int currentLevel = previousLevel + 1;
        if (currentLevel > countStatus.maxDepthLevel) {
            countStatus.maxDepthLevel = currentLevel;
        }

        if (root.left == null && root.right == null) {
            if (currentLevel < countStatus.maxDepthLevel) {
                countStatus.lastLevelLastNodeFound = true;
            } else {
                countStatus.leavesCount += 1;
            }

            return;
        }

        if (root.left != null) {
            countLeaves(root.left, currentLevel, countStatus);
        }

        if (root.right != null && !countStatus.lastLevelLastNodeFound) {
            countLeaves(root.right, currentLevel, countStatus);
        } else {
            countStatus.lastLevelLastNodeFound = true;
        }
    }

    public int countNodesOfficial(BTreeNode<Integer> root) {
        if (root == null) return 0;

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        } else {
            return countNodesOfficial(root.left) +
                    countNodesOfficial(root.right) +
                    1;
        }
    }

    private int leftHeight(BTreeNode<Integer> root) {
        int height = 0;

        while (root.left != null) {
            root = root.left;
            height += 1;
        }

        return height;
    }

    private int rightHeight(BTreeNode<Integer> root) {
        int height = 0;

        while (root.right != null) {
            root = root.right;
            height += 1;
        }

        return height;
    }
}
