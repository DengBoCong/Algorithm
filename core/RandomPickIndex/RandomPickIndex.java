package com.dbc;

import java.util.*;

public class RandomPickIndex {
    private final Map<Integer, List<Integer>> remain = new HashMap<>();
    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!this.remain.containsKey(nums[i])) this.remain.put(nums[i], new ArrayList<>());
            this.remain.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        Random random = new Random();
        return this.remain.get(target).get(random.nextInt(this.remain.get(target).size()));
    }
}
