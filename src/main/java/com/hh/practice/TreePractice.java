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

    static int preValue;

    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历
        boolean f1 = isBST(root.left);
        if (!f1) {
            return false;
        }
        if (root.val <= preValue) {
            return false;
        } else {
            preValue = root.val;
        }
        return isBST(root.right);
    }

    public static int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = countNode(root.left);
        int r = countNode(root.right);
        return l + r + 1;
    }


    static boolean res = true;

    public static boolean isBalance(TreeNode root) {
        helper(root);
        return res;
    }

    private static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = helper(root.left) + 1;
        int r = helper(root.right) + 1;
        if (Math.abs(l - r) > 1) {
            res = false;
            return 0;
        }
        return Math.max(l, r);
    }

    public static int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }


    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{3, 1, 4, 5, 4, 5});
        //System.out.println(isBST(transfer));
        System.out.println(countNode(transfer));
    }

}
