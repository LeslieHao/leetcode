package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.*;

/**
 * 二叉树中序遍历
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv7pir/
 * 来源：力扣（LeetCode）
 *
 * @author HaoHao
 * @date 2021/11/29 9:08 下午
 */
public class InorderTraversal {


    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 左
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            // 如果有为空就会在下一层继续pop
            root = pop.right;
        }
        return res;
    }


    /**
     * 递归实现
     *
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 4
     * 7  2
     * 3 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {4, 7, 2, 3, 4};
        TreeNode tree = TreeUtils.transfer(arr);
        System.out.println(inorderTraversal2(tree));
    }

}
