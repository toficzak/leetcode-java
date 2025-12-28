package org.github.toficzak.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P1Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
                Arguments.of(new int[]{}, 10, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void bruteforceTest(int[] nums, int target, int[] expected) {
        Assertions.assertArrayEquals(expected, new P1().twoSumBruteforce(nums, target));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void hashMapTest(int[] nums, int target, int[] expected) {
        Assertions.assertArrayEquals(expected, new P1().twoSumHashMap(nums, target));
    }
}
