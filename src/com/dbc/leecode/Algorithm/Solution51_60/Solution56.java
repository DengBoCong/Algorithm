package com.dbc.leecode.Algorithm.Solution51_60;

enum Index{
    GOOD, BAD, UNKNOWN
}

public class Solution56 {
    public boolean canJumpFromPositionS1(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionS1(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJumpS1(int[] nums) {
        return canJumpFromPositionS1(0, nums);
    }

    Index[] memo;

    public boolean canJumpFromPositionS2(int position, int[] nums){
        if(memo[position] != Index.UNKNOWN){
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++){
            if (canJumpFromPositionS2(nextPosition, nums)){
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJumpS2(int[] nums){
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPositionS2(0, nums);
    }

    public boolean canJumpS3(int[] nums){
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    public boolean canJump(int[] nums){
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
