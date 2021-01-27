package com.dbc.algorithm;

import com.dbc.algorithm.Queue.SlidingWindowMaximum;
import com.dbc.algorithm.UnionFindSets.RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable.maxNumEdgesToRemove(4, new int[][]{{3,2,3},{1,1,2},{2,3,4}});
        System.out.println(result);
    }
}