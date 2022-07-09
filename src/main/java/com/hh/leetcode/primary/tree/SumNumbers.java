package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * <p>
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *
 * @author HaoHao
 * @date 2022/3/23 2:15 下午
 */
public class SumNumbers {


    /**
     * dfs 深度优先搜索
     */
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);

    }

    private static int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }


    /**
     * 广度优先搜索
     */
    public static int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        valueQueue.add(root.val);
        nodeQueue.add(root);

        int sum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode poll = nodeQueue.poll();
            // 父节点的value
            Integer preValue = valueQueue.poll();
            if (poll.left != null) {
                valueQueue.add(preValue * 10 + poll.left.val);
                nodeQueue.add(poll.left);
            }
            if (poll.right != null) {
                valueQueue.add(preValue * 10 + poll.right.val);
                nodeQueue.add(poll.right);
            }
            if (poll.left==null&&poll.right==null){
                sum += preValue;
            }

        }

        return sum;

    }


    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3});
        System.out.println(sumNumbers(transfer));
        System.out.println(sumNumbers2(transfer));
    }

}
