package com.dbc.algorithm.ReferOffer;

import java.util.HashMap;
import java.util.Map;

public class JiQiRenDeYunDongFanWeiLcof {
    private Map<Integer, Boolean> map = new HashMap<>();

    public int movingCount(int m, int n, int k) {
        dfs(m, n, 0, 0, k);
        return map.size();
    }

    public void dfs(int m, int n, int row, int col, int k) {
        if (row < 0 || row >= m || col < 0 || col >= n || ifCal(row, col, k) || map.getOrDefault(row * n + col, false)) {
            return;
        }
        map.put(row * n + col, true);
        dfs(m, n, row + 1, col, k);
        dfs(m, n, row - 1, col, k);
        dfs(m, n, row, col + 1, k);
        dfs(m, n, row, col - 1, k);
    }

    public boolean ifCal(int first, int second, int k) {
        int total = 0;
        while (first != 0) {
            total += first % 10;
            first /= 10;
        }
        while (second != 0) {
            total += second % 10;
            second /= 10;
        }
        return total > k;
    }
}
