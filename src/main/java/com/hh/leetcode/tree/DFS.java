package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.*;

/**
 * 深度优先 Depth First Search
 *
 * @author HaoHao
 * @date 2022/1/9 11:42 下午
 */
public class DFS {

    static List<TreeNode> list = new ArrayList<>();

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 递归模拟了栈结构
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }


    /**
     * 实际就是前序遍历
     * @param root
     */
    public static void dfs2(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            // 保持left 在栈顶(如果存在)
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, null, 4, 5, 6, null, null, 7, 8});
        dfs2(transfer);
        System.out.println(list);
    }

}
