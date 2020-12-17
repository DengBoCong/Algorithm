package com.dbc.leecode.Algorithm.Solution191_200;

public class Solution191 {

    public int bitSquareSum(int n){
        int sum = 0;
        while (n > 0){
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n){
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        }while (slow != fast);

        return slow == 1;
    }
}
