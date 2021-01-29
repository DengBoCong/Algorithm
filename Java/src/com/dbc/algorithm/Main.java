package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = PathWithMinimumEffort.minimumEffortPathDijkstra(new int[][]{{1,2,2},{3,8,2},{5,3,5}});
        System.out.println(result);
    }
}