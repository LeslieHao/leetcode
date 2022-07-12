package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树递归序
 *
 * @author HaoHao
 * @date 2022/3/18 10:51 上午
 */
public class TreeDiGuiXu {


    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeDiGuiXu app = new TreeDiGuiXu();
        String serialize = app.Serialize(transfer);
        System.out.println(serialize);
        TreeNode treeNode = app.Deserialize(serialize);
        TreeUtils.printTree(treeNode);
    }


    String Serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        // 先序遍历
        String res = root.val + ",";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }


    TreeNode Deserialize(String str) {
        String[] split = str.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(split));
        return doDeserialize(queue);
    }

    private TreeNode doDeserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String poll = queue.poll();
        if ("#".equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = doDeserialize(queue);
        root.right = doDeserialize(queue);
        return root;
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("前-" + root.val + ",");
        print(root.left);
        System.out.print("中-" + root.val + ",");
        print(root.right);
        System.out.print("后-" + root.val + ",");
    }

    /**
     * 1
     * 2      3
     * 4  5   6   7
     * <p>
     * 递归序: 1 2 4 4 4 2 5 5 5 2 1 3 6 6 6 3 7 7 7 3 1
     */
    public static TreeNode findParent(TreeNode root, TreeNode c1, TreeNode c2) {
        if (root == null || root.val == c1.val || root.val == c2.val) {
            return root;
        }
        //System.out.print("前-" + root.val + ",");
        TreeNode left = findParent(root.left, c1, c2);
        //System.out.print("中-" + root.val + ",");
        TreeNode right = findParent(root.right, c1, c2);
        System.out.print("后-" + root.val + ",");
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //System.out.println(root.val);
        return root;
    }


}
