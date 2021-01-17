package com.dbc.algorithm;

import com.dbc.algorithm.Daily.CheckIfItIsAStraightLine;

public class Main {
    public static void main(String args[]) {
        boolean profit = CheckIfItIsAStraightLine.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}});
        System.out.println(profit);
    }
}