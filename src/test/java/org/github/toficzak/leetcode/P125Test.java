package org.github.toficzak.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P125Test {

    private static List<Arguments> arguments() {
        return List.of(
                Arguments.of("kajak", true),
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of("", true),
                Arguments.of(",,,,,,", true),
                Arguments.of("A1b2b1a", true),
                Arguments.of("0P", false),
                Arguments.of("1a2", false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testBruteforce(String s, boolean expected) {
        var result = new P125().isPalindromeBruteforce(s);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testTwoPointers(String s, boolean expected) {
        var result = new P125().isPalindromeTwoPointers(s);
        Assertions.assertEquals(expected, result);
    }
}
