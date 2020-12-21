package com.dbc.algorithm.Algorithm.Solution1_10;

import java.util.*;

/**
 * @program: LeeCode
 * @description:
 * @author: DBC
 * @create: 2019-12-04 11:12
 **/
public class Solution1 {
    /*
     * int nums[] = {2,20,3,4,7,11,15};//{3,3}
     * int target = 9;
     * int result[] = Solution1_10.Test1S1(nums, target);
     * System.out.println(result[0] + " , " + result[1]);
     * */
    public static int[] Test1S1(int[] nums, int target){
        int a = 0;
        int b = nums.length - 1;
        int result[] = new int[2];

        Map<Integer, Integer> resetNums = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            resetNums.put(i, nums[i]);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(resetNums.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        while(a != b){
            int sum = list.get(a).getValue() + list.get(b).getValue();
            if(sum < target) a++;
            else if(sum > target) b--;
            else break;
        }
        result[0] = list.get(a).getKey();
        result[1] = list.get(b).getKey();
        return result;
    }
}
