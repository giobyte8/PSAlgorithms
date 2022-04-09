package com.giobyte8.psalgo.collections;

public interface List<T> extends Iterable<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    int size();

    void forEachIdx(ConsumerIdx<T> consumer);

    interface ConsumerIdx<T> {
        void onItem(T element, int idx);
    }
}
