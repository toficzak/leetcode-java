package org.github.toficzak.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P215Test {

    private static List<Arguments> testcases() {
        return List.of(
                Arguments.of(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.of(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void test(int[] input, int k, int expected) {
        var result = new P215().findKthLargest(input, k);
        Assertions.assertEquals(expected, result);
    }
}
