package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class CountNodesWithTheHighestScore {
    private long maxScores = 0;
    private int count = 0;
    private List<List<Integer>> children = null;
    private int length = 0;

    private int dfs(int node) {
        long scores = 1;
        int size = this.length - 1;
        for (int i = 0; i < this.children.get(node).size(); i++) {
            int sz = dfs(this.children.get(node).get(i));
            scores *= sz;
            size -= sz;
        }
        if (node != 0) {
            scores *= size;
        }
        if (scores > this.maxScores) {
            this.maxScores = scores;
            this.count = 1;
        } else if (scores == this.maxScores) {
            this.count++;
        }
        return this.length - size;
    }

    public int countHighestScoreNodes(int[] parents) {
        this.length = parents.length;
        this.children = new ArrayList<>();
        for (int i = 0; i < parents.length; i++) {
            this.children.add(new ArrayList<>());
        }
        for (int i = 1; i < parents.length; i++) {
            this.children.get(parents[i]).add(i);
        }

        dfs(0);
        return this.count;
    }
}
