package com.giobyte8.psalgo.collections;

public interface List<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    int size();
}
