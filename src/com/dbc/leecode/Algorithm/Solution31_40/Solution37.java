package com.dbc.leecode.Algorithm.Solution31_40;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution37 {
    public boolean isValidSudokuS1(char[][] board) {
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i ++){
            // hori, veti, sqre分别表示行、列、小宫
            int hori = 0, veti = 0, sqre = 0;
            for(int j = 0; j < 9; j ++){
                // 由于传入为char，需要转换为int，减48
                int h = board[i][j] - 48;
                int v = board[j][i] - 48;
                int s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;
                // "."的ASCII码为46，故小于0代表着当前符号位"."，不用讨论
                if(h > 0){
                    hori = sodokuer(h, hori);
                }
                if(v > 0){
                    veti = sodokuer(v, veti);
                }
                if(s > 0){
                    sqre = sodokuer(s, sqre);
                }
                if(hori == -1 || veti == -1 || sqre == -1){
                    return false;
                }
            }
        }
        return true;
    }

    private int sodokuer(int n, int val){
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
    }
}
