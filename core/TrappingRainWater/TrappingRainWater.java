package com.dbc;

import java.util.Arrays;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftDp = new int[height.length];
        Arrays.fill(leftDp, 0);
        int[] rightDp = new int[height.length];
        Arrays.fill(rightDp, 0);
        for (int i = 1; i < height.length; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (leftDp[i] > height[i] && rightDp[i] > height[i]) {
                res += Math.min(leftDp[i], rightDp[i]) - height[i];
            }
        }
        return res;
    }
}
