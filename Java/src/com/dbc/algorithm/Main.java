package com.dbc.algorithm;
import com.dbc.algorithm.Daily.RedundantConnection;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int[] profit = RedundantConnection.findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}});
        System.out.println(Arrays.toString(profit));
    }
}