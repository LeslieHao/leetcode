package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 *
 * @author HaoHao
 * @date 2021/12/4 2:17 下午
 */
public class InvertTree {

    /**
     * 递归解法
     * <p>
     * 时间复杂度：O(N)，其中 N 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
     * <p>
     * 空间复杂度：O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(\log N)O(logN)。而在最坏情况下，树形成链状，空间复杂度为 O(N)O(N)。
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 7, 2, 9, 6, 3, 1};
        TreeNode transfer = TreeUtils.transfer(arr);
        invertTree(transfer);

    }
}
