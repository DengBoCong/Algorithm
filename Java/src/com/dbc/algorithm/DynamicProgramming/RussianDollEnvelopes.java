package com.dbc.algorithm.DynamicProgramming;

import java.util.*;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int num = o1[0] - o2[0];
                if (num == 0)
                    return o2[1] - o1[1];
                else return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < envelopes.length; i++) {
            System.out.println(Arrays.toString(envelopes[i]));
        }

        List<Integer> d = new ArrayList<>();
        for (int[] envelope : envelopes) {
            if (d.isEmpty() || d.get(d.size() - 1) < envelope[1]) {
                d.add(envelope[1]);
            }else {
                int left = 0, right = d.size() - 1;
                int loc = left;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (d.get(mid) >= envelope[1]) {
                        loc = mid;
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
                d.set(loc, envelope[1]);
            }
        }
        return d.size();
    }
}
