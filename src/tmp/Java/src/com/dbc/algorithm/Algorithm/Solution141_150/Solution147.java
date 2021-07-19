package com.dbc.leecode.Algorithm.Solution141_150;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-03-02 10:53
 **/
public class Solution147 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
