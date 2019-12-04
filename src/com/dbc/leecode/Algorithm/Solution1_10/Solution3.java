package com.dbc.leecode.Algorithm.Solution1_10;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeeCode
 * @description:
 * @author: DBC
 * @create: 2019-12-04 11:13
 **/
public class Solution3 {
    public static int Test3S1(String s) {
        int max = 0; //标记当前最大子字符串长度
        int nowLength = 1; //标记当前子字符串长度,初始值为1
        Set<Character> table = new HashSet<Character>();

        if(s.length() == 1) return 1;
        if(s.length() == 0) return 0;

        for(int i = 0; i < s.length(); i++){
            nowLength = 1; //每次进入新的循环，重置nowlength
            table.add(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++){
                if (table.contains(s.charAt(j))) {
                    max = nowLength > max ? nowLength : max;
                    table.clear();
                    break;
                }else{
                    table.add(s.charAt(j));
                    nowLength++;

                    if (j == s.length() - 1) max = nowLength > max ? nowLength : max;
                }
            }
        }

        return max;
    }
}
