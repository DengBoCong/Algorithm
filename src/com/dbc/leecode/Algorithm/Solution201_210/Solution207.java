package com.dbc.leecode.Algorithm.Solution201_210;

import java.util.ArrayList;
import java.util.List;

public class Solution207 {
    public List<List<Integer>> combinationSum3S1(int k, int n) {
        List<List<Integer>> result1 = new ArrayList<>();
        for (int i = 7; i < 512; i++) {
            List<Integer> list = new ArrayList<>();
            if (count(i) == k) {
                int value = i;
                int sum = 0;
                int count = 1;
                while (value > 0) {
                    if ((value & 1) == 1) {
                        sum += count;
                        list.add(count);
                    }

                    count++;
                    value = value >> 1;
                }

                if (sum == n) result1.add(list);
            }
        }
        return result1;
    }

    public int count(int value) {
        int count = 0;
        while (value > 0) {
            if ((value & 1) == 1) count++;
            value = value >> 1;
        }
        return count;
    }

    List<Integer> list;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3S2(int k, int n) {
        list = new ArrayList<>();
        res = new ArrayList<>();
        dfs(1, n, k);
        return res;
    }

    private void dfs(int u, int n, int k) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (n <= 0 || k <= 0) return;
        for (int i = u; i <= 9; i++) {
            list.add(i);
            dfs(i + 1, n - i, k - 1);
            list.remove(list.size() - 1);
        }
    }

    private static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        getRest(1, k, sum, n, list);
        return result;
    }

    public static void getRest(int start, int k, int sum, int n, List<Integer> list) {
        if (sum > n) return;

        if (k == 0 && sum == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (k > 0 && sum < n) {
            for (int i = start; i < 10; i++) {
                if (i >= n) return;
                list.add(i);

                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j));
                }
                System.out.println();

                getRest(i + 1, k - 1, sum + i, n, list);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}
