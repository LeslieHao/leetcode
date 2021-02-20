package com.hh.leetcode.primary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HaoHao
 * @date 2021/2/2 4:25 下午
 */
public class TreeUtils {

    /**
     * 前序遍历 数组递归构造二叉树
     *
     * @param arr
     * @return
     */
    public static TreeNode createTreeByArr(Integer[] arr, int index) {
        if (arr == null) {
            return null;
        }
        TreeNode head = null;
        if (index < arr.length) {
            if (arr[index] == null) {
                // 空节点 则当前子树停止递归
                return null;
            }
            // head
            head = new TreeNode(arr[index]);
            // 左子树
            head.left = createTreeByArr(arr, index * 2 + 1);
            // 右子数
            head.right = createTreeByArr(arr, index * 2 + 2);
        }
        return head;
    }

    /**
     * 可视化打印二叉树(层序遍历)
     *
     * @param root
     */
    public static void printTree(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    /**
     * 层序遍历
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // 深度(根节点缩进2n-1)
        int depth = Depth.maxDepth(root);

        // 队列来保存每一行所有的节点
        LinkedList<TreeNode> rowStore = new LinkedList<>();
        // 先将根节点入队
        rowStore.add(root);
        //返回结果
        List<List<Integer>> result = new ArrayList<>();
        // 当前行不为空 循环继续
        while (!rowStore.isEmpty()) {
            // 当前行节点的个数
            int len = rowStore.size();
            // 行
            List<Integer> row = new ArrayList<>();
            StringBuilder rowStr = new StringBuilder();
            // 开头缩进
            for (int i = 0; i < (2 * depth - 1); i++) {
                rowStr.append("\t");
            }

            // 遍历当前行 放入行结果,并将每个的节点的左右节点放入队列
            while (0 < len--) {
                TreeNode node = rowStore.poll();
                row.add(node.val);
                rowStore.add(node.left);
                rowStore.add(node.right);
            }
            System.out.println(rowStr);
            result.add(row);
            depth--;
        }

        return result;
    }

    public static void main(String[] args) {
        // [2147483647]
        Integer[] treeArr = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        // 构建二叉树
        TreeNode root = TreeUtils.createTreeByArr(treeArr, 0);
        // 打印
        TreeUtils.printTree(root);

    }
}
