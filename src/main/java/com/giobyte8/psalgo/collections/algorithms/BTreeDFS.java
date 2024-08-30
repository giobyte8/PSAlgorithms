package com.giobyte8.psalgo.collections.algorithms;

import com.giobyte8.psalgo.collections.BTNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTreeDFS {

    public static <T> List<T> preorder(BTNode<T> root) {
        Deque<T> traversal = new ArrayDeque<>();
        preorder(root, traversal);

        return new ArrayList<>(traversal);
    }

    private static <T> void preorder(BTNode<T> node, Deque<T> traversal) {
        if (node == null) return;

        traversal.offer(node.getValue());
        preorder(node.getLeft(), traversal);
        preorder(node.getRight(), traversal);
    }
}
