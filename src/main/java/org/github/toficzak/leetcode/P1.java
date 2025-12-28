package org.github.toficzak.leetcode;

/*
Theoretical lower bound for the problem, so the min amount of work we need to solve this problem
would be O(n), since each number needs to be inspected - in worst case last one could be desired
pair.

Bruteforce - pairwise comparison
    - time complexity: O(n^2)
    - space complexity: O(1)

How to make it faster?
- assuming we can sacrifice space complexity, we can use hashmap to track what number we need to complement pair.
  This way nums can be inspected all number just once.
    - time complexity: O(n)
    - space complexity: O(n)

 */

import java.util.HashMap;

public class P1 {
    public int[] twoSumBruteforce(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        // complement number -> index od complement
        var seen = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                return new int[]{seen.get(nums[i]), i};
            }
            seen.put(target - nums[i], i);
        }
        return new int[]{};
    }

}
