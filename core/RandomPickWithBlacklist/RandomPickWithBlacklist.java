package com.dbc.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickWithBlacklist {
    private final Map<Integer, Integer> map = new HashMap<>();
    private final Random random = new Random();
    private int length = 0;

    public RandomPickWithBlacklist(int n, int[] blacklist) {
        HashMap<Integer, Integer> remain = new HashMap<>();
        for (int black : blacklist) remain.put(black, 0);
        this.length = n - blacklist.length;
        for (int black : blacklist) {
            if (black < this.length) {
                while (remain.containsKey(n - 1)) n--;
                this.map.put(black, n - 1);
                n--;
            }
        }
    }

    public int pick() {
        int point = random.nextInt(this.length);
        return this.map.getOrDefault(point, point);
    }
}
