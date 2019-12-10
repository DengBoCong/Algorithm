package com.dbc.leecode.Algorithm.Solution1_10;

/**
 * @program: AlgorithmProject
 * @description: Z字形变换
 * @author: DBC
 * @create: 2019-12-08 22:39
 **/
public class Solution7 {
    public static String convertS1(String s, int numRows) {
        boolean flag = true;
        int layer = 1; //标记现在进入第几层
        int length = s.length();
        int nums[] = new int[length];

        if(s.equals("")) return "";
        if(numRows == 1) return s;

        for (int i = 0; i < length; i++){
            if(flag){
                nums[i] = layer++;
                if(layer == (numRows + 1)){
                    flag = false;
                    layer -= 2;
                }
            }else {
                nums[i] = layer--;
                if(layer == 0){
                    flag = true;
                    layer += 2;
                }
            }
        }

        String result = "";
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < length; j++){
                if(nums[j] == (i + 1)) result += s.charAt(j);
            }
        }

        return result;
    }
}
