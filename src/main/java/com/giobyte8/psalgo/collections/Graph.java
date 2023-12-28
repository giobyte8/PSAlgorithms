package com.giobyte8.psalgo.collections;

import com.giobyte8.psalgo.collections.exceptions.VertexNotFoundException;

import java.util.List;

public interface Graph<T> {

    void add(T value);

    void addAll(T[] values);

    void link(T src, T dst) throws VertexNotFoundException;

    boolean contains(T vtxValue);

    int size();

    List<T> traverseBFS();

    List<T> traverseDFS();
}
