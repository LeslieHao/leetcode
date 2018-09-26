package com.hh.leetcode.primary.tree;

import javax.swing.tree.TreeNode;

/**
 * @author HaoHao
 * @date 2018/9/26下午4:27
 */
public class Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉树最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    /**
     * 是否是二叉搜素树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return judge(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean judge(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return judge(root.left, minValue, root.val) && judge(root.right, root.val, maxValue);
    }


}
