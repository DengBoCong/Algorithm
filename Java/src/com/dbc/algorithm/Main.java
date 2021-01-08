package com.dbc.algorithm;

import com.dbc.algorithm.Daily.FindCircleNum;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int count = FindCircleNum.findCircleNum_bfs(new int[][]{{1,1,1},{1,1,1},{1,1,1}});
        System.out.println(count);
    }
}