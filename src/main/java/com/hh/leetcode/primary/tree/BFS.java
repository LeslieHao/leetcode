package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先 breadth first search
 *
 * @author HaoHao
 * @date 2022/1/9 11:35 下午
 */
public class BFS {

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static List<TreeNode> bfs(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.add(poll);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, null, 4});
        System.out.println(bfs(transfer));
    }

}
