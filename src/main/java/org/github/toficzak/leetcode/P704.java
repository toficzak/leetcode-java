package org.github.toficzak.leetcode;

/*
    n = nums.length
    theoretical lower bound: O(log n), binary search is optimal for comparison-based model on sorted array
 */
public class P704 {

    /*
        bruteforce solution: linear search

        - time complexity: O(n)
        - space complexity: O(1)
     */
    public int searchBruteforce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    /*
        binary search solution - iterative approach
        cut down range with each iteration
        invariant: everything outside [left,right] is already rejected.
                   if target exists, it's in [left, right]

        - time complexity: O(log n)
        - space complexity: O(1)
     */
    public int searchBinarySearchIterative(int[] nums, int target) {

        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var middle = (left + ((right - left) / 2));

            if (nums[middle] == target) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return -1;
    }

    /*
        binary search solution - recursive approach
        cut down range with each iteration
        invariant: everything outside [left,right] is already rejected.
                   if target exists, it's in [left, right]

        - time complexity: O(log n)
        - space complexity: O(log n) - stack trace
     */
    public int searchBinarySearchRecursive(int[] nums, int target) {
        return recursiveBinarySearchHelper(nums, target, 0, nums.length - 1);
    }

    private int recursiveBinarySearchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        var middle = (left + ((right - left) / 2));

        if (nums[middle] == target) {
            return middle;
        } else if (target > nums[middle]) {
            return recursiveBinarySearchHelper(nums, target, middle + 1, right);
        } else {
            return recursiveBinarySearchHelper(nums, target, left, middle - 1);
        }
    }

}
