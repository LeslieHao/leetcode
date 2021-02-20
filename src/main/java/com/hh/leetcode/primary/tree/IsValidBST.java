package com.hh.leetcode.primary.tree;

/**
 *
 * 验证二叉搜索树
 *
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author HaoHao
 * @date 2021/2/2 2:44 下午
 */
public class IsValidBST {

    /**
     * 是否是二叉搜素树
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return judge(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private static boolean judge(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        // 递归左子树,上界为root val,
        // 递归右子数,下界为root val
        return judge(root.left, minValue, root.val) && judge(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 4};
        TreeNode treeByArr = TreeUtils.transfer(arr);
        System.out.println(isValidBST(treeByArr));

    }
}
