package com.dbc.algorithm.Array;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[adjacentPairs.length + 1];
        Set<Integer> seen = new HashSet<>();
        for (int[] adj : adjacentPairs) {
            if (!map.containsKey(adj[0])) {
                map.put(adj[0], new LinkedList<>());
            }
            map.get(adj[0]).add(adj[1]);
            if (!map.containsKey(adj[1])) {
                map.put(adj[1], new LinkedList<>());
            }
            map.get(adj[1]).add(adj[0]);
        }
        System.out.println(map.toString());

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                result[0] = entry.getKey();
                result[1] = entry.getValue().get(0);
                seen.add(entry.getKey());
                seen.add(entry.getValue().get(0));
                break;
            }
        }

        int count = 1;
        while (count < adjacentPairs.length) {
            List<Integer> list = map.get(result[count]);
            count++;
            for (int i = 0; i < list.size(); i++) {
                if (!seen.contains(list.get(i))) {
                    result[count] = list.get(i);
                    seen.add(list.get(i));
                    break;
                }
            }
        }
        return result;
    }
}
