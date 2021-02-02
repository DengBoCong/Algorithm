package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.Pointer.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = MaxConsecutiveOnesIII.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        System.out.println(result);
    }
}