package com.dbc.leecode.Algorithm.Solution71_80;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-08 10:34
 **/
public class Solution78 {
    private List<List<Integer>> ouput = new LinkedList<>();
    private int n;
    private int k;

    public void backtrack(int first, LinkedList<Integer> curr){
        if (curr.size() == k){
            ouput.add(new LinkedList<>(curr));
            return;
        }

        for (int i = first; i < n + 1; i++){
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combineS1(int n, int k){
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return ouput;
    }

    public List<List<Integer>> combineS2(int n, int k){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; i++){
            temp.add(0);
        }

        int i = 0;
        while (i >= 0){
            temp.set(i, temp.get(i) + 1);
            if (temp.get(i) > n){
                i--;
            }else if (i == k - 1){
                ans.add(new ArrayList<>(temp));
            }else{
                i++;
                temp.set(i, temp.get(i - 1));
            }
        }
        return ans;
    }

    public List<List<Integer>> combine(int n, int k){
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i < k + 1; i++)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<>();
        int j = 0;
        while (j < k){
            output.add(new LinkedList<>(nums.subList(0, k)));
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }
}
