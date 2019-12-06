package com.dbc.leecode.Algorithm.Solution1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeeCode
 * @description:给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * @author: DBC
 * @create: 2019-12-04 12:18
 **/
public class FindMedianSortedArrays {
    private static int kMinNum(int start1, int end1, int[] nums1, int start2, int end2, int[] nums2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if(len1 > len2) return kMinNum(start2, end2, nums2, start1, end1, nums1, k);
        if(len1 == 0) return nums2[start2 + k - 1];
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if(nums1[i] > nums2[j]){
            return kMinNum(start1, end1, nums1, j + 1, end2, nums2,k - (j - start2 + 1));
        }else{
            return kMinNum(i + 1, end1, nums1, start2, end2, nums2, k - (i - start1 + 1));
        }
    }

    public static double Test4S1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (kMinNum(0, n - 1, nums1, 0, m - 1, nums2, left) + kMinNum(0, n - 1, nums1, 0, m - 1, nums2, right)) * 0.5;
    }

    public static double Test4S2(int[] nums1, int[] nums2) {
        List<Integer> array = new ArrayList<>(10);

        int size1 = nums1.length;
        int size2 = nums2.length;
        int index1 = 0;
        int index2 = 0;

        while(index1 != size1 || index2 != size2){
            if(index1 == size1){
                for (int i = index2; i < size2; i++){
                    array.add(nums2[i]);
                }
                break;
            }else if (index2 == size2){
                for (int i = index1; i < size1; i++){
                    array.add(nums1[i]);
                }
                break;
            }
            array.add(nums1[index1] < nums2[index2] ? nums1[index1] : nums2[index2]);
            if(nums1[index1] < nums2[index2]){
                if(index1 < size1)
                    index1++;
            }
            else{
                if(index2 < size2) index2++;
            }
        }

        int sizeArray = array.size() / 2;
        if(array.size() % 2 == 0) return (array.get(sizeArray - 1) + array.get(sizeArray)) / 2.00;
        else return array.get(sizeArray);
    }

    public static double Test4S3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return Test4S3(nums2,nums1); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && nums2[j-1] > nums1[i]){ // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && nums1[i-1] > nums2[j]) { // i 需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

}
