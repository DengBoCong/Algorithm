package com.dbc.leecode.Algorithm.Solution211_220;

import java.util.Stack;

public class Solution218 {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == ' ') continue;

            if(Character.isDigit(arr[i])){
                int tempNum = arr[i] - '0';
                while(++i < arr.length && Character.isDigit(arr[i])){
                    tempNum = tempNum * 10 + (arr[i] - '0');
                } i--;

                if(lastOp == '+') numStack.push(tempNum);
                else if(lastOp == '-') numStack.push(-tempNum);
                else numStack.push(res(lastOp, numStack.pop(), tempNum));
            } else lastOp = arr[i];
        }

        int ans = 0;
        for(int num : numStack) ans += num;
        return ans;
    }

    private int res(char op, int a, int b){
        if(op == '*') return a * b;
        else if(op == '/') return a / b;
        else if(op == '+') return a + b;
        else return a - b;
    }
}
