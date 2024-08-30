package com.giobyte8.psalgo.collections;

public class BTNode<T> {
    private T value;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }
}
