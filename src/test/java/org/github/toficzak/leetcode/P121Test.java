package org.github.toficzak.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P121Test {

    private static List<Arguments> testCases() {
        return List.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testBruteforce(int[] input, int expected) {
        var result = new P121().maxProfitBruteforce(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testTwoSlidingWindow(int[] input, int expected) {
        var result = new P121().maxProfitSlidingWindow(input);
        Assertions.assertEquals(expected, result);
    }
}
