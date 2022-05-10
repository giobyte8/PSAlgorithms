package com.giobyte8.psalgo.lc;


import com.giobyte8.psalgo.collections.PriorityQueue;

import java.util.Comparator;

public class MedianFinder {

    private final PriorityQueue<Integer> firstHalf;
    private final PriorityQueue<Integer> secondHalf;

    public MedianFinder() {
        Comparator<Integer> intComparator = Comparator.comparingInt(e -> e);

        firstHalf = new PriorityQueue<>(intComparator.reversed());
        secondHalf = new PriorityQueue<>(intComparator);
    }

    public void addNum(int num) {
        if (firstHalf.isEmpty()) {
            firstHalf.add(num);
        } else if (num <= firstHalf.peek()) {
            firstHalf.add(num);
        } else {
            secondHalf.add(num);
        }

        // Keep queues sizes balance
        if (firstHalf.size() - secondHalf.size() == 2) {
            secondHalf.add(firstHalf.poll());
        }

        else if (secondHalf.size() - firstHalf.size() == 1) {
            firstHalf.add(secondHalf.poll());
        }
    }

    public double findMedian() {
        if (firstHalf.size() - secondHalf.size() == 1) {
            return firstHalf.peek();
        }

        double sum = firstHalf.peek() + secondHalf.peek();
        return sum / 2;
    }
}
