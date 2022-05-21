package com.dbc;

import java.util.Random;

public class NRepeatedElementInSize2nArray {
    public int repeatedNTimes(int[] nums) {
        Random random = new Random();
        while (true) {
            int x = random.nextInt(nums.length);
            int y = random.nextInt(nums.length);
            if (x != y && nums[x] == nums[y]) return nums[x];
        }
    }
}
