package com.dbc.algorithm.Array;

public class MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int[] front = new int[cardPoints.length];
        int[] back = new int[cardPoints.length];

        front[0] = cardPoints[0];
        back[0] = cardPoints[cardPoints.length - 1];
        for (int i = 1; i < cardPoints.length; i++) {
            front[i] = front[i - 1] + cardPoints[i];
            back[i] = back[i - 1] + cardPoints[cardPoints.length - i - 1];
        }

        int result = Math.max(front[k - 1], back[k - 1]);
        int flag = k - 2;
        while (flag >= 0) {
            result = Math.max(result, front[flag] + back[k - 2 - flag]);
            flag--;
        }
        return result;
    }

    public static int maxScoreSlid(int[] cardPoints, int k) {
        int sum = 0, total = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            if (i < cardPoints.length - k)
                sum += cardPoints[i];
            total += cardPoints[i];
        }

        int result = sum;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            sum += cardPoints[i] - cardPoints[i - cardPoints.length + k];
            result = Math.min(result, sum);
        }

        return total - result;
    }
}
