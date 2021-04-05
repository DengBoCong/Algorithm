package com.dbc.algorithm.Array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[point] = nums2[n - 1];
                n--;
            } else {
                nums1[point] = nums1[m - 1];
                m--;
            }
            point--;
        }
        if (m == 0 && n != 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
