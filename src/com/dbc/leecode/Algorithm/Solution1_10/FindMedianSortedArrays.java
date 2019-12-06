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
    private static int kMinNum(int K, int[] nums1, int[] nums2){
        /*int result = 0; //记录结果第K小数
        int firstIndex = K / 2 - 1; //记录第一个数组的当前索引
        int secondIndex = K / 2 - 1; //记录第二个数组的当前索引
        while (K > 0){
            if(K == 1){
                result =  nums1[firstIndex] > nums2[secondIndex] ? nums1[firstIndex] : nums2[secondIndex];
                break;
            }

            if(nums1[firstIndex] > nums2[secondIndex]){
                if(secondIndex == nums2.length - 1){

                }
                firstIndex = K / 2 - 1;
                secondIndex = secondIndex + K / 2;
            }else {
                firstIndex = firstIndex + K / 2;
                secondIndex = K / 2 - 1;
            }

            if(firstIndex > nums1.length - 1) firstIndex = nums1.length - 1;
            if(secondIndex > nums2.length - 1) secondIndex = nums2.length - 1;

            K = K - K / 2;
        }
        return result;*/
        /*int n = nums1.length;
        int m = nums2.length;*/
        return 0;
    }

    public static double Test4S1(int[] nums1, int[] nums2) {
        //K最小数解决方案
        int allSize = nums1.length + nums2.length;
        if(allSize % 2 == 0){
            int sum = kMinNum(allSize / 2 - 1, nums1, nums2) + kMinNum(allSize / 2, nums1, nums2);
            return sum / 2.00;
        }else{
            return kMinNum(allSize / 2, nums1, nums2);
        }
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
