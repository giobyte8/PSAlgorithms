package com.giobyte8.psalgo.gtci.fast_slow_pointers;

import java.util.HashSet;
import java.util.Set;

// TODO Verify solution
public class CircularArrayLoop {

    /**
     * Looks for circular loops using a HashSet to keep track of
     * already visited positions
     * <br/>
     *
     * time: O(n^2)
     * space: O(n^2
     */
    public static boolean circularArrayLoopUsingSet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> visitedPositions = new HashSet<>();

            boolean goingForward = nums[i] > 0;
            visitedPositions.add(i);

            int currPosition = i;
            boolean stillGoingForward = goingForward;
            while (stillGoingForward == goingForward) {

                // Advance and retrieve new position
                currPosition = move(nums, currPosition);

                // Check if position was previously visited
                if (visitedPositions.contains(currPosition)) {

                    // Sequence must have at least two positions
                    return visitedPositions.size() > 1;
                }

                // Add new position to set of visited positions and
                // verify that move direction hasn't changed
                visitedPositions.add(currPosition);
                stillGoingForward = nums[currPosition] > 0;
            }
        }

        return false;
    }

    /**
     * Looks for circular loops using fast and slow pointers pattern
     * to keep track of already visited positions
     * <br/>
     *
     * time: O(n^2)
     * space: O(1)
     */
    public static boolean circularArrayLoopFastSlowPointers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int slowPointer = i;
            int fastPointer = i;

            boolean goingForward = nums[slowPointer] > 0;
            boolean stillGoingForward = goingForward;
            boolean sequenceGreaterThanOne = false;

            // Advance pointers until find cycle or change directions
            while (stillGoingForward == goingForward) {

                // Advance both pointers
                slowPointer = move(nums, slowPointer);

                // Advance fast pointer 1 time and verify that move
                // direction doesn't change
                fastPointer = move(nums, fastPointer);
                stillGoingForward = nums[fastPointer] > 0;

                // Advance and verify again
                fastPointer = move(nums, fastPointer);
                stillGoingForward = stillGoingForward && nums[fastPointer] > 0;

                // Check if position was previously visited
                if (slowPointer == fastPointer) {

                    // Sequence must have at least two positions
                    return sequenceGreaterThanOne && stillGoingForward;
                }

                // Sequence has more than one position
                else {
                    sequenceGreaterThanOne = true;
                }
            }
        }

        return false;
    }

    /**
     * Advance the number of steps indicated by value at
     * given 'fromPosition' (Forward or backward) and returns
     * the new position in array.
     *
     * @param nums Array to traverse (Forward of backward)
     * @param fromPosition Index of array where to take the number of
     *                     steps to move (Positive value means move forward)
     */
    private static int move(int[] nums, int fromPosition) {
        boolean goingForward = nums[fromPosition] > 0;
        int targetSteps = nums[fromPosition];

        int steps = 0;
        int currPos = fromPosition;
        while (steps != targetSteps) {
            if (goingForward) {

                // If reached end of array go back to beginning
                // otherwise advance 1 position
                currPos = (currPos == nums.length - 1)
                        ? 0
                        : currPos + 1;

                steps++;
            } else {

                // If reached start of array go to end of it
                // otherwise go back 1 position
                currPos = (currPos == 0)
                        ? nums.length - 1
                        : currPos - 1;

                steps--;
            }
        }

        return currPos;
    }
}
