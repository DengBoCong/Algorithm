package com.dbc.algorithm;

import com.dbc.algorithm.Pointer.MinimumWindowSubstring;
import com.dbc.algorithm.Queue.SlidingWindowMaximum;
import com.dbc.algorithm.UnionFindSets.RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        String result = MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}