package com.dbc.algorithm.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class DesignHashMap {
    private LinkedList[] remain;

    public DesignHashMap() {
        remain = new LinkedList[769];
        for (int i = 0; i < 769; i++) {
            remain[i] = new LinkedList<Integer[]>();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int k = key % 769;
        Iterator<Integer[]> iterator = remain[k].iterator();
        while (iterator.hasNext()) {
            Integer[] element = iterator.next();
            if (element[0] == key) {
                element[1] = value;
                return;
            }
        }
        remain[k].offerLast(new Integer[]{key, value});
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int k = key % 769;
        Iterator<Integer[]> iterator = remain[k].iterator();
        while (iterator.hasNext()) {
            Integer[] element = iterator.next();
            if (element[0] == key) {
                return element[1];
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int k = key % 769;
        Iterator<Integer[]> iterator = remain[k].iterator();
        while (iterator.hasNext()) {
            Integer[] element = iterator.next();
            if (element[0] == key) {
                remain[k].remove(element);
                return;
            }
        }
    }
}
