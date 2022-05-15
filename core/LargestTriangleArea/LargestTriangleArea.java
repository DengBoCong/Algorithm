package com.dbc;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = 0; j < points.length - 1; j++) {
                for (int k = 0; k < points.length; k++) {
                    float value = points[i][0]*points[j][1]+points[j][0]*points[k][1]+points[k][0]*points[i][1]-points[j][0]*points[i][1]-points[j][1]*points[k][0]-points[k][1]*points[i][0];
                    res = Math.max(res, Math.abs(value) / 2.);
                }
            }
        }
        return res;
    }
}
