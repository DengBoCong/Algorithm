package com.dbc.leecode.Algorithm.Solution131_140;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-27 11:52
 **/
public class Solution138 {
    public int singleNumberS1(int[] nums){
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++){
                if ((nums[j] >>> i & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }

    public int singliNumber(int[] nums){
        int seenOnce = 0, senTwice = 0;
        for (int num : nums){
            seenOnce = ~senTwice & (seenOnce ^ num);
            senTwice = ~seenOnce & (senTwice ^ num);
        }
        return seenOnce;
    }
}
