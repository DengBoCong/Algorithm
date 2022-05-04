package com.dbc;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public int lastRemaining(int n, int m) {
        int winner = 0;
        for (int i = 1; i < n; i++) winner = (winner + m) % (i + 1);
        return winner;
    }
}
