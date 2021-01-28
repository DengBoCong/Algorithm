package com.dbc.algorithm;

import com.dbc.algorithm.Array.FindPivotIndex;
import com.dbc.algorithm.Pointer.MinimumWindowSubstring;
import com.dbc.algorithm.Queue.SlidingWindowMaximum;
import com.dbc.algorithm.UnionFindSets.RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = FindPivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(result);
    }
}