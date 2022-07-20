package com.hh.practice;

import com.hh.leetcode.tree.TreeNode;
import com.hh.leetcode.tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author HaoHao
 * @date 2022/2/22 2:56 下午
 */
public class TreePractice {

    public static void main(String[] args) {
        TreePractice practice = new TreePractice();
        TreeNode root = TreeUtils.transfer(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(practice.lowestCommonAncestor2(root, new TreeNode(4), new TreeNode(6)));
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            // 找到节点
            return root;
        }
        // 左子树找
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        // 右子树找
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null) {
            // 当前root的子树不包含,返回上一层
            return null;
        }
        if (left != null && right != null) {
            //
            return root;
        }
        if (left != null) {
            // 只找到了左子树
            return left;
        } else {
            // 只在有面找到
            return right;
        }
    }

    public int sumNumbers(TreeNode root) {
        // 129. 求根节点到叶节点数字之和
        // 深度优先递归
        return dfs(root, 0);
    }

    public int sumNumbers2(TreeNode root) {
        // 129. 求根节点到叶节点数字之和
        // 非递归
        if (root == null) {
            return 0;
        }
        int res = 0;

        Deque<TreeNode> nodeQueue = new ArrayDeque<>();

        // 存放当前层的值
        Deque<Integer> valueQueue = new ArrayDeque<>();

        valueQueue.add(root.val);
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode poll = nodeQueue.poll();
            Integer value = valueQueue.poll();
            if (poll.left == null && poll.right == null) {
                // 叶子节点
                res += value;
                continue;
            }

            if (poll.left != null) {
                //
                nodeQueue.add(poll.left);
                valueQueue.add(value * 10 + poll.left.val);
            }
            if (poll.right != null) {
                nodeQueue.add(poll.right);
                valueQueue.add(value * 10 + poll.right.val);
            }

        }
        return res;
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }

        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            // 叶子节点,返回
            return num;
        }
        return dfs(root.left, num) + dfs(root.right, num);
    }

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

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


}
