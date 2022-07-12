package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1,3,4]
 * 示例 2:
 * <p>
 * 输入:[1,null,3]
 * 输出:[1,3]
 * 示例 3:
 * <p>
 * 输入:[]
 * 输出:[]
 *
 * @author HaoHao
 * @date 2022/2/28 4:52 下午
 */
public class RightSideView {

    /**
     * 层序遍历,保存每层最后一个节点
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode poll = queue.poll();
                if (size == 0) {
                    // 左后一个
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, null, 5, null, 4});
        List<Integer> integers = rightSideView(transfer);
        System.out.println(integers);
    }
}
