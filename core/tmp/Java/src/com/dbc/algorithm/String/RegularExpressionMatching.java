package com.dbc.algorithm.String;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matchs(i, j - 1, s, p)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matchs(i, j, s, p)) {
                        f[i][j] = f[i][j]|| f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matchs(int i, int j, String s, String p) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
