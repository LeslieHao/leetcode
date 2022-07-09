package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 *
 * @author HaoHao
 * @date 2022/2/22 10:40 下午
 */
public class TreeSerialize {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        String res = root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(split));
        return process(queue);
    }

    public TreeNode process(Queue<String> queue) {
        String v = queue.poll();
        if ("null".equals(v)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(v));
        node.left = process(queue);
        node.right = process(queue);
        return node;
    }


    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, null, 4, 5});
        TreeSerialize treeSerialize = new TreeSerialize();
        String serialize = treeSerialize.serialize(transfer);
        System.out.println(serialize);
        //TreeUtils.printTree(deserialize(serialize));
    }
}
