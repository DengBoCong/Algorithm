package com.dbc.algorithm.Array;

public class MedianOfTwoSortedArrays {
    public static int getKthElement(int[] nums1, int[] nums2, int k, int m, int n) {
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == m) {
                return nums1[index2 + k - 1];
            }
            if (index2 == n) {
                return nums2[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int newIndex1 = Math.min(index1 + k / 2 - 1, m - 1);
            int newIndex2 = Math.min(index2 + k / 2 - 1, n - 1);
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = n + m;
        if (total % 2 == 0) {
            return (double) (getKthElement(nums1, nums2, total / 2, m, n) + getKthElement(nums1, nums2, total / 2 + 1, m, n)) / 2.0;
        } else {
            return getKthElement(nums1, nums2, total / 2 + 1, m, n);
        }
    }
}
