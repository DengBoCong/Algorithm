package com.dbc.leecode.Algorithm.Solution81_90;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-09 09:42
 **/
public class Solution81 {
    public int[] remElement(int[] arr, int index){
        for (int i = index + 1; i < arr.length; i++){
            arr[i - 1] = arr[i];
        }
        return arr;
    }

    public int removeDuplicatesS(int[] nums){
        int i = 1, count = 1, length = nums.length;

        while (i < length){
            if (nums[i] == nums[i - 1]){
                count++;
                if (count > 2){
                    this.remElement(nums, i);
                    i--;
                    length--;
                }
            }else {
                count = 1;
            }
            i++;
        }
        return length;
    }

    public int removeDuplicates(int[] nums){
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]){
                count++;
            }else {
                count = 1;
            }
            if (count <= 2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
