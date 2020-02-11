package com.dbc.leecode.Algorithm.Solution81_90;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-11 11:47
 **/
public class Solution90 {
    public List<Integer> grayCodeS1(int n){
        List<Integer> res = new ArrayList<Integer>(){{add(0);}};
        int head = 1;
        for (int i = 0; i < n; i++){
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for(int binary = 0;binary < 1 << n; binary++){
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }
}
