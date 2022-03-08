package com.dbc;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] left_pos = new int[s.length()];
        int[] right_pos = new int[s.length()];
        int[] prefix_sum = new int[s.length()];
        int count = 0, flag = -1, prefix_pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag != -1 && s.charAt(i) == '*') {
                count++;
            }
            if (s.charAt(i) == '|') {
                flag = count;
                prefix_pos = i;
            }
            prefix_sum[i] = flag;
            left_pos[i] = prefix_pos;
        }

        prefix_pos = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                prefix_pos = i;
            }
            right_pos[i] = prefix_pos;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            res[i] = right_pos[left] < left_pos[right] ? prefix_sum[left_pos[right]] - prefix_sum[right_pos[left]] : 0;
        }

        return res;
    }
}
