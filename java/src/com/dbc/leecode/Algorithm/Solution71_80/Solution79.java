package com.dbc.leecode.Algorithm.Solution71_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-08 16:16
 **/
public class Solution79 {
    public static List<List<Integer>> binaryBit(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++){
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        res.add(subset);
        inOrder(nums, 0, subset, res);
        return res;
    }

    public void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res){
        if(i >= nums.length) return;
        subset = new ArrayList<>(subset);
        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
    }
}
