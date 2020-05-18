package com.dbc.leecode.Algorithm.Solution131_140;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-26 17:09
 **/
public class Solution135 {
    public int canCompleteCircuit(int[] gas, int[] cost){
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0){
                starting_station = i + 1;
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }
}
