package com.dbc;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid != 0 && mid != arr.length - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}
