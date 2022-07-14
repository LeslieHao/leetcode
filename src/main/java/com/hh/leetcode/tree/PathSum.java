package com.hh.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author HaoHao
 * @date 2022/3/23 3:04 下午
 */
public class PathSum {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> path = new ArrayDeque<>();


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            // 叶子节点
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        // 子树搜搜索完
        path.pollLast();
    }
}
