package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.Pointer.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = MaximumPointsYouCanObtainFromCards.maxScoreSlid(new int[]{1,2,3,4,5,6,1}, 3);
        System.out.println(result);
    }
}