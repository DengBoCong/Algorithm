package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = SwimInRisingWater.swimInWaterDijkstra(new int[][]{{0,2},{1,3}});
        System.out.println(result);
    }
}