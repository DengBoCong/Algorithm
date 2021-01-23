package com.dbc.algorithm;

import com.dbc.algorithm.Daily.*;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        int result = NumberOfOperationsToMakeNetworkConnected.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}});
        System.out.println(result);
    }
}