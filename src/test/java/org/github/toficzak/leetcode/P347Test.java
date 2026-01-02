package org.github.toficzak.leetcode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P347Test {

    private static List<Arguments> testcases() {
        return List.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3}, 3, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void sortTest(int[] nums, int k, int[] expected) {
        var result = new P347().topKFrequentBySort(nums, k);
        Arrays.sort(result);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void priorityQueueTest(int[] nums, int k, int[] expected) {
        var result = new P347().topKFrequentByPriorityQueue(nums, k);
        Arrays.sort(result);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, result);
    }
}
