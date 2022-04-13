package com.dbc;

import java.util.*;

public class InsertDeleteGetrandomO1 {
    private final List<Integer> nums = new ArrayList<>();
    private final Map<Integer, Integer> index = new HashMap<>();
    Random random = new Random();
    public InsertDeleteGetrandomO1() {
    }

    public boolean insert(int val) {
        if (this.index.containsKey(val)) return false;
        this.index.put(val, this.nums.size());
        this.nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!this.index.containsKey(val)) return false;
        this.nums.set(this.index.get(val), this.nums.get(this.nums.size() - 1));
        this.index.put(this.nums.get(this.nums.size() - 1), this.index.get(val));
        this.nums.remove(this.nums.size() - 1);
        this.index.remove(val);
        return true;
    }

    public int getRandom() {
        return this.nums.get(random.nextInt(this.nums.size()));
    }
}
