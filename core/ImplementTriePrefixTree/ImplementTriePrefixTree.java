package com.dbc.code;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    class TreeNode {
        public char token;
        public boolean end;
        public final Map<Character, TreeNode> next = new HashMap<>();
        public TreeNode() {}
        public TreeNode(char ch, boolean end) {
            this.token = ch;
            this.end = end;
        }
    }

    private final TreeNode root = new TreeNode();
    public ImplementTriePrefixTree() {
    }

    public void insert(String word) {
        TreeNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.next.containsKey(word.charAt(i))) node.next.put(word.charAt(i), new TreeNode(word.charAt(i), false));
            node = node.next.get(word.charAt(i));
        }
        node.end = true;
    }

    public boolean search(String word) {
        TreeNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.next.containsKey(word.charAt(i))) return false;
            node = node.next.get(word.charAt(i));
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.next.containsKey(prefix.charAt(i))) return false;
            node = node.next.get(prefix.charAt(i));
        }
        return true;
    }
}
