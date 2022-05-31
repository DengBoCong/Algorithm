package com.dbc;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] count = new int[numCourses];
        Arrays.fill(count, 0);
        for (int[] prerequisite : prerequisites) {
            count[prerequisite[0]]++;
            if (!graph.containsKey(prerequisite[1])) graph.put(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int item = queue.poll();
            if (graph.containsKey(item)) {
                for (int node : graph.get(item)) {
                    count[node]--;
                    if (count[node] == 0) queue.add(node);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
