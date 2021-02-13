package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.Pointer.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        List<Integer> result = FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(result.toString());
    }
}