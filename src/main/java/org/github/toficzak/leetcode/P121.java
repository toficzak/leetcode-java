package org.github.toficzak.leetcode;

/*
theoretical lower bound: O(n)
    why? Because I need to check each element in array at least once to prove I found max profit

1) bruteforce
    pairwise comparison from given value to the right of an array
    - time complexity: O(n^2) - for each element check array from this element
    - space complexity: O(1) - helper variable

2) sliding window
    I need to remember the lowest value from the past and search for the highest in the future.
    Hence, I can just move through array keeping maxProfit and lowestPrice as a pointers.
    - time complexity: O(n)
    - space complexity: O(1) - helper variables
    - loop invariant: each value is processed exactly one time. Values on the left are already processed,
    values on the right will be processed.
 */

public class P121 {
    public int maxProfitBruteforce(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public int maxProfitSlidingWindow(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = 0;
        int lowestPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }
        return maxProfit;
    }
}
