package org.github.toficzak.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P973Test {

    private static List<Arguments> testcases() {
        return List.of(
                Arguments.of(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}),
                Arguments.of(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}})
        );
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void bruteforceTest(int[][] input, int amount, int[][] expected) {
        var result = new P973().kClosestBruteforce(input, amount);
        Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void priorityQueueTest(int[][] input, int amount, int[][] expected) {
        var result = new P973().kClosestPriorityQueue(input, amount);
        Assertions.assertArrayEquals(sortByFirstElement(expected), sortByFirstElement(result));
    }

    private static int[][] sortByFirstElement(int[][] arr) {
        return java.util.Arrays.stream(arr)
                .sorted(java.util.Comparator.comparingInt(a -> a[0]))
                .toArray(int[][]::new);
    }
}
