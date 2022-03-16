package com.dbc;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int col = i;
            for (int[] row : grid) {
                int value = row[col];
                col += value;
                if (col < 0 || col >= grid[0].length || row[col - value] != row[col]) {
                    col = -1;
                    break;
                }
            }
            res[i] = col;
        }
        return res;
    }
}
