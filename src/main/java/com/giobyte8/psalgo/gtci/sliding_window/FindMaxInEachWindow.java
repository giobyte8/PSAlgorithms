package com.giobyte8.psalgo.gtci.sliding_window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindMaxInEachWindow {

    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        List<Integer> maxValues = new ArrayList<>();
        LinkedList<Integer> sortedWindow = new LinkedList<>();

        int windowEnd;
        for (windowEnd = 0; windowEnd < w && windowEnd < nums.length; windowEnd++) {
            addKeepingOrder(sortedWindow, nums[windowEnd]);
        }
        maxValues.add(sortedWindow.getLast());

        int windowStart = 1;
        while (windowEnd < nums.length) {
            sortedWindow.removeFirstOccurrence(nums[windowStart - 1]);
            addKeepingOrder(sortedWindow, nums[windowEnd]);
            maxValues.add(sortedWindow.getLast());

            windowStart++;
            windowEnd++;
        }

        return maxValues.stream().mapToInt(x -> x).toArray();
    }

    /**
     * Adds a given element to the list in the required position to keep
     * ascending order of its elements
     *
     * @param dq Target linked list
     * @param value Value to insert into list
     */
    private static void addKeepingOrder(LinkedList<Integer> dq, int value) {
        if (dq.isEmpty() || value >= dq.getLast()) {
            dq.add(value);
        }

        else {
            for (int i = 0; i < dq.size(); i++) {
                if (value <= dq.get(i)) {
                    dq.add(i, value);
                    break;
                }
            }
        }
    }
}
