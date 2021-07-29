package com.dbc.leecode.Algorithm.Solution231_240;

public class Solution238 {
    class Ugly {
        public int[] nums = new int[1690];
        Ugly(){
            nums[0] = 1;
            int p1 = 0, p2 = 0, p3 = 0;
            for (int i = 1; i < 1690; i++) {
                nums[i] = Math.min(nums[p1] * 2, Math.min(nums[p2] * 3, nums[p3] * 5));

                if (nums[i] == nums[p1] * 2) p1++;
                if (nums[i] == nums[p2] * 3) p2++;
                if (nums[i] == nums[p3] * 5) p3++;
            }
        }
    }

    public int nthUglyNumber(int n) {
        Ugly ugly = new Ugly();
        return ugly.nums[n - 1];
    }
}
