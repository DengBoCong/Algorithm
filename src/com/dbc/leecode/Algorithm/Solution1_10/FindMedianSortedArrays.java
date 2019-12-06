package com.dbc.leecode.Algorithm.Solution1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeeCode
 * @description:
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

}
