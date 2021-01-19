package com.dbc.algorithm;

import com.dbc.algorithm.Daily.AccountsMerge;
import com.dbc.algorithm.Daily.MinCostToConnectAllPoints;
import com.dbc.algorithm.Daily.MostStonesRemovedWithSameRowOrColumn;

public class Main {
    public static void main(String args[]) {
        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int result = minCostToConnectAllPoints.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}});
        System.out.println(result);
    }
}