package com.dbc.algorithm;

import com.dbc.algorithm.Daily.*;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        int result = LongestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{1,3,5,4,7});
        System.out.println(result);
    }
}