package com.giobyte8.psalgo.collections;

public interface Stack<T> {

    void push(T value);

    T pop();

    T peek();

    int size();
}
