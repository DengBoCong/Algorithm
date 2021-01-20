package com.dbc.algorithm;

import com.dbc.algorithm.Daily.BinaryPrefixDivisibleBy5;
import com.dbc.algorithm.Daily.MaximumProductOfThreeNumbers;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<Boolean> result = BinaryPrefixDivisibleBy5.prefixesDivBy5(new int[]{0,1,1});
        System.out.println(result);
    }
}