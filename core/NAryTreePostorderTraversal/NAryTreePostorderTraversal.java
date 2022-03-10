package com.dbc;

import java.util.ArrayList;
import java.util.List;


public class NAryTreePostorderTraversal {
    public class Node {
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

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        for (Node node : root.children) {
            res.addAll(postorder(node));
        }
        res.add(root.val);
        return res;
    }
}
