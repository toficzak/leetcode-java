package org.github.toficzak.leetcode;

import java.util.Arrays;

/*
n = s.length

theoretical lower bound: O(n) - I need to check each element in array at least once.

1) bruteforce
    create array with reversed order and compare if both are equal
    - time complexity: O(n) - normalization of string, copying then checking equality is 3n -> n
    - space complexity: O(n) - additional array of the same length and normalization creates one

2) two pointer approach
    set pointer at the beginning and at the end of a string, move them toward each other checking if values are the same
    - time complexity: O(n) - one run with two pointers: n
    - space complexity: O(1) - constant number of helper variables

 */
public class P125 {
    public boolean isPalindromeBruteforce(String s) {
        var normalizedString = normalizeString(s);
        var newArray = new char[normalizedString.length()];
        for (int i = 0; i < normalizedString.length(); i++) {
            newArray[i] = normalizedString.charAt(normalizedString.length() - 1 - i);
        }

        return Arrays.equals(newArray, normalizedString.toCharArray());
    }

    private String normalizeString(String s) {
        var newS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                newS.append(s.charAt(i));
            }
        }
        return newS.toString().toLowerCase();
    }

    public boolean isPalindromeTwoPointers(String s) {
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
