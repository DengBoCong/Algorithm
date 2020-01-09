package com.dbc.leecode.Algorithm.Solution51_60;


import java.util.ArrayList;
import java.util.List;

public class Solution52 {
    int rows[];
    int hills[];
    int dales[];
    int n;

    List<List<String>> output = new ArrayList<>();
    int queens[];

    public boolean isNotUnderAttack(int row, int col){
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col){
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;
        dales[row + col] = 1;
    }

    public void removeQueen(int row, int col){
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution(){
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int col = queens[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < col; j++) stringBuilder.append(".");
            stringBuilder.append("Q");
            for (int j = 0; j < n - col - 1; j++) stringBuilder.append(".");
            solution.add(stringBuilder.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) addSolution();
                else backtrack(row + 1);
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }
}
