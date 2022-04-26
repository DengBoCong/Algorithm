package com.dbc;

import java.util.Arrays;

public class ProjectionAreaOf3dShapes {
    public int projectionArea(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];
        Arrays.fill(rowMax, 0);
        Arrays.fill(colMax, 0);
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res++;
                    rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                    colMax[j] = Math.max(colMax[j], grid[i][j]);
                }
            }
        }
        for (int val : rowMax) res += val;
        for (int val : colMax) res += val;
        return res;
    }
}
