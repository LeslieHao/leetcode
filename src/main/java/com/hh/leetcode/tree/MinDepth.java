package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author HaoHao
 * @date 2022/1/10 12:03 上午
 */
public class MinDepth {

    /**
     * 广度优先(层序遍历),记录层数,直到找到左右孩子都为空(叶子节点)
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        int min = 0;
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            min++;
            int curLevelSize = queue.size();
            while (curLevelSize > 0) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return min;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                curLevelSize--;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, null, 4, 5, 6, null, null, 7, 8});
        System.out.println(minDepth(transfer));
    }
}
