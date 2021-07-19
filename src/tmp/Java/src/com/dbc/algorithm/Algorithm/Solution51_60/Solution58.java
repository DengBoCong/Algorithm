package com.dbc.leecode.Algorithm.Solution51_60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution58 {
    public int[][] insertS1(int[][] intervals, int[] newInterval){
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();

        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        int[] interval = new int[2];
        if(output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
        else{
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        while(idx < n){
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            if(output.getLast()[1] < start) output.add(interval);
            else{
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[]lastInterval = null;
        int i = 0;
        for(; i < intervals.length; i++){
            if(newInterval[0] < intervals[i][0]){
                // 新区间的start比当前区间的start要小，则插入新区间
                lastInterval = addOrUpdate(result, lastInterval, newInterval);
                break;
            }
            lastInterval = addOrUpdate(result, lastInterval, intervals[i]);
        }
        if(i == intervals.length){
            // 将新区间添加到最后
            addOrUpdate(result, lastInterval, newInterval);
        }else{
            // 新区间已插入，添加后续的区间
            for(; i < intervals.length; i++){
                lastInterval = addOrUpdate(result, lastInterval, intervals[i]);
            }
        }
        return result.toArray(new int[0][]);
    }

    private int[] addOrUpdate(List<int[]> result, int[] lastInterval, int[] newInterval) {
        if (lastInterval == null || lastInterval[1] < newInterval[0]) {
            lastInterval = newInterval;
            result.add(newInterval);
        } else if (lastInterval[1] < newInterval[1]) {
            lastInterval[1] = newInterval[1];
        }
        return lastInterval;
    }
}
