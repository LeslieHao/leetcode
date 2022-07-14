package com.hh.leetcode.tree;

import java.util.*;

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
     *
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

    /**
     * 前序遍历顺序为：根 -> 左 -> 右
     * 后序遍历顺序为：左 -> 右 -> 根
     * 如果1： 我们将前序遍历中节点插入结果链表尾部的逻辑，修改为将节点插入结果链表的头部
     * 那么结果链表就变为了：右 -> 左 -> 根
     * 如果2： 我们将遍历的顺序由从左到右修改为从右到左，配合如果1
     * 那么结果链表就变为了：左 -> 右 -> 根
     * 这刚好是后序遍历的顺序
     * 基于这两个思路，我们想一下如何处理：
     * 修改前序遍历代码中，节点写入结果链表的代码，将插入队尾修改为插入队首
     * 修改前序遍历代码中，每次先查看左节点再查看右节点的逻辑，变为先查看右节点再查看左节点
     *
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();


        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                // 右子树
                stack.push(root);
                result.addFirst(root.val);
                root = root.right;
            } else {
                TreeNode pop = stack.pop();
                root = pop.left;
            }
        }
        return result;
    }



    public static List<Integer> postorderTraversal3(TreeNode root){
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (root == null) {
            return linkedList;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            linkedList.addFirst(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return linkedList;
    }

    /**
     *    4
     *  7   2
     * 3 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {4, 7, 2, 3, 4};
        TreeNode tree = TreeUtils.transfer(arr);
        System.out.println(postorderTraversal3(tree));
    }


}
