package com.hh.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 先序遍历 实际就是dfs
 *
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

    public static List<Integer> preorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            // 始终保持左孩子在栈顶,下一层循环还是左孩子在栈顶
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }

    public static void print(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        print(treeNode.left);
        System.out.println(treeNode.val);
        print(treeNode.right);
        System.out.println(treeNode.val);

    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode tree = TreeUtils.transfer(arr);
        print(tree);
    }


}
