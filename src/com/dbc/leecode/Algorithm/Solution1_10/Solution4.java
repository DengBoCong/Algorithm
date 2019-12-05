package com.dbc.leecode.Algorithm.Solution1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeeCode
 * @description:
 * @author: DBC
 * @create: 2019-12-04 12:18
 **/
public class Solution4 {
    public static double Test4S1(int[] nums1, int[] nums2) {
        //该方法出错

        double sum1 = 0.00; //计算数组一的中位数
        double sum2 = 0.00; //计算数组二的中位数

        if(nums1.length != 0){
            if(nums1.length % 2 == 0){
                int nums1_left = nums1.length / 2 - 1;
                int nums1_right = nums1_left + 1;

                sum1 = (nums1[nums1_left] + nums1[nums1_right]) / 2.00;
            }else sum1 = nums1[nums1.length / 2];
        }

        if(nums2.length != 0){
            if(nums2.length % 2 == 0){
                int nums2_left = nums2.length / 2 - 1;
                int nums2_right = nums2_left + 1;

                sum2 = (nums2[nums2_left] + nums2[nums2_right]) / 2.00;
            }else sum2 = nums2[nums2.length / 2];
        }

        if(nums1.length == 0) return sum2;
        else if(nums2.length == 0) return sum1;
        else return (sum1 + sum2) / 2.00;

    }

    public static double Test4S2(int[] nums1, int[] nums2) {
        List<Integer> array = new ArrayList<>(10);
        //int maxSize = nums1.length > nums2.length ? nums1.length : nums2.length;

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
            /*System.out.println("ss");
            System.out.println(index1);
            System.out.println(index2);*/
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
