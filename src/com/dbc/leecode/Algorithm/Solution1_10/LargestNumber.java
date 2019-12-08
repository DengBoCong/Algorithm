package com.dbc.leecode.Algorithm.Solution1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2019-12-07 22:15
 **/
public class LargestNumber {
    public static String largestNumberS1(int[] nums) {
        int length = nums.length;
        Integer[] numVote = new Integer[length];
        for (int i = 0; i < length; i++) {
            numVote[i] = nums[i];
        }
        Arrays.sort(numVote, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                String temp1 = n1 + "" + n2;
                String temp2 = n2 + "" + n1;
                return temp2.compareTo(temp1);
            }
        });
        String result = "";
        for (int i = 0; i < length; i++) {
            result = result +numVote[i];
        }
        if(result.charAt(0) == '0') return "0";
        else return result;

        /*List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            while(nums[i] >= 0){
                list.add(nums[i] % 10);
                if(nums[i] < 10) break;
                nums[i] = nums[i] / 10;
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        return list.toString();*/
    }
}
