package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void dfs(TreeNode node, List<Integer> nums) {
        if (node != null) {
            dfs(node.left, nums);
            nums.add(node.val);
            dfs(node.right, nums);
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
        dfs(root1, nums1);
        dfs(root2, nums2);

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        while (left < nums1.size() || right < nums2.size()) {
            int num1 = left < nums1.size() ? nums1.get(left) : 1000000;
            int num2 = right < nums2.size() ? nums2.get(right) : 1000000;
            if (num1 <= num2) {
                res.add(num1);
                left++;
            } else {
                res.add(num2);
                right++;
            }
        }
        return res;
    }
}
