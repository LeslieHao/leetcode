package com.hh.leetcode.primary.tree;

/**
 * @author HaoHao
 * @date 2021/2/2 2:50 下午
 */
public class TreeNode  {
    //父节点
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(Integer val) {
        this.val = val;
    }

}