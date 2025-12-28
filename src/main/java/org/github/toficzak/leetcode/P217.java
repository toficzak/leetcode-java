package org.github.toficzak.leetcode;

/*
Theoretical lower bound - O(n), since each element must be inspected at least once.

1) bruteforce solution - pairwise comparison
   - time complexity: O(n^2)
   - space complexity: O(1)

2) set solution - keep set of seen elements, sacrifice space for time
    - time complexity: O(n)
    - space complexity: O(n)

 */

import java.util.HashSet;

public class P217 {
    public boolean containsDuplicateBruteforce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateSet(int[] nums) {
        var seen = new HashSet<Integer>();

        for (int value : nums) {
            if (seen.contains(value)) {
                return true;
            }
            seen.add(value);
        }
        return false;
    }

    public boolean containsDuplicateSetEnhanced(int[] nums) {
        var seen = new HashSet<Integer>();

        for (int value : nums) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}
