package com.dbc.leecode.Algorithm.Solution11_20;

public class Solution12 {
    public static int maxAreaS1(int[] height) {
        int length = height.length;
        int result = 0;
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                int cap = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
                result = result < cap ? cap : result;
            }
        }
        return result;
    }

    public static int maxAreaS2(int[] height){
        int length = height.length;
        int result = 0;
        int left = 0;
        int right = length - 1;

        while (left < right){
            int cap = (height[left] > height[right] ? height[right] : height[left]) * (right - left);
            result = result < cap ? cap : result;
            if(height[left] > height[right]){
                right --;
            }else left++;
        }
        return result;
    }
}
