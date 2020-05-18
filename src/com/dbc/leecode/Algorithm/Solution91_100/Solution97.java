package com.dbc.leecode.Algorithm.Solution91_100;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-13 12:10
 **/
public class Solution97 {
    public int numTreesS1(int n){
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public int numTrees(int n){
        long C = 1;
        for (int i = 0; i < n; i++){
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int)C;
    }
}
