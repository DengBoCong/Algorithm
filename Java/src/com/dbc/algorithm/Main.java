package com.dbc.algorithm;

import com.dbc.algorithm.Daily.AccountsMerge;
import com.dbc.algorithm.Daily.MostStonesRemovedWithSameRowOrColumn;

public class Main {
    public static void main(String args[]) {
        MostStonesRemovedWithSameRowOrColumn mostStonesRemovedWithSameRowOrColumn = new MostStonesRemovedWithSameRowOrColumn();
        int result = mostStonesRemovedWithSameRowOrColumn.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}});
        System.out.println(result);
    }
}