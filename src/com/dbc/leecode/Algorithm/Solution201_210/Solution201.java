package com.dbc.leecode.Algorithm.Solution201_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution201 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] dree = new int[numCourses];
        int[] result = new int[numCourses];
        int count = 0;
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            lists.add(i, new ArrayList<>());//第一处

        for (int[] tmp : prerequisites){
            dree[tmp[0]]++;
            lists.get(tmp[1]).add(tmp[0]);
        }

        for (int i = 0; i < numCourses; i++){
            if (dree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[count] = cur;
            numCourses--;
            count++;
            for (int tmp : lists.get(cur)) {
                dree[tmp]--;
                if (dree[tmp] == 0) queue.add(tmp);
            }
        }

        if (numCourses == 0)
            return result;

        return new int[]{};
    }
}
