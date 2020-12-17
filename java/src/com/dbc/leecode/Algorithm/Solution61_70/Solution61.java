package com.dbc.leecode.Algorithm.Solution61_70;

public class Solution61 {
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        return recursive(n, factorial(n - 1), k, visited);
    }

    private String recursive(int n, int f, int k, boolean[]visited){
        int offset = k%f;
        int groupIndex = k/f + (offset > 0 ? 1 : 0);
        int i = 0;
        for(; i < visited.length && groupIndex > 0; i++){
            if(!visited[i]){
                groupIndex--;
            }
        }
        visited[i-1] = true;
        if(n - 1 > 0){
            return String.valueOf(i) + recursive(n-1, f/(n - 1), offset == 0 ? f : offset, visited);
        }else{
            return String.valueOf(i);
        }
    }

    private int factorial(int n){
        int res = 1;
        for(int i = n; i > 1; i--){
            res *= i;
        }
        return res;
    }
}
