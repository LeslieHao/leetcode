package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;
import com.hh.leetcode.hard.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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


    public static List<Integer> inorderTraversal(TreeNode root) {
        // 结果集
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 左根右
            while (cur != null) {
                // 没课子树.左一直到底,然后根 然后右子树
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return list;
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
     *    4
     *  7  2
     * 3 4
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {4, 7, 2, 3, 4};
        TreeNode tree = TreeUtils.transfer(arr);
        System.out.println(inorderTraversal(tree));
    }

}
