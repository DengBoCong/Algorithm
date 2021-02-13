package com.dbc.algorithm.Sort;

public class KthLargestElementInAnArray {
    public static int quickFind(int[] nums, int left, int right, int k) {
        int l = left, r = right;
        int mid = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= mid) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] <= mid) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        nums[l] = mid;
        if (l + 1 == k) {
            return mid;
        } else if (l + 1 > k) {
            return quickFind(nums, left, l - 1, k);
        } else {
            return quickFind(nums, l + 1, right, k);
        }
    }

    public static int findKthLargestQuickFind(int[] nums, int k) {
        return quickFind(nums, 0, nums.length - 1, nums.length + 1 - k);
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void heapify(int[] nums, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && nums[largest] < nums[left]) {
            largest = left;
        }
        if (right < length && nums[largest] < nums[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest, length);
        }
    }

    public static int findKthLargestHeap(int[] nums, int k) {
        for (int i = Math.floorDiv(nums.length, 2); i > 0; i--) {
            heapify(nums, i - 1, nums.length);
        }

        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, nums.length - 1 - i);
            heapify(nums, 0, nums.length - 1 - i);
        }
        return nums[0];
    }
}
