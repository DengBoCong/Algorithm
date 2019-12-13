package com.dbc.leecode.Algorithm.Solution11_20;

public class Solution15 {
    public static String longestCommonPrefixS1(String[] strs) {
        int flag = 0;
        int length = strs.length;

        if(length == 0) return "";
        if(length == 1) return strs[0];
        for(int i = 0; i < strs[0].length(); i++){
            char s = strs[0].charAt(i);
            for(int j = 1; j < length; j++){
                if(i < strs[j].length() && s == strs[j].charAt(i)){
                    if(j == length - 1) flag++;
                }else {
                    i = strs[0].length();
                    break;
                }
            }
        }
        return strs[0].substring(0, flag);
    }

    public static String longestCommonPrefixS2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    public String longestCommonPrefixS3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixS3(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefixS3(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefixS3(strs, l , mid);
            String lcpRight =  longestCommonPrefixS3(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
