package com.giobyte8.psalgo.gtci.two_heaps;

import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

/**
 * Create a data structure that can store a list of integers that can change
 * in size over time and find the median from this dynamically growing list
 * in constant time, O(1).
 * <br/>
 *
 * Implement a class, MedianOfStream, which should support the following
 * operations:
 * - Constructor(): This initializes the object of this class, which in
 *   turn creates the max and the min heap.
 * - Insert Num(num): This adds an integer, num, to the data structure.
 * - Find Median(): This finds the median of all elements seen so far.
 *   If there are an even number of elements, return the average of the
 *   two middle values.
 */
public class MedianOfStream {

    final PriorityQueue<Integer> firstHalf;
    final PriorityQueue<Integer> secondHalf;

    public MedianOfStream() {
        firstHalf = new PriorityQueue<>(
                comparingInt(Integer::intValue).reversed()
        );
        secondHalf = new PriorityQueue<>(comparingInt(Integer::intValue));
    }

    public void insertNum(int num) {
        if (firstHalf.isEmpty()) {
            firstHalf.add(num);
        } else if (num <= firstHalf.peek()) {
            firstHalf.add(num);
        } else {
            secondHalf.add(num);
        }


        // Balance allocated numbers in both queues
        reBalance();
    }

    public void remove(int num) {
        if (firstHalf.remove(num) || secondHalf.remove(num)) {
            reBalance();
        }
    }

    private void reBalance() {
        while (secondHalf.size() - firstHalf.size() > 0) {
            firstHalf.add(secondHalf.poll());
        }

        if ((firstHalf.size() + secondHalf.size()) % 2 == 0) {
            while (firstHalf.size() - secondHalf.size() > 0) {
                secondHalf.add(firstHalf.poll());
            }
        }

        // First half must have one element more than second half
        else {
            while (firstHalf.size() - secondHalf.size() > 1) {
                secondHalf.add(firstHalf.poll());
            }
        }
    }

    public double findMedian() {
        if (firstHalf.isEmpty()) return 0;

        if (firstHalf.size() == secondHalf.size()) {
            return (double) (firstHalf.peek() + secondHalf.peek()) / 2;
        }

        return firstHalf.peek();
    }
}
