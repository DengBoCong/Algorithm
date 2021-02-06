package com.dbc.algorithm.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0 || speed.length == 0) {
            return 0;
        }

        List<double[]> remain = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            remain.add(new double[]{(double) target - position[i], ((double) target - position[i]) / speed[i]});
        }

        Collections.sort(remain, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) o1[0] - (int) o2[0];
            }
        });

        double max = remain.get(0)[1];
        int result = position.length;
        for (int i = 1; i < position.length; i++) {
            if (remain.get(i)[1] <= max)
                result--;
            max = Math.max(max, remain.get(i)[1]);
        }

        return result;
    }
}
