package com.dbc;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        res.add(root.val);
        for (Node node : root.children) {
            res.addAll(preorder(node));
        }

        return res;
    }
}
