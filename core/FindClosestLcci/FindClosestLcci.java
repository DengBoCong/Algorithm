package com.dbc;

public class FindClosestLcci {
    public int findClosest(String[] words, String word1, String word2) {
        int res = -1, point1 = -1, point2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) point1 = i;
            if (word2.equals(words[i])) point2 = i;
            if (point1 != -1 && point2 != -1) res = res == -1 ? Math.abs(point1 - point2) : Math.min(res, Math.abs(point1 - point2));
        }
        return res;
    }
}
