package com.giobyte8.psalgo.encora;

import com.giobyte8.psalgo.collections.BTreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Take a binary tree as input and create a double linked list for
 * each level of the three.
 *
 * An input like this:
 *     ┌-------1-------┐
 *   ┌--2---┐       ┌---3---┐
 *  ┌4┐    ┌5┐     ┌6┐     ┌7┐
 *  8 9   10 11   12 13   14 15
 *
 * Will generate four linked lists like:
 * 0: [1]
 * 1: [2, 3]
 * 2: [4, 5, 6, 7]
 * 3: [8, 9, 10, 11, 12, 13, 14, 15]
 */
public class BTreeToDLLists {

    public void toDLLists(BTreeNode<Integer> root) {
        int treeHeight = root.height();
        Map<Integer, LinkedList<Integer>> lists = new HashMap<>(treeHeight);

        for (int i = 0; i <= treeHeight; i++) {
            lists.put(i, new LinkedList<>());
        }

        toDLLists(root, 0, lists);

        lists.forEach((level, levelNodes) -> System.out.printf(
                "%d: %s%n",
                level,
                levelNodes
        ));
    }

    private void toDLLists(BTreeNode<Integer> node,
                           int level,
                           Map<Integer, LinkedList<Integer>> listsMap) {
        LinkedList<Integer> levelList = listsMap.get(level);

        if (node.left != null) {
            toDLLists(node.left, level + 1, listsMap);
        }

        levelList.add(node.value);

        if (node.right != null) {
            toDLLists(node.right, level + 1, listsMap);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
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
        BTreeNode<Integer> node11 = new BTreeNode<>(11);
        BTreeNode<Integer> node12 = new BTreeNode<>(12);
        BTreeNode<Integer> node13 = new BTreeNode<>(13);
        BTreeNode<Integer> node14 = new BTreeNode<>(14);
        BTreeNode<Integer> node15 = new BTreeNode<>(15);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;
        node5.right = node11;

        node6.left = node12;
        node6.right = node13;

        node7.left = node14;
        node7.right = node15;

        node1.print();
        System.out.println();
        BTreeToDLLists toDLListsConverter = new BTreeToDLLists();
        toDLListsConverter.toDLLists(node1);
    }
}
