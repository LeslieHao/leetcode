package com.hh.leetcode.hard;


import com.hh.leetcode.TreeNode;

/**
 * Author:liuyu
 * Date:2019-02-21
 */
public class TreeUtils {

    //打印树的时候依据每行来打印，每行初始2048个字符
    private static char[] line = new char[2048];

    //判断二叉树是否为平衡二叉树的参数，min为二叉树最低高度，max为最高
    private static int min;
    private static int max;

    static {
        for (int i = 0; i < line.length; i++) {
            line[i] = ' ';
        }
    }

    //将结构化的数组，转变为二叉树
    public static TreeNode transfer(Integer[] arr) {
        if (arr[0] == null) {
            throw new RuntimeException("first element can't be null!");
        }
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            nodes[i] = new TreeNode(arr[i]);
            if (i != 0) {
                int parent = i - 1 >>> 1;
                if (nodes[parent] == null) {
                    throw new RuntimeException("can't transfer!");
                }
                nodes[i].parent = nodes[parent];
                if (i % 2 == 0) {
                    nodes[parent].right = nodes[i];
                } else {
                    nodes[parent].left = nodes[i];
                }
            }
        }
        return nodes[0];
    }


}
