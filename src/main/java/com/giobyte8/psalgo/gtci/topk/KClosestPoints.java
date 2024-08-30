package com.giobyte8.psalgo.gtci.topk;

import java.util.*;

/**
 * <a href="https://www.educative.io/courses/grokking-coding-interview-patterns-java/k-closest-points-to-origin">...</a>
 */
public class KClosestPoints {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distanceToOrigin() {
            return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }

    public static List<Point> kClosest(Point[] points, int k) {

        // Create a max heap to store k points closest to origin
        Comparator<Point> pointComparator = Comparator
                .comparingDouble(Point::distanceToOrigin)
                .reversed();
        PriorityQueue<Point> closestPoints = new PriorityQueue<>(pointComparator);

        // Add first k points to max heap
        // -> k is guaranteed to be <= points.length
        for (int i = 0; i < k; i++) {
            closestPoints.offer(points[i]);
        }

        // Iterate remaining points in array and add to heap if
        // a closest point than fairest from group is found
        for (int i = k; i < points.length; i++) {
            if (closestPoints.peek().distanceToOrigin() > points[i].distanceToOrigin()) {
                closestPoints.poll();
                closestPoints.add(points[i]);
            }
        }

        return new ArrayList<>(closestPoints);
    }
}
