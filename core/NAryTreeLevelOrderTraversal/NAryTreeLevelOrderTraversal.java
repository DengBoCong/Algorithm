package com.dbc;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int level = 1;
        Queue<Pair<Integer, Node>> queue = new LinkedList<>();
        queue.add(new Pair<>(level, root));
        while (!queue.isEmpty()) {
            Pair<Integer, Node> node = queue.poll();
            level = node.getKey();
            if (res.size() < level) {
                res.add(new ArrayList<>());
            }
            res.get(level - 1).add(node.getValue().val);
            for (Node item : node.getValue().children) {
                queue.add(new Pair<>(level + 1, item));
            }
        }
        return res;
    }
}
