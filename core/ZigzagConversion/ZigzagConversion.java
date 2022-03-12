package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        List<Character>[] resMatrix = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            resMatrix[i] = new ArrayList<>();
        }
        int curPoint = 0, flag = 0;
        for (int i = 0; i < s.length(); i++) {
            resMatrix[curPoint].add(s.charAt(i));
            if (flag == 0 && curPoint + 1 < numRows) {
                curPoint++;
            } else if (flag == 0 && curPoint - 1 >= 0) {
                curPoint--;
                flag = 1;
            } else if (curPoint - 1 >= 0) {
                curPoint--;
            } else if (curPoint + 1 < numRows) {
                curPoint++;
                flag = 0;
            }
        }

        StringBuffer res = new StringBuffer();
        for (List<Character> chList : resMatrix) {
            for (Character ch : chList) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
