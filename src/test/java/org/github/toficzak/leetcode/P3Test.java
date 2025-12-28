package org.github.toficzak.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P3Test {

    private static List<Arguments> arguments() {
        return List.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("abba", 2),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testBruteforce(String input, int expected) {
        var result = new P3().lengthOfLongestSubstringBruteforce(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testWindow(String input, int expected) {
        var result = new P3().lengthOfLongestSubstringWindow(input);
        Assertions.assertEquals(expected, result);
    }
}
