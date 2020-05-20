package com.dbc.leecode.Algorithm.Solution231_240;

public class Solution240 {
    private final String[] THOUSAND = {"", "Thousand", "Million", "Billion"};
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] HUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num > 0) {
            if(num % 1000 != 0) {
                StringBuilder tmp = new StringBuilder();
                helper(num % 1000, tmp);
                sb.insert(0, tmp.append(THOUSAND[index]).append(" "));
            }
            index++;
            num /= 1000;
        }
        return sb.toString().trim();
    }

    private void helper(int num, StringBuilder tmp) {
        if(num == 0) return;
        if(num < 20) {
            tmp.append(LESS_THAN_TWENTY[num]).append(" ");
        }else if(num < 100) {
            tmp.append(HUNDRED[num / 10]).append(" ");
            helper(num % 10, tmp);
        }else {
            tmp.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred").append(" ");
            helper(num % 100, tmp);
        }
    }
}
