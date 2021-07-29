package com.dbc.leecode.Algorithm.Solution31_40;

public class Solution39 {
    public static String countAndSay(int n) {
        String str = "";
        String res = "1";
        for(int i = 1; i < n; i++){
            str = res;
            res = "";
            for(int j = 0; j < str.length();){
                int c = 0, k = j;
                while(k < str.length() && str.charAt(k) == str.charAt(j)){
                    k++;
                    c++;
                }
                res = res + c + str.charAt(j);
                j = k;
            }
        }
        return res;
    }

    public String countAndSayS2(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }

        return str;
    }
}
