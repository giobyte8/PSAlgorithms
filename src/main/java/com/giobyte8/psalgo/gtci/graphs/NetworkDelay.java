package com.giobyte8.psalgo.gtci.graphs;

import java.util.*;

public class NetworkDelay {

    public static int networkDelayTime(int[][] times, int n, int k) {

        // Create adjacency map
        Map<Integer, List<int[]>> adjacency = new HashMap<>(n);
        for (int[] time : times) {
            int src = time[0];
            int dst = time[1];
            int delay = time[2];

            List<int[]> edges = adjacency.computeIfAbsent(
                    src,
                    key -> new ArrayList<>()
            );
            edges.add(new int[]{dst, delay});
        }

        // Make sure source vertex is connected
        if (!adjacency.containsKey(k)) return -1;


        // Compute network delay

        int delay = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> toVisit = new PriorityQueue<>(

                // Compare edges by its delay (weight)
                Comparator.comparingInt(edge -> edge[1])
        );

        // Start by visiting source vertex
        toVisit.addAll(adjacency.get(k));
        visited.add(k);

        // Follow all edges from source and compute delays
        while (!toVisit.isEmpty()) {
            int[] cheaperEdge = toVisit.poll();
            int currentVertex = cheaperEdge[0];

            if (!visited.contains(currentVertex)) {
                delay = Math.max(delay, cheaperEdge[1]);
                visited.add(currentVertex);

                // If vertex has neighbors, queue it for visit
                if (adjacency.containsKey(currentVertex)) {
                    List<int[]> edges = adjacency.get(currentVertex);

                    edges.stream()
                            .filter(edge -> !visited.contains(edge[0]))
                            .forEach(edge -> toVisit.add(new int[]{
                                    edge[0],
                                    edge[1] + cheaperEdge[1]
                            }));
                }
            }
        }

        // Return network delay if all vertices were visited
        return visited.size() == n ? delay : -1;
    }
}
