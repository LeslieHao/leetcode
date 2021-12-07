package com.hh.leetcode.midium.tree;

import com.hh.leetcode.TreeNode;

import java.util.*;

/**
 * 二叉树中序遍历
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 输入：root = []
 * 输出：[]
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv7pir/
 * 来源：力扣（LeetCode）
 *
 * @author HaoHao
 * @date 2021/11/29 9:08 下午
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                // 最左
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    /**
     * 递归实现
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
}
