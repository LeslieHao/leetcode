package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * <p>
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 *
 * @author HaoHao
 * @date 2022/2/8 7:39 下午
 */
public class SearchBST {

    /**
     * 递归
     * <p>
     * 若 root 为空则返回空节点；
     * 若 val=root.val，则返回 root；
     * 若 val<root.val，递归左子树；
     * 若 val>root.val，递归右子树
     * <p>
     * O(n)
     * O(n)
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    /**
     * 迭代
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
