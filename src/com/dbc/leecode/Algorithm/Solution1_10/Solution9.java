package com.dbc.leecode.Algorithm.Solution1_10;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2019-12-10 22:52
 **/
public class Solution9 {
    public static int myAtoiS1(String str) {
        int length = str.length();
        int left = -1; // 标记数字串左边
        int right = -1; // 标记数字串右边
        boolean flag = false;
        boolean zFlag = false;
        int result = 0;

        for(int i = 0; i < length; i++){
            if((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '-' || str.charAt(i) == '+'){
                if(!flag) {
                    left = right = i;
                    flag = true;
                    continue;
                }
                if(flag) right = i;
                if((str.charAt(i) == '-' && str.charAt(i - 1) == '+') || str.charAt(i) == '+' && str.charAt(i - 1) == '-')
                    return 0;
            }else if(str.charAt(i) == ' ') continue;
            else break;
        }
        if(left == -1 || (left == right && (str.charAt(0) == '-' || str.charAt(0) == '+'))) return 0;
        try {
            result = Integer.parseInt(str.substring(left, right + 1));
        }catch (NumberFormatException e){
            if(str.charAt(0) == '-') return -Integer.MIN_VALUE;
            else return Integer.MIN_VALUE;
        }
        return result;
    }
}
