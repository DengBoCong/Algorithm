package com.dbc.algorithm.ReferOffer;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(0, postorder.length - 1, postorder);
    }

    public boolean dfs(int i, int j, int[] postorder) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && dfs(i, m - 1, postorder) && dfs(m, j - 1, postorder);
    }
}
