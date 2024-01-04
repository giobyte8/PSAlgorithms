package com.giobyte8.psalgo.gtci.topk;

import java.util.*;

public class KthLargest {

    private final int k;

    private final PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.stream(nums).forEach(this::add);
    }

    @SuppressWarnings("DataFlowIssue")
    public int add(int num) {
        if (pq.size() < k) {
            pq.add(num);
        } else if(num > pq.peek()) {
            pq.poll();
            pq.add(num);
        }

        return pq.peek();
    }
}
