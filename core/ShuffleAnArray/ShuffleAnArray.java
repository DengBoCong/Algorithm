package com.dbc.code;

import java.util.Random;

public class ShuffleAnArray {
    private int[] nums = null;
    private int[] shuffleNums = null;
    private final Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.shuffleNums = this.nums.clone();
    }

    public int[] reset() {
        this.shuffleNums = this.nums.clone();
        return this.shuffleNums;
    }

    public int[] shuffle() {
        for (int i = 0; i < this.nums.length; i++) {
            int point = random.nextInt(this.nums.length - i) + i;
            int temp = this.shuffleNums[point];
            this.shuffleNums[point] = this.shuffleNums[i];
            this.shuffleNums[i] = temp;
        }
        return this.shuffleNums;
    }
}
