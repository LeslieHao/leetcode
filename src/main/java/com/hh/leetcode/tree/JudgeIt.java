package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * <p>
 * 描述
 * 给定一棵二叉树，已知其中的节点没有重复值，请判断该二叉树是否为搜索二叉树和完全二叉树。
 * 输出描述：分别输出是否为搜索二叉树、完全二叉树。
 * <p>
 * <p>
 * 数据范围：二叉树节点数满足 0 \le n \le 5000000≤n≤500000 ，二叉树上的值满足 0 \le val \le 1000000≤val≤100000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * <p>
 * 注意：空子树我们认为同时符合搜索二叉树和完全二叉树。
 *
 * @author HaoHao
 * @date 2022/3/17 7:05 下午
 */
public class JudgeIt {

    public boolean[] judgeIt(TreeNode root) {
        boolean isSearch = isSearch(root);
        boolean isComplete = isComplete(root);
        return new boolean[]{isComplete, isComplete};
    }


    public boolean isComplete(TreeNode root){
        if (root == null) {
            return true;
        }
        // 层序遍历
        // 左孩子为空 右孩子不为空
        // 当出现一个孩子为空时,剩下的都是叶子节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leafFlag = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (leafFlag){
                if (poll.left != null || poll.right != null) {
                    return false;
                }
            }
            if (poll.left == null && poll.right != null) {
                return false;
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }else {
                leafFlag = true;
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }else {
                leafFlag = true;
            }

        }
        return true;
    }

     static int preVal = Integer.MIN_VALUE;

    public static boolean isSearch(TreeNode root){
        if (root == null) {
            return true;
        }
        // 中序遍历
        if (!isSearch(root.left)) {
            return false;
        }
        if (root.val <=preVal) {
            return false;
        }
        preVal = root.val;

        return isSearch(root.right);
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{3});
        System.out.println(isSearch(transfer));
    }
}
