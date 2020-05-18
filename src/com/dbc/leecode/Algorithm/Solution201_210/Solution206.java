package com.dbc.leecode.Algorithm.Solution201_210;

import java.util.PriorityQueue;
import java.util.Random;

public class Solution206 {
    public int findKthLargestS1(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) return;
        int mid = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] < mid) r--;
            if (l < r) nums[l++] = nums[r];
            while (l < r && nums[l] > mid) l++;
            if (l < r) nums[r--] = nums[l];
        }
        nums[l] = mid;
        if (l == k) return;
        if (l < k) quickSort(nums, l + 1, right, k);
        else quickSort(nums, left, l - 1, k);
    }

    int [] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }


    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        swap(pivot_index, right);
        int store_index = left;

        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        swap(store_index, right);

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
        if (left == right)
            return this.nums[left];
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index);

        if (k_smallest == pivot_index)
            return this.nums[k_smallest];
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index - 1, k_smallest);
        return quickselect(pivot_index + 1, right, k_smallest);
    }

    public int findKthLargestS2(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickselect(0, size - 1, size - k);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }
}
