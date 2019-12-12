package com.dbc.leecode.Algorithm.Solution11_20;

public class Solution13 {
    public static String intToRomanS1(int num) {
        String nums1[] = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"};
        String nums2[] = new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String nums3[] = new String[]{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String nums4[] = new String[]{"M","MM","MMM"};

        String result = "";
        int flag = 1; //用于记录第几层
        while (num != 0){
            if(num % 10 != 0) {
                switch (flag){
                    case 1: result = nums1[num % 10 - 1] + result;break;
                    case 2: result = nums2[num % 10 - 1] + result;break;
                    case 3: result = nums3[num % 10 - 1] + result;break;
                    case 4: result = nums4[num % 10 - 1] + result;break;
                }
            }

            num = num / 10;
            flag++;
        }
        return result;
    }

    public static String intToRomanS2(int num){
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }
}
