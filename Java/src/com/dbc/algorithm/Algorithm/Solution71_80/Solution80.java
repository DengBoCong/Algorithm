package com.dbc.leecode.Algorithm.Solution71_80;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-08 17:09
 **/
public class Solution80 {
    private boolean[][] marked;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word){
        m = board.length;
        if (m == 0){
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (dfs(i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int start){
        if (start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for (int k = 0; k < 4; k++){
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]){
                    if (dfs(newX, newY, start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
