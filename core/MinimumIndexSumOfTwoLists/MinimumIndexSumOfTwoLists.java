package com.dbc;

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> remain = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            if (remain.containsKey(list1[i])) continue;
            remain.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int min = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            if (remain.containsKey(list2[i])) {
                if (i + remain.get(list2[i]) < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = i + remain.get(list2[i]);
                } else if (i + remain.get(list2[i]) == min) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
