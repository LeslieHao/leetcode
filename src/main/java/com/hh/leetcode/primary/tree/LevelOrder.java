package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HaoHao
 * @date 2021/2/2 4:49 下午
 */
public class LevelOrder {

    /**
     * 二叉树层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) throws InterruptedException {
        if (root == null) {
            return new ArrayList<>();
        }
        // 队列来保存每一行所有的节点
        LinkedList queue = new LinkedList();
        // 先将根节点入队
        queue.add(root);
        //返回结果
        List<List<Integer>> result = new ArrayList<>();
        // 当前行不为空 循环继续
        while (!queue.isEmpty()) {
            // 当前行节点的个数
            int len = queue.size();
            // 行
            List<Integer> row = new ArrayList<>();
            // 遍历当前行 放入行结果,并将每个的节点的左右节点放入队列
            while (0 < len--) {
                TreeNode node = (TreeNode) queue.poll();
                row.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(row);
        }

        return result;
    }
}
