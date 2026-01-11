package org.github.toficzak.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P56Test {

    private static List<Arguments> testcases() {
        return List.of(
                Arguments.of(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                Arguments.of(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}}),
                Arguments.of(new int[][]{{4, 7}, {1, 4}}, new int[][]{{1, 7}}),
                Arguments.of(new int[][]{{1, 2}}, new int[][]{{1, 2}})
                // empty case excluded cause constraints
        );
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void test(int[][] intervals, int[][] expected) {
        var result = new P56().merge(intervals);
        Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void testTwoPointers(int[][] intervals, int[][] expected) {
        var result = new P56().mergeWithTwoPointers(intervals);
        Assertions.assertArrayEquals(expected, result);
    }


}
