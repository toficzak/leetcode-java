package org.github.toficzak.leetcode;

import java.util.HashSet;

/*
theoretical lower bound: O(s.length()), because I need to inspect each letter in string in worst case.

1)  bruteforce solution
    Get all substring and remember the longest one which make constraint valid - no repeating characters
    - time complexity: O(n^3) -> n^2 due to two loops and additional n for created set
    - space complexity: O(n) -> due to created set

2)  window solution
    move right pointer while no repetition, if there is one, move left pointer till there's no repetition
    - time complexity: O(n) -> I will traverse through each element of an array at max twice
    - space complexity: O(n) -> I will keep set of state and two pointers, which are O(1)

 */
public class P3 {
    public int lengthOfLongestSubstringBruteforce(String s) {

        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                var set = new HashSet<>();
                var substring = s.substring(i, j + 1).toCharArray();
                for (char c : substring) {
                    set.add(c);
                }
                longest = Math.max(longest, set.size());
                if (substring.length != set.size()) {
                    break;
                }
            }
        }

        return longest;
    }

    public int lengthOfLongestSubstringWindow(String s) {
        int longest = 0;
        int left = 0;
        var state = new HashSet<>();

        for (var c : s.toCharArray()) {
            if (!state.contains(c)) {
                state.add(c);
            } else {
                while (state.contains(c)) {
                    state.remove(s.charAt(left));
                    left += 1;
                }
            }
            longest = Math.max(longest, state.size());
        }

        return longest;
    }
}
