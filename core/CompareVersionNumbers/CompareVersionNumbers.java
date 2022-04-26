package com.dbc;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int val1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int val2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (val1 != val2) return val1 < val2 ? -1 : 1;
        }
        return 0;
    }
}
