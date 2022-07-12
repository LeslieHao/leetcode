package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.*;

/**
 * @author HaoHao
 * @date 2021/2/2 4:49 下午
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                // 当前层
                level.add(node.val);
                // 下一层
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                --size;
            }
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(levelOrder2(transfer));
    }


}
