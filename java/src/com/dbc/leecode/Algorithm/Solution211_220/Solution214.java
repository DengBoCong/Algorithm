package com.dbc.leecode.Algorithm.Solution211_220;

public class Solution214 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length1 = C - A;
        int width1 = D - B;
        int area1 = length1 * width1;

        int length2 = G - E;
        int width2 = H - F;
        int area2 = length2 * width2;

        if (E >= C || G <= A || F >= D || H <= B) {
            return area1 + area2;
        }

        int x1 = Math.min(C, G);
        int x2 = Math.max(E, A);
        int length3 = x1 - x2;

        int y1 = Math.min(D, H);
        int y2 = Math.max(F, B);
        int width3 = y1 - y2;
        int area3 = length3 * width3;

        return area1 + area2 - area3;
    }
}
