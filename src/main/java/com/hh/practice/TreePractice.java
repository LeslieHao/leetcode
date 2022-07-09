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

    /**
     * 4(2(3)(1))(6(5))
     * <p>
     * 4
     * /   \
     * 2     6
     * / \   /
     * 3   1 5
     */
    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(chars[0])));
        stack.push(root);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                TreeNode node = new TreeNode(Integer.parseInt(String.valueOf(chars[i + 1])));
                if (chars[i - 1] == ')') {
                    // 右孩子
                    stack.peek().right = node;
                } else {
                    // 左孩子
                    stack.peek().left = node;
                }
                stack.push(node);
            } else if (chars[i] == ')') {
                stack.pop();
            }
        }
        return root;
    }


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

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val < root.val && q.val < root.val) {
                // 目标节点在左子树
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                // 目标节点在右子树
                root = root.right;
            } else {
                return root;
            }
        }
    }


    public static void printOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        printOrder(root.left);
        System.out.println(root);
        printOrder(root.right);
        System.out.println(root);
    }

    public static int maxDepth2(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }



    public static void main(String[] args) {
        maxDepth2(TreeUtils.transfer(new Integer[]{1, 2, 3, 4, 5}));
    }
}
