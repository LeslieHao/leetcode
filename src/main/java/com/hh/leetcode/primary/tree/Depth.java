package com.hh.leetcode.primary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HaoHao
 * @date 2018/9/26下午4:27
 */
public class Depth {

    /**
     * 二叉树最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
