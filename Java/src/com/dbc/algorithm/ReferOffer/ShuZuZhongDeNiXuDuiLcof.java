package com.dbc.algorithm.ReferOffer;

public class ShuZuZhongDeNiXuDuiLcof {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    public int mergeSort(int left, int right, int[] nums) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int res = mergeSort(left, mid, nums) + mergeSort(mid + 1, right, nums);
        int[] temp = new int[right - left + 1];
        for (int i = left; i < right + 1; i++) {
            temp[i - left] = nums[i];
        }
        int point1 = left, point2 = mid + 1;
        for (int i = left; i < right + 1; i++) {
            if (point1 == mid + 1) {
                nums[i] = temp[point2 - left];
                point2++;
            } else if (point2 == right + 1 || temp[point1 - left] <= temp[point2 - left]) {
                nums[i] = temp[point1 - left];
                point1++;
            } else {
                nums[i] = temp[point2 - left];
                point2++;
                res += mid - point1 + 1;
            }
        }
        return res;

    }
}
