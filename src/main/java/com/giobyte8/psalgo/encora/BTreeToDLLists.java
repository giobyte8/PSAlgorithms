package com.giobyte8.psalgo.encora;

import com.giobyte8.psalgo.collections.BTree;

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

    public void toDLLists(BTree.Node<Integer> root) {
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

    private void toDLLists(BTree.Node<Integer> node,
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

    public static void main(String[] args) {
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
        BTree.Node<Integer> node11 = new BTree.Node<>(11);
        BTree.Node<Integer> node12 = new BTree.Node<>(12);
        BTree.Node<Integer> node13 = new BTree.Node<>(13);
        BTree.Node<Integer> node14 = new BTree.Node<>(14);
        BTree.Node<Integer> node15 = new BTree.Node<>(15);

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

        BTreeToDLLists toDLListsConverter = new BTreeToDLLists();
        toDLListsConverter.toDLLists(node1);
    }
}
