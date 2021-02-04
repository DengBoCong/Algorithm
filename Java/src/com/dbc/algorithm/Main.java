package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.Pointer.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int[] result = RestoreTheArrayFromAdjacentPairs.restoreArray(new int[][]{{-3,-9},{-5,3},{2,-9},{6,-3},{6,1},{5,3},{8,5},{-5,1},{7,2}});
        System.out.println(Arrays.toString(result));
    }
}