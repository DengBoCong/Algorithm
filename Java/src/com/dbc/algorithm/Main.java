package com.dbc.algorithm;

import com.dbc.algorithm.Daily.*;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        int result = RegionsCutBySlashes.regionsBySlashes(new String[]{" /","  "});
        System.out.println(result);
    }
}