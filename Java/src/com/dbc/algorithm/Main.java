package com.dbc.algorithm;
import com.dbc.algorithm.Daily.RedundantConnectionII;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int[] profit = RedundantConnectionII.findRedundantDirectedConnection(new int[][]{{1,2}, {2,3}, {3,4}, {4,1}, {1,5}});
        System.out.println(Arrays.toString(profit));
    }
}