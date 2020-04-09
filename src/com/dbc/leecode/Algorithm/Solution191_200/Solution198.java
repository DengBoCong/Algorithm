package com.dbc.leecode.Algorithm.Solution191_200;

import java.util.*;

public class Solution198 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            lists.add(new ArrayList<>());

        for (int[] tmp : prerequisites){
            indegrees[tmp[0]]++;
            lists.get(tmp[1]).add(tmp[0]);
        }

        for (int i = 0; i < numCourses; i++){
            if (indegrees[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for (int tmp : lists.get(pre)){
                indegrees[tmp]--;
                if (indegrees[tmp] == 0) queue.add(tmp);
            }
        }

        return numCourses == 0;
    }
}
