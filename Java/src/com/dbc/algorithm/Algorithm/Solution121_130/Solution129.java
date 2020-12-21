package com.dbc.leecode.Algorithm.Solution121_130;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-24 10:38
 **/
public class Solution129 {
    public int longestConsecutive(int[] nums){
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums){
            num_set.add(num);
        }

        int longestStreak = 0;
        for (int num : num_set){
            if (!num_set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
