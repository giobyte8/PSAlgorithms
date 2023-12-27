package com.giobyte8.psalgo.gtci.two_heaps;

public class MedianSlidingWindow {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new double[]{};
        if (k > nums.length) return new double[]{};

        double[] medians = new double[nums.length - k + 1];
        int mdIdx = 0;

        MedianOfStream mos = new MedianOfStream();
        for (int i = 0; i < k; i++) {
            mos.insertNum(nums[i]);
        }

        medians[mdIdx++] = mos.findMedian();

        for (int i = k; i < nums.length; i++) {
            mos.remove(nums[i - k]);
            mos.insertNum(nums[i]);

            medians[mdIdx++] = mos.findMedian();
        }

        return medians;
    }
}
