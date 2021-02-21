package com.dbc.algorithm.Pointer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static int longestSubarrayTreeMap(int[] nums, int limit) {
        int left = 0, right = 0, result = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.lastKey() - map.firstKey() > limit) {
                if (map.get(nums[left]) > 1)
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                else
                    map.remove(nums[left]);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static int longestSubarrayQueue(int[] nums, int limit) {
        int left = 0, right = 0, result = 0;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        while (right < nums.length) {
            while (!max.isEmpty() && max.getLast() < nums[right]) {
                max.pollLast();
            }
            while (!min.isEmpty() && min.getLast() > nums[right]) {
                min.pollLast();
            }
            max.offerLast(nums[right]);
            min.offerLast(nums[right]);

            if (max.getFirst() - min.getFirst() > limit) {
                if (max.getFirst() == nums[left]) {
                    max.removeFirst();
                }
                if (min.getFirst() == nums[left]) {
                    min.removeFirst();
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
