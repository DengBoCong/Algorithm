package com.dbc.algorithm.ReferOffer;

import java.util.Arrays;

public class NgeTouZiDeDianShuLcof {
    public double[] dicesProbability(int n) {
        double[] res = new double[6];
        Arrays.fill(res, 1. / 6.);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < res.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += res[j] / 6.;
                }
            }
            res = temp;
        }
        return res;
    }
}
