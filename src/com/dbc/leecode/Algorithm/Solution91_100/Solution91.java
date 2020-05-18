package com.dbc.leecode.Algorithm.Solution91_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-11 12:07
 **/
public class Solution91 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        int subsetNum = 1<<num.length;
        for(int i=0;i<subsetNum;i++){
            List<Integer> list = new ArrayList<>();
            boolean illegal=false;
            for(int j=0;j<num.length;j++){
                if((i>>j&1)==1){
                    if(j>0&&num[j]==num[j-1]&&(i>>(j-1)&1)==0){
                        illegal=true;
                        break;
                    }else{
                        list.add(num[j]);
                    }
                }
            }
            if(!illegal){
                lists.add(list);
            }

        }
        return lists;
    }
}
