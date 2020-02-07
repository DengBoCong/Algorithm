package com.dbc.leecode.Algorithm.Solution71_80;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-07 11:37
 **/
public class Solution76 {
    public void sortColors(int[] nums){
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2){
            if (nums[curr] == 0){
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }else if (nums[curr] == 2){
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }else {
                curr++;
            }
        }
    }
}
