package com.dbc;

import javafx.util.Pair;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;
        char[] tran = new char[]{'A', 'C', 'G', 'T'};
        Deque<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.offerFirst(new Pair<>(start, 0));
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.pollFirst();
            for (int i = 0; i < pair.getKey().length(); i++) {
                for (char ch : tran) {
                    if (ch != pair.getKey().charAt(i)) {
                        String temp = pair.getKey().substring(0, i) + ch + pair.getKey().substring(i + 1);
                        if (set.contains(temp)) {
                            if (temp.equals(end)) return pair.getValue() + 1;
                            set.remove(temp);
                            queue.addLast(new Pair<>(temp, pair.getValue() + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
