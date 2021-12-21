package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;
import com.hh.leetcode.hard.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树后序遍历
 *
 * @author HaoHao
 * @date 2021/12/20 12:32 上午
 */
public class PostorderTraversal {

    List<Integer> result = new ArrayList<>();

    /**
     * 左右根
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return result;
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode child = root;

        while (!stack.isEmpty() || child != null) {
            while (child != null) {
                // 左
                stack.push(child);
                child = child.left;
            }
            TreeNode node = stack.pop();
            if (node.right == null) {
                result.add(node.val);
            } else {
                child = node.right;
            }
        }
        return result;
    }

    /**
     *    4
     *  7  2
     * 3 4
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {4, 7, 2, 3, 4};
        TreeNode tree = TreeUtils.transfer(arr);
        System.out.println(postorderTraversal2(tree));
    }


}
