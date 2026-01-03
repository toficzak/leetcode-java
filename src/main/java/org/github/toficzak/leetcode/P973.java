package org.github.toficzak.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    n = points.length
    theoretical lower bound: O(n)
        - have to inspect each element at least once, each can affect the answer
 */
public class P973 {

    /*
        bruteforce approach:
        - count all distances (without sqrt, meaningless), map point -> distance
            - time complexity: O(n)
            - space complexity: O(n)
        - sort by distance
            - time complexity: O(n log n),
            - space complexity: O(n)
        - take k first as result
            - time complexity: O(n)
            - space complexity: O(1)

        - time complexity: O(n log n),
        - space complexity: O(n)
     */
    public int[][] kClosestBruteforce(int[][] points, int k) {
        return Arrays.stream(points).toList().stream()
                .sorted(Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]))
                .limit(k)
                .toArray(int[][]::new);
    }

    /*
        priority queue approach
        - for each point count distance and check, if it can be stored by queue
            - time complexity: O(n)
            - space complexity: O(n)
        - priority queue (max-heap - worst element are max distance from 0,0) accepts
          only better cases, skipping worse with O(1)
            - time complexity: O(log k)
            - space complexity: O(k) - only queue

        Overall
            - time complexity: O(n log k)
            - space complexity: O(k)
     */
    public int[][] kClosestPriorityQueue(int[][] points, int k) {
        var priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(P973::distance).reversed()
        );

        for (int[] point : points) {
            priorityQueue.offer(point);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.toArray(int[][]::new);
    }

    private static int distance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
