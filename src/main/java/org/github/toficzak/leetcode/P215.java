package org.github.toficzak.leetcode;

import java.util.PriorityQueue;

/*
theoretical lower bound: O(n), since each element needs to be inspected
 */
public class P215 {
    /*
    time complexity: O(n log k)
    space complexity: O(k)
    invariant: after each iteration pq contains largest found elements up-to-date
     */
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        if (pq.isEmpty()) {
            // just to clear warning
            throw new RuntimeException("Nothing in queue");
        }
        return pq.peek();
    }
}
