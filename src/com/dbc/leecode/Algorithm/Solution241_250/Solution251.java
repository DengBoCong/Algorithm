package com.dbc.leecode.Algorithm.Solution241_250;

public class Solution251 {
    public int hIndexS1(int[] citations) {
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) i++;
        return i;
    }

    public int hIndex(int[] citations) {
        int i = citations.length / 2;
        int left = 0;
        int right = citations.length - 1;

        while (i < citations.length && i >= 0) {
            if (citations[citations.length - 1 - i] > i) {
                right = i;
                i = (i - left) / 2;
            }
            if (citations[citations.length - 1 - i] > i) {
                left = i;
                i = (right - i) / 2;
            }
        }
        return i;
    }
}
