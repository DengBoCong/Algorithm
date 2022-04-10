package com.dbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int left = 0, right = 0;
        List<int[]> remain = new ArrayList<>();
        while (right < intervals.length) {
            int endNum = intervals[left][1];
            while (right < intervals.length && intervals[right][0] <= endNum) {
                endNum = Math.max(endNum, intervals[right][1]);
                right++;
            }
            if (right - 1 != left) {
                remain.add(new int[]{intervals[left][0], endNum});
            } else {
                remain.add(intervals[left]);
            }
            left = right;
        }
        int[][] res = new int[remain.size()][2];
        for (int i = 0; i < remain.size(); i++) {
            res[i][0] = remain.get(i)[0];
            res[i][1] = remain.get(i)[1];
        }
        return res;
    }
}
