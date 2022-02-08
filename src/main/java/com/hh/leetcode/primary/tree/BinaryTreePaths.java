package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

import java.util.*;

/**
 * 257. 二叉树的所有路径
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 *
 * @author HaoHao
 * @date 2022/2/8 6:59 下午
 */
public class BinaryTreePaths {

     List<String> paths = new ArrayList<>();

     StringBuilder path = new StringBuilder();


    public  List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return paths;
    }

    private  void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int t = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            // 叶子节点
            paths.add(path.toString());
        }
        path.append("->");
        dfs(root.left);
        dfs(root.right);
        // 删除掉最后一个叶子节点
        path.delete(t, path.length());
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, 4, 5});
        //List<String> list = binaryTreePaths(transfer);
        //System.out.println(list);
    }

}
