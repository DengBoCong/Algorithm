package com.dbc;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximumNumberOfAchievableTransferRequests {
    private int[] remain = new int[20];
    private int maxScores = 0;
    private int[][] requests;

    private boolean isBalance() {
        for (int item : this.remain) {
            if (item > 0) return false;
        }
        return true;
    }

    private void dfs(Stack<Integer> reqList, int start) {
        for (int i = start; i < this.requests.length; i++) {
            reqList.push(i);
            remain[this.requests[i][0]]--;
            remain[this.requests[i][1]]++;
            if (isBalance()) {
                this.maxScores = Math.max(this.maxScores, reqList.size());
            }
            dfs(reqList, i + 1);
            reqList.pop();
            remain[this.requests[i][0]]++;
            remain[this.requests[i][1]]--;
        }
    }

    public int maximumRequests(int n, int[][] requests) {
        this.requests = requests;
        dfs(new Stack<>(), 0);
        return this.maxScores;
    }
}
