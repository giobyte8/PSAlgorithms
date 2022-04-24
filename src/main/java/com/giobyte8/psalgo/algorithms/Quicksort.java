package com.giobyte8.psalgo.algorithms;

class Quicksort {

    private static int partition(int[] elements, int start, int end) {
        int pivot = elements[end];

        // Move all elements smaller than pivot to the left
        // side of partition
        int smallerElementsIdx = start - 1;
        for (int i = start; i < end; i++) {
            if (elements[i] <= pivot) {
                smallerElementsIdx++;
                SortUtils.swap(elements, i, smallerElementsIdx);
            }
        }

        // Move the pivot to the 'middle' of partition so that
        // all smaller elements be at left of pivot and greater
        // elements be at right of pivot
        smallerElementsIdx++;
        SortUtils.swap(elements, smallerElementsIdx, end);

        return smallerElementsIdx;
    }

    public static void sort(int[] elements, int start, int end) {
        if (start > end) return;

        int pivot = partition(elements, start, end);
        sort(elements, start, pivot - 1);
        sort(elements, pivot + 1, end);
    }
}
