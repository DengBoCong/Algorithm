package com.dbc.algorithm.BitOperation;

public class DecodeXoredArray {
    public static int[] decode(int[] encoded, int first) {
        int[] decode = new int[encoded.length + 1];
        decode[0] = first;
        for (int i = 1; i < encoded.length + 1; i++) {
            decode[i] = decode[i - 1] ^ encoded[i - 1];
        }

        return decode;
    }
}
