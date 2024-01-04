package com.giobyte8.psalgo.collections;

import java.util.Collection;

public interface Queue<T> {

    void add(T element);

    void addAll(Collection<? extends T> elements);

    T poll();

    T peek();

    int size();

    boolean isEmpty();
}
