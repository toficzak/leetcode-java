package org.github.toficzak.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P704Test {

    private static List<Arguments> testcases() {
        return List.of(
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1),
                Arguments.of(new int[]{1}, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void bruteforceTest(int[] input, int target, int expected) {
        var result = new P704().searchBruteforce(input, target);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void binarySearchIterativeTest(int[] input, int target, int expected) {
        var result = new P704().searchBinarySearchIterative(input, target);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void binarySearchRecursiveTest(int[] input, int target, int expected) {
        var result = new P704().searchBinarySearchRecursive(input, target);
        Assertions.assertEquals(expected, result);
    }
}
