package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author HaoHao
 * @date 2022/2/8 3:57 下午
 */
public class SumOfLeftLeaves {

    /**
     * dfs 先序遍历,如果是左叶子节点
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return res;
    }

    int res = 0;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                // 左叶子节点
                res += root.left.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
    }


    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                if (poll.left.left == null && poll.left.right == null) {
                    // 左叶子节点
                    res += poll.left.val;
                }
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, null,null,4, 5});
        System.out.println(sumOfLeftLeaves1(transfer));
    }

}
