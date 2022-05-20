package com.dbc;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    private int search(int left, int right, int target, int[][] intervals) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] >= target) right = mid;
            else left = mid + 1;
        }
        return intervals[left][0] >= target ? intervals[left][1] : -1;
    }

    public int[] findRightInterval(int[][] intervals) {
        int[][] startIntervals = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            ans[i] = search(0, intervals.length - 1, intervals[i][1], startIntervals);
        }
        return ans;
    }
}
