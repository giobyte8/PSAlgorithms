package com.giobyte8.psalgo.collections;

public interface Queue<T> {

    void add(T element);

    void addAll(T[] elements);

    T poll();

    T peek();

    int size();

    boolean isEmpty();
}
