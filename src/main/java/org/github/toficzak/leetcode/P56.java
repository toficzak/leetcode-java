package org.github.toficzak.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


import static java.lang.Math.max;


/*
n - interval.length

Assumptions:
- I can modify input array

- theoretical lower bound: O(n), since each interval needs to checked at least once
 */
public class P56 {

    /*
    sort and merge:
    sort by start, iterate and merge if values overlaps.

    invariant: outside the loop each element is already merged if necessary

    - time complexity: O(n log n), sort (n log n) and one iteration
    - space complexity: O(n), for sorting in java

     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // modifies input array
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

        var result = new ArrayList<int[]>();
        var last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            var current = intervals[i];
            if (last[1] >= current[0]) {
                last[1] = max(last[1], current[1]);
            } else {
                result.add(last);
                last = current;
            }
        }
        result.add(last);

        return result.toArray(new int[result.size()][]);
    }

    public int[][] mergeWithTwoPointers(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // modifies input array
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

        var write = 0;

        for (int read = 1; read < intervals.length; read++) {
            if (intervals[write][1] >= intervals[read][0]) {
                intervals[write][1] = max(intervals[write][1], intervals[read][1]);
            } else {
                write++;
                intervals[write] = intervals[read];
            }
        }

        return Arrays.copyOf(intervals, write + 1);
    }
}
