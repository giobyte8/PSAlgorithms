package com.giobyte8.psalgo.collections;

public interface Queue<T> {

    void add(T element);

    T poll();

    T peek();
}
