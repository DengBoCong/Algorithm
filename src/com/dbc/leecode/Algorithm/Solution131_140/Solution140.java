package com.dbc.leecode.Algorithm.Solution131_140;

import java.util.*;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-28 10:47
 **/
public class Solution140 {
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()){
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++){
                    if (wordDictSet.contains(s.substring(start, end))){
                        queue.add(end);
                        if (end == s.length()){
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}
