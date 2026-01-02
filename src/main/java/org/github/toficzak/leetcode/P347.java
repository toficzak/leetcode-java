package org.github.toficzak.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P347 {
    /*
    n = nums.length
    worst case: all elements unique

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
}
