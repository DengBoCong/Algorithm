package com.dbc.leecode.Algorithm.Solution71_80;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-07 11:17
 **/
public class Solution75 {
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right){
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
