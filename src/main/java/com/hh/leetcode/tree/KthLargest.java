package com.hh.leetcode.tree;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * @author HaoHao
 * @date 2022/2/8 3:44 下午
 */
public class KthLargest {

    /**
     * 二叉树中序遍历 是递增的
     * 左根右递增
     * 右根左递减
     * 所以右根左遍历k 次得到目标值
     */

    int res = -1;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;

        return res;
    }

    public void ygz(TreeNode root) {
        if (root == null) {
            return;
        }
        ygz(root.right);
        if (--k == 0) {
            res = root.val;
        }
        ygz(root.left);
    }
}
