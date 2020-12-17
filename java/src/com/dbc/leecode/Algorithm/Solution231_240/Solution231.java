package com.dbc.leecode.Algorithm.Solution231_240;

public class Solution231 {
    public boolean searchMatrixS1(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        for (int i = 0; i < matrix.length; i++) {
            if (binary(matrix[i], target)) return true;
        }
        return false;
    }

    public boolean binary(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (right - left) / 2;
        while (left <= right) {
            if (target == nums[mid]) return true;
            else if (target < nums[mid]) right = mid;
            else left = mid;
            mid = (right - left) / 2;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >=0) {
            if (target == matrix[i][j]) return true;
            else if (target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }
}
