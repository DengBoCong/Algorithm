package com.dbc.algorithm.ReferOffer;

import java.util.Arrays;
import java.util.Comparator;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public String minNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = "" + nums[i];
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) > b.charAt(i)) return 1;
                    else if (a.charAt(i) < b.charAt(i))return -1;
                }
                return 0;
            }
        });

        StringBuffer res = new StringBuffer();
        for (String strNum : strNums) {
            res.append(strNum);
        }
        return res.toString();
    }
}
