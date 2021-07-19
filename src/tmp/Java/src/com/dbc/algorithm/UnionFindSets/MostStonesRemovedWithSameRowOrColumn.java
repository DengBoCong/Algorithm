package com.dbc.algorithm.UnionFindSets;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {
    private int count = 0;
    private Map<Integer, Integer> parent = new HashMap<>();

    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            union(stone[0] + 10001, stone[1]);
        }
        return stones.length - this.count;
    }

    public int find(int index) {
        if (!this.parent.containsKey(index)) {
            this.parent.put(index, index);
            this.count++;
        }
        if (index != this.parent.get(index)) {
            this.parent.put(index, find(this.parent.get(index)));
        }
        return this.parent.get(index);
    }

    public void union(int index1, int index2) {
        int rootX = find(index1);
        int rootY = find(index2);
        if (rootX == rootY) {
            return;
        }
        this.parent.put(rootX, rootY);
        count--;
    }
}
