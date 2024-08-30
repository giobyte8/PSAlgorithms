package com.giobyte8.psalgo.collections.algorithms;

import com.giobyte8.psalgo.collections.BTNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BTreeDFSTest {

    @Test
    void preorder() {
        BTNode<String> alice = new BTNode<>("Alice");
        BTNode<String> bruno = new BTNode<>("Bruno");
        BTNode<String> carl = new BTNode<>("Carl");
        BTNode<String> diana = new BTNode<>("Diana");
        BTNode<String> edward = new BTNode<>("Edward");
        BTNode<String> frank = new BTNode<>("Frank");
        BTNode<String> gerard = new BTNode<>("Gerard");

        // Left branch
        diana.setLeft(bruno);
        bruno.setLeft(alice);
        bruno.setRight(carl);

        // Right branch
        diana.setRight(frank);
        frank.setLeft(edward);
        frank.setRight(gerard);

        List<String> preorder = BTreeDFS.preorder(diana);
        assertEquals(
                Arrays.asList(
                        "Diana", "Bruno", "Alice", "Carl",
                        "Frank", "Edward", "Gerard"),
                preorder
        );
    }
}