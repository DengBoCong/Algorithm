package com.dbc.algorithm.DynamicProgramming;

public class VolumeOfHistogramLcci {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = 0;
        right[0] = 0;
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[i] = Math.max(right[i - 1], height[height.length - i]);
        }
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left[i], right[height.length - i - 1]);
            if (height[i] < min) {
                total += min - height[i];
            }
        }
        return total;
    }

    public int trap1(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, total = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                total += leftMax - height[left];
                left++;
            } else {
                total += rightMax - height[right];
                right--;
            }
        }
        return total;
    }
}
