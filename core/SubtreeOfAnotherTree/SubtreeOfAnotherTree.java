package com.dbc.code;

public class SubtreeOfAnotherTree {
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

    private boolean res = false;
    private String dfs(TreeNode node, String flag) {
        if (node == null) return "null";
        String leftNode = dfs(node.left, flag);
        String rightNode = dfs(node.right, flag);
        String nodeStr = String.format("l%s|%d|r%s", leftNode, node.val, rightNode);
        if (nodeStr.equals(flag)) {
            this.res = true;
        }
        return nodeStr;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String subStr = dfs(subRoot, null);
        dfs(root, subStr);
        return this.res;
    }
}
