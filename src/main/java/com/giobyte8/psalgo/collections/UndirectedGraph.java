package com.giobyte8.psalgo.collections;

import com.giobyte8.psalgo.collections.exceptions.VertexNotFoundException;

import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraph<T> implements Graph<T> {

    private final List<List<T>> adjacencyList = new ArrayList<>();

    @Override
    public void add(T value) {
        if (!contains(value)) {
            List<T> vertex = new ArrayList<>();
            vertex.add(value);

            adjacencyList.add(vertex);
        }
    }

    @Override
    public void addAll(T[] values) {
        Arrays.stream(values).forEach(this::add);
    }

    @Override
    public void link(T src, T dst) throws VertexNotFoundException {
        if (!contains(dst))
            throw new VertexNotFoundException(dst.toString());

        getVertex(src).add(dst);
    }

    @Override
    public boolean contains(T vtxValue) {
        return adjacencyList
                .stream()
                .anyMatch(vertex -> vertex.get(0).equals(vtxValue));
    }

    @Override
    public int size() {
        return adjacencyList.size();
    }

    @Override
    public List<T> traverseBFS() {
        List<T> traverse = new ArrayList<>(size());
        if (size() == 0) return traverse;

        Queue<T> toVisit = new LinkedList<>();
        toVisit.add(adjacencyList.get(0).get(0));

        // Traverse all graph nodes
        while (!toVisit.isEmpty()) {
            T currVtxValue = toVisit.poll();
            traverse.add(currVtxValue);

            // Enqueue all neighbors of current vertex
            List<T> vtx = getVertex(currVtxValue);
            if (vtx.size() > 1) {
                vtx.stream()
                        .skip(1)
                        .filter(vtxValue -> !traverse.contains(vtxValue))
                        .filter(vtxValue -> !toVisit.contains(vtxValue))
                        .forEach(toVisit::offer);
            }
        }

        return traverse;
    }

    @Override
    public List<T> traverseDFS() {
        List<T> traverse = new ArrayList<>(size());
        if (size() == 0) return traverse;

        Stack<T> backtrack = new ArrayStack<>();
        backtrack.push(adjacencyList.get(0).get(0));

        while (backtrack.size() > 0) {

            // Visit next vertex from stack
            T currVtxValue = backtrack.peek();
            if (!traverse.contains(currVtxValue)) {
                traverse.add(currVtxValue);
            }

            // Get first unvisited neighbor
            List<T> vtx = getVertex(currVtxValue);
            Optional<T> unvisitedNeighborOpt = vtx.stream()
                    .skip(1)
                    .filter(vtxValue -> !traverse.contains(vtxValue))
                    .findFirst();

            // Add unvisited vertex to stack to visit it in next iteration
            if (unvisitedNeighborOpt.isPresent()) {
                backtrack.push(unvisitedNeighborOpt.get());
            }

            // Remove current vertex from stack and go back to previous one
            else {
                backtrack.pop();
            }
        }

        return traverse;
    }

    private List<T> getVertex(T vtxValue) throws VertexNotFoundException {
        return adjacencyList
                .stream()
                .filter(vertex -> vertex.get(0).equals(vtxValue))
                .findFirst()
                .orElseThrow(() -> new VertexNotFoundException(vtxValue.toString()));
    }
}
