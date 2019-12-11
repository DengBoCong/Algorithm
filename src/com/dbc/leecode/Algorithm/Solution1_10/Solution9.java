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
                if(str.charAt(i) == '-' || str.charAt(i) == '+') break;
                if(flag) right = i;
                if((str.charAt(i) == '-' && str.charAt(i - 1) == '+') || str.charAt(i) == '+' && str.charAt(i - 1) == '-')
                    return 0;
            }else if(str.charAt(i) == ' ' && !flag) continue;
            else break;
        }
        if(left == -1 || (left == right && (str.charAt(left) == '-' || str.charAt(left) == '+'))) return 0;
        try {
            result = Integer.parseInt(str.substring(left, right + 1));
        }catch (NumberFormatException e){
            if(str.charAt(left) == '-') return -Integer.MIN_VALUE;
            else return Integer.MIN_VALUE - 1;
        }
        return result;
    }

    public static int myAtoiS2(String str){
        if(str.isEmpty()) return 0;
        char[] mychar=str.toCharArray();
        long ans=0;
        int i=0,sign=1,n=str.length();
        while(i<n&&mychar[i]==' ') {
            i++;
        }
        if(i < n &&mychar[i]=='+') {
            i++;
        }
        else if(i < n &&mychar[i]=='-') {
            i++;
            sign =-1;
        }
        //重点：只管是数字的时候，其余取0
        while(i<n&&(mychar[i]>='0'&&mychar[i]<='9')) {
            if(ans!=(int)ans) {
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            ans=ans*10+mychar[i++]-'0';
        }

        if(ans!=(int)ans) {
            return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }

        return (int)(ans*sign);
    }
}
