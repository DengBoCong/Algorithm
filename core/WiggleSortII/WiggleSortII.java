package com.dbc.code;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int x = (nums.length + 1) / 2 - 1;
        int k = nums.length - 1;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = arr[x];
            if (i + 1 < nums.length) {
                nums[i + 1] = arr[k];
            }
            x--;
            k--;
        }
    }
}
