package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * <p>
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author HaoHaojava
 * @date 2022/2/7 8:23 下午
 */
public class HasPathSum {

    /**
     * BFS 广度优先搜索解法
     *
     * 首先我们可以想到使用广度优先搜索的方式，记录从根节点到当前节点的路径和，以防止重复计算。
     * 这样我们使用两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可。
     *
     * 时间 O(n)
     * 空间 O(H)
     *
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        nodeQueue.add(root);
        valueQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (node.left == null && node.right == null) {
                // 叶子节点,判断值是否相当
                if (valueQueue.peek() == targetSum) {
                    return true;
                }
            }
            // 非叶子节点
            // 当前节点到根节点的路径和
            Integer pathVal = valueQueue.poll();

            if (node.left != null) {
                valueQueue.add(pathVal + node.left.val);
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                valueQueue.add(pathVal + node.right.val);
                nodeQueue.add(node.right);
            }
        }
        return false;

    }


    /**
     * 递归解法
     * 观察要求我们完成的函数，我们可以归纳出它的功能：询问是否存在从当前节点 root 到叶子节点的路径，满足其路径和为 sum。
     * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：
     * 是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
     * 不难发现这满足递归的性质，若当前节点就是叶子节点，
     * 那么我们直接判断 sum 是否等于 val 即可（因为路径和已经确定，就是当前节点的值，我们只需要判断该路径和是否满足条件）。
     * 若当前节点不是叶子节点，我们只需要递归地询问它的子节点是否能满足条件即可。
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            // 叶子节点
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        System.out.println(17737+27518+30375+3000);
    }

}
