package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author HaoHao
 * @date 2021/12/20 12:17 上午
 */
public class PreorderTraversal {


    List<Integer> list = new ArrayList<>();

    /**
     * 先序遍历,递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 迭代
     * 本质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈。
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 根
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                // 左子节点在栈顶
                stack.push(cur.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 7, 2, 3, 4};
        TreeNode tree = TreeUtils.transfer(arr);
        System.out.println(preorderTraversal2(tree));
    }


}
