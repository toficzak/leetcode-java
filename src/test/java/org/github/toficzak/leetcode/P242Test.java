package org.github.toficzak.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P242Test {

    static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false),
                Arguments.of("rr", "r", false),
                Arguments.of("", "", true),
                Arguments.of("a", "a", true),
                Arguments.of("a", "", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void bruteforceTest(String s, String t, Boolean expected) {
        var result = new P242().isAnagramBruteforce(s, t);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void sortTest(String s, String t, Boolean expected) {
        var result = new P242().isAnagramSort(s, t);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testcases")
    void occurrencesTest(String s, String t, Boolean expected) {
        var result = new P242().isAnagramOccurrences(s, t);
        Assertions.assertEquals(expected, result);
    }
}
