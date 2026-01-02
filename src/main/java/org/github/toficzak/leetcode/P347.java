package org.github.toficzak.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
    n = nums.length
    worst case: all elements unique

    theoretical lower bound: O(n), I have to check each element at least once, each can affect result
 */
public class P347 {
    /*
    Collect all nums as map (num, frequency).
        - time complexity: O(n),
        - space complexity: O(n)
    Sort map entries by frequencies desc.
        - time complexity: O(n log n)
        - space complexity: O(n)
    Return top k.

    Overall time complexity: O(n log n)
    Overall space complexity: O(n)
     */
    public int[] topKFrequentBySort(int[] nums, int k) {

        var frequencies = new HashMap<Integer, Integer>();
        for (var num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }

        return frequencies.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    /*
        Collect all nums as map (num, frequency).
            - time complexity: O(n),
            - space complexity: O(n)
         Create priority queue (min-heap) comparing frequencies.
         Offer each element and if there's too many in queue, poll smallest.
            - time complexity: O(log k)
            - space complexity: O(k)
        Overall time complexity: O(n log k)
        Overall space complexity: O(n)
     */
    public int[] topKFrequentByPriorityQueue(int[] nums, int k) {

        var frequencies = new HashMap<Integer, Integer>();
        for (var num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }

        var queue = new PriorityQueue<Integer>(Comparator.comparing(frequencies::get));
        for (var num : frequencies.keySet()) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
