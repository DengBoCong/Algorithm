package com.dbc.algorithm;

import com.dbc.algorithm.Daily.DecodeXoredArray;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int[] profit = DecodeXoredArray.decode(new int[]{1,2,3}, 1);
        System.out.println(Arrays.toString(profit));
    }
}