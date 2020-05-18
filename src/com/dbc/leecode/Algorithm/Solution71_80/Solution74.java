package com.dbc.leecode.Algorithm.Solution71_80;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-06 12:51
 **/
public class Solution74 {
    public void setZeroesS1(int[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroesS2(int[][] matrix){
        int MODIFIED = -1000000;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (matrix[r][c] == 0){
                    for (int k = 0; k < C; k++){
                        if(matrix[r][k] != 0){
                            matrix[r][k] = MODIFIED;
                        }
                    }
                    for (int k = 0; k < R; k++){
                        if (matrix[k][c] != 0)
                            matrix[k][c] = MODIFIED;
                    }
                }
            }
        }

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (matrix[r][c] == MODIFIED){
                    matrix[r][c] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix){
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++){
            if (matrix[i][0] == 0){
                isCol = true;
            }

            for (int j = 1; j < C; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < R; i++){
            for (int j = 1; j < C; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for (int j = 0; j < C; j++){
                matrix[0][j] = 0;
            }
        }

        if(isCol){
            for (int i = 0; i < R; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
