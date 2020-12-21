package com.dbc.algorithm;

import com.dbc.algorithm.Daily.MinCostClimbingStairs;

import java.text.ParseException;

public class Main {
    public static String res = "";

    public static void main(String[] args) throws ParseException {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(MinCostClimbingStairs.minCostClimbingStairs(cost));
    }
}