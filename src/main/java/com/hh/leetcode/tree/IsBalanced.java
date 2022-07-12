package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

/**
 * 110. 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * @author HaoHao
 * @date 2022/2/8 3:20 下午
 */
public class IsBalanced {

    /**
     * 自顶向下的递归
     * 定义函数 height，用于计算二叉树中的任意一个节点 p 的高度：
     * 具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点，首先计算左右子树的高度，
     * 如果左右子树的高度差是否不超过 1，再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。
     * 这是一个自顶向下的递归的过程。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    /**
     * 自底向上
     */

    static boolean res = true;

    public static boolean isBalanced1(TreeNode root) {
        helper(root);
        return res;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right);
    }

}
