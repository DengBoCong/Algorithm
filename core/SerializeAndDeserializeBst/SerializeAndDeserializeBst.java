package com.dbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserializeBst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void postOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            postOrder(node.left, res);
            postOrder(node.right, res);
            res.add(node.val);
        }
    }

    public String serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        String resStr = res.toString();
        return resStr.substring(1, resStr.length() - 1);
    }

    private TreeNode construct(Stack<Integer> nums, int lower, int upper) {
        if (nums.isEmpty() || nums.peek() < lower || nums.peek() > upper) {
            return null;
        }
        int root_val = nums.pop();
        TreeNode root = new TreeNode(root_val);
        root.right = construct(nums, root_val, upper);
        root.left = construct(nums, lower, root_val);
        return root;
    }


    public TreeNode deserialize(String data) {
        Stack<Integer> postOrder = new Stack<>();
        for (String num : data.split(", ")) {
            if (num.equals("")) continue;
            postOrder.add(Integer.parseInt(num));
        }
        return construct(postOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
