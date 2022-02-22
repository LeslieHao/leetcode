package com.hh.practice;

import com.hh.leetcode.TreeNode;
import com.hh.leetcode.primary.tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HaoHao
 * @date 2022/2/22 2:56 下午
 */
public class TreePractice {


    public static void preOrder(TreeNode root) {
        // 先序遍历,根左右
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        // 中序遍历,左根右
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            root = pop.right;
        }
    }

    public static void postOrder(TreeNode root) {
        // 后续遍历,左右根
        // 根左右->根右左,根右左反过来就是左右根
        Deque<TreeNode> stack = new ArrayDeque<>();

        Deque<TreeNode> stackPrint = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stackPrint.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        for (TreeNode node : stackPrint) {
            System.out.print(node.val);
        }
    }


    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        preOrder(transfer);
        //inOrder(transfer);
        //postOrder(transfer);
    }

}
