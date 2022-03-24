package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    class DListNode {
        public int key;
        public int val;
        public DListNode next;
        public DListNode prev;

        public DListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final DListNode head = new DListNode(0, 0);
    private final DListNode tail = new DListNode(0, 0);
    private final int capacity;
    private int size = 0;
    private final Map<Integer, DListNode> map = new HashMap();

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        DListNode node = this.map.get(key);
        removeNode(node);
        addHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (!this.map.containsKey(key)) {
            DListNode node = new DListNode(key, value);
            this.map.put(key, node);
            addHead(node);
            this.size++;
            if (this.size > this.capacity) {
                DListNode temp = this.tail.prev;
                removeNode(temp);
                this.map.remove(temp.key);
                this.size--;
            }
        } else {
            DListNode node = this.map.get(key);
            node.val = value;
            removeNode(node);
            addHead(node);
        }
    }

    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(DListNode node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
}
