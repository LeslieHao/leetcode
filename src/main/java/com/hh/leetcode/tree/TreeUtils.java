package com.hh.leetcode.tree;


import java.util.*;

/**
 * @author haohao
 */
public class TreeUtils {

    public static void printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            // 当前层个数
            int curLevelNum = queue.size();
            // 存储当前层所有元素,为空的用空格代替
            List<String> levelStore = new ArrayList<>();
            while (curLevelNum > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    // 如果是空
                    levelStore.add("\t");
                    // 左右为空
                    queue.add(null);
                    queue.add(null);
                } else {
                    levelStore.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                }
                curLevelNum--;
                // 如果当前层全是null 则跳出
            }
            result.add(levelStore);
            TreeNode temp = queue.stream().filter(Objects::nonNull).findAny().orElse(null);
            if (temp == null) {
                break;
            }
        }


        for (int i = 0; i < result.size(); i++) {
            int height = result.size();
            List<String> levelList = result.get(i);
            StringBuilder level = new StringBuilder();

            for (int j = 0; j < levelList.size(); j++) {
                // 计算间隔
                int duration = 0;
                if (j == 0) {
                    // 第一个节点
                    duration = (int) (Math.pow(2, height - i - 1) - 1);
                } else {
                    duration = (int) (Math.pow(2, height - i) - 1);
                }
                StringBuilder sb = getPreBlank(duration);
                level.append(sb.append(levelList.get(j)));
            }
            System.out.println(level);
        }
    }

    private static StringBuilder getPreBlank(int duration) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < duration; j++) {
            sb.append(" ");
        }
        return sb;
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        printTree(transfer);
        //System.out.println("***1*******");
        //System.out.println("*2***2***");
        //System.out.println("3*3*2*2*");
        //
        //
        //System.out.println("*******1*******");
        //System.out.println("***2*******2***");
        //System.out.println("*3***3***2***2*");
        //System.out.println("3*3*2*2*3*3*2*2");
    }


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
