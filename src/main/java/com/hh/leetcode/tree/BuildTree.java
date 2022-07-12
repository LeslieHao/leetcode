package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * @author HaoHao
 * @date 2022/3/1 3:37 下午
 */
public class BuildTree {


    /**
     * 前序遍历的结果是: [1,2,4,5,3,6,7]
     * 中序遍历的结果是: [4,2,5,1,6,3,7]
     *
     * 1 为根节点
     * 245 为前序遍历左子树
     * 367 为前序遍历右子树
     *
     * 425 为中序遍历左子树
     * 637 为中序遍历右子树
     *
     * 4为左
     * 5为右
     *
     *
     *
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 前序遍历的第一个为当前子树的根节点
        TreeNode treeNode = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            // 寻找根节点在中序遍历中的位置
            if (preorder[0] == inorder[i]) {
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                treeNode.left = buildTree(preLeft, inLeft);
                treeNode.right = buildTree(preRight, inRight);
                break;
            }
        }
        return treeNode;
    }

}
