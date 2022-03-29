package com.dbc;

public class MaximizeTheConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, right = 0, res = 0;
        int fCount = 0, tCount = 0;
        while (right < answerKey.length()) {
            while (right < answerKey.length() && (fCount <= k || tCount <= k)) {
                if (answerKey.charAt(right) == 'T') tCount++;
                else fCount++;
                right++;
            }

            res = Math.max(res, (fCount <= k || tCount <= k) ? right - left : right - left - 1);

            while (right < answerKey.length() && left < right && (fCount > k && tCount > k)) {
                if (answerKey.charAt(left) == 'T') tCount--;
                else fCount--;
                left++;
            }
        }
        res = Math.max(res, (fCount <= k || tCount <= k) ? right - left : right - left - 1);
        return res;
    }
}
