package com.dbc.leecode.Algorithm.Solution91_100;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-14 17:14
 **/
public class Solution100 {
    public void recoverTreeS1(TreeNode root) {
        if (root == null) {
            return;
        }
        //寻找左子树中最大的节点
        TreeNode maxLeft = getMaxOfBST(root.left);
        //寻找右子树中最小的节点
        TreeNode minRight = getMinOfBST(root.right);

        if (minRight != null && maxLeft != null) {
            //左边的大于根节点，右边的小于根节点，对应情况 3，左右子树中的两个数字交换
            if ( maxLeft.val > root.val && minRight.val < root.val) {
                int temp = minRight.val;
                minRight.val = maxLeft.val;
                maxLeft.val = temp;
            }
        }

        if (maxLeft != null) {
            //左边最大的大于根节点，对应情况 1，根节点和左子树的某个数做了交换
            if (maxLeft.val > root.val) {
                int temp = maxLeft.val;
                maxLeft.val = root.val;
                root.val = temp;
            }
        }

        if (minRight != null) {
            //右边最小的小于根节点，对应情况 2，根节点和右子树的某个数做了交换
            if (minRight.val < root.val) {
                int temp = minRight.val;
                minRight.val = root.val;
                root.val = temp;
            }
        }
        //对应情况 4，左子树中的两个数进行了交换
        recoverTree(root.left);
        //对应情况 5，右子树中的两个数进行了交换
        recoverTree(root.right);

    }
    //寻找树中最小的节点
    private TreeNode getMinOfBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode minLeft = getMinOfBST(root.left);
        TreeNode minRight = getMinOfBST(root.right);
        TreeNode min = root;
        if (minLeft != null && min.val > minLeft.val) {
            min = minLeft;
        }
        if (minRight != null && min.val > minRight.val) {
            min = minRight;
        }
        return min;
    }

    //寻找树中最大的节点
    private TreeNode getMaxOfBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode maxLeft = getMaxOfBST(root.left);
        TreeNode maxRight = getMaxOfBST(root.right);
        TreeNode max = root;
        if (maxLeft != null && max.val < maxLeft.val) {
            max = maxLeft;
        }
        if (maxRight != null && max.val < maxRight.val) {
            max = maxRight;
        }
        return max;
    }

    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode cur = root;
        TreeNode pre_new = null;
        while (cur != null) {
            // 情况 1
            if (cur.left == null) {
                /*******************************************************/
                if (pre_new != null && cur.val < pre_new.val) {
                    if (first == null) {
                        first = pre_new;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                pre_new = cur;
                /*******************************************************/
                cur = cur.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 情况 2.1
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                // 情况 2.2
                if (pre.right == cur) {
                    pre.right = null; // 这里可以恢复为 null
                    /*******************************************************/
                    if (pre_new != null && cur.val < pre_new.val) {
                        if (first == null) {
                            first = pre_new;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    pre_new = cur;
                    /*******************************************************/
                    cur = cur.right;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
