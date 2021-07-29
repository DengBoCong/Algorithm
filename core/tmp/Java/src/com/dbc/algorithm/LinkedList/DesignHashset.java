package com.dbc.algorithm.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class DesignHashset {
    private LinkedList[] remain;

    public DesignHashset() {
        remain = new LinkedList[1000];
        for (int i = 0; i < 1000; i++) {
            remain[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int k = key % 1000;
        Iterator<Integer> iterator = remain[k].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        remain[k].offerLast(key);
    }

    public void remove(int key) {
        int k = key % 1000;
        Iterator<Integer> iterator = remain[k].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                remain[k].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int k = key % 1000;
        Iterator<Integer> iterator = remain[k].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }
}
