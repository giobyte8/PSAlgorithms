package com.giobyte8.psalgo;

import com.giobyte8.psalgo.collections.BTree;
import com.giobyte8.psalgo.collections.printable.PBTree;

public class VisualizeBTrees {

    public static void main(String[] args) {
        recursiveFileSystem();
    }

    private static void recursiveFileSystem() {
        BTree.Node<String> root = new BTree.Node<>("root");
        BTree.Node<String> dir1 = new BTree.Node<>("dir1");
        BTree.Node<String> dir2 = new BTree.Node<>("dir2");
        BTree.Node<String> dir3 = new BTree.Node<>("dir3");
        BTree.Node<String> dir4 = new BTree.Node<>("dir4");
        BTree.Node<String> dir5 = new BTree.Node<>("dir5");
        BTree.Node<String> dir6 = new BTree.Node<>("dir6");
        BTree.Node<String> dir7 = new BTree.Node<>("dir7");

        BTree.Node<String> img1 = new BTree.Node<>("img1");
        BTree.Node<String> img2 = new BTree.Node<>("img2");
        BTree.Node<String> img3 = new BTree.Node<>("img3");
        BTree.Node<String> img4 = new BTree.Node<>("img4");
        BTree.Node<String> img5 = new BTree.Node<>("img5");
        BTree.Node<String> img6 = new BTree.Node<>("img6");
        BTree.Node<String> img7 = new BTree.Node<>("img7");
        BTree.Node<String> img8 = new BTree.Node<>("img8");
        BTree.Node<String> img9 = new BTree.Node<>("img9");
        BTree.Node<String> img10 = new BTree.Node<>("img10");

        root.left = dir1;
        root.right = dir2;

        dir1.left = dir3;
        dir1.right = img4;

        dir2.left = img5;
        dir2.right = dir4;

        dir3.left = dir5;
        dir3.right = dir6;

        dir4.right = dir7;

        dir5.left = img6;

        dir6.left = img7;
        dir6.right = img8;

        dir7.left = img9;
        dir7.right = img10;

        PBTree<String> fSystem = new PBTree<>(root);
        fSystem.print();
    }
}
