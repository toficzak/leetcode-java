package org.github.toficzak.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P217Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{2, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testBruteforce(int[] input, Boolean expected) {
        var result = new P217().containsDuplicateBruteforce(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testSet(int[] input, Boolean expected) {
        var result = new P217().containsDuplicateSet(input);
        Assertions.assertEquals(expected, result);
    }
}
