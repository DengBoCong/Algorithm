package com.dbc.algorithm;

import com.dbc.algorithm.Queue.SlidingWindowMaximum;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int[] result = SlidingWindowMaximum.maxSlidingWindowMonotonous(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(result));
    }
}