package com.dbc;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int[] scores = new int[ops.length];
        scores[0] = Integer.parseInt(ops[0]);
        int res = scores[0], cur = 1;
        for (int i = 1; i < ops.length; i++) {
            if (ops[i].equals("+")) scores[cur] = scores[cur - 1] + scores[cur - 2];
            else if (ops[i].equals("D")) scores[cur] = scores[cur - 1] * 2;
            else if (ops[i].equals("C")) {
                cur--;
                res -= scores[cur];
                continue;
            } else {
                scores[cur] = Integer.parseInt(ops[i]);
            }
            res += scores[cur];
            cur++;
        }
        return res;
    }
}
