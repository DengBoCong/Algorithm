package com.dbc.algorithm.ReferOffer;

public class ShuZuZhongShuZiChuXianDeCiShuIILcof {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            if (counts[i] % 3 == 1) {
                res += 1;
            }
        }
        return res;
    }
}
