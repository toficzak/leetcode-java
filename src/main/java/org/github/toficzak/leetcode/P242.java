package org.github.toficzak.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/*
Theoretical lower bound - O(s+t), each element of both strings must be checked

Solutions:
1) bruteforce - pairwise comparison
    time complexity: O(s*t)
    space complexity: O(t)

2) sort and compare
    time complexity: O(n log(n))
    space complexity: O(s+t)

3) letter-occurrence array
    time complexity: O(s+t)
    space complexity: O(1)
 */
public class P242 {
    public boolean isAnagramBruteforce(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var sChars = s.toCharArray();
        var tChars = t.toCharArray();
        var seen = false;
        var seenIdx = new HashSet<Integer>();

        for (char sChar : sChars) {
            for (int j = 0; j < tChars.length; j++) {
                var tChar = tChars[j];
                if (sChar == tChar && !seenIdx.contains(j)) {
                    seen = true;
                    seenIdx.add(j);
                    break;
                }
            }
            if (!seen) {
                return false;
            }
            seen = false;
        }
        return true;
    }

    public boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var sChars = s.toCharArray();
        var tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) return false;
        }

        return true;
    }

    public boolean isAnagramOccurrences(String s, String t) {
        if (s.length() != t.length()) return false;

        var letterOccurrences = new int[26];
        var sChars = s.toCharArray();
        var tChars = t.toCharArray();

        for (char sChar : sChars) {
            var index = charToAsciiInt(sChar);
            letterOccurrences[index] += 1;
        }

        for (char tChar : tChars) {
            var index = charToAsciiInt(tChar);
            letterOccurrences[index] -= 1;
        }

        for (int occurrence : letterOccurrences) {
            if (occurrence != 0) return false;
        }

        return true;
    }

    private static final int ASCII_LETTER_A_ID = 97;

    private int charToAsciiInt(char c) {
        return (int) c - ASCII_LETTER_A_ID;
    }
}
