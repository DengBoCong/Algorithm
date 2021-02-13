package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.Pointer.*;
import com.dbc.algorithm.Sort.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = KthLargestElementInAnArray.findKthLargestHeap(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(result);
    }
}