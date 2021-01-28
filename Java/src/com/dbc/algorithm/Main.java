package com.dbc.algorithm;

import com.dbc.algorithm.Array.ContinuousSubarraySum;
import com.dbc.algorithm.Array.SubarraySumEqualsK;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        boolean result = ContinuousSubarraySum.checkSubarraySumPrefix(new int[]{0,0}, 0);
        System.out.println(result);
    }
}