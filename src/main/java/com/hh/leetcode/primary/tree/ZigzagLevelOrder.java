package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 *
 * @author HaoHao
 * @date 2022/2/25 2:25 下午
 */
public class ZigzagLevelOrder {

    static boolean flag = false;

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // 层序遍历,双向队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            Deque<Integer> level = new ArrayDeque<>();
            int size = deque.size();
            while (size > 0) {
                TreeNode cur = deque.poll();
                if (cur.left != null) {
                    deque.add(cur.left);
                }
                if (cur.right != null) {
                    deque.add(cur.right);
                }
                if (flag) {
                    level.addFirst(cur.val);
                } else {
                    level.addLast(cur.val);
                }
                size--;
            }
            flag = !flag;
            res.add(new LinkedList<>(level));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> list = zigzagLevelOrder(transfer);
        System.out.println(list);
    }

}
