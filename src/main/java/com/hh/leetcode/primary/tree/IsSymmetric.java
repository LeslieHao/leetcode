package com.hh.leetcode.primary.tree;

/**
 * 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author HaoHao
 * @date 2021/2/20 3:28 下午
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        // 1.递归
        if (root == null) {
            return true;
        }
        return judge(root.left, root.right);
    }

    /**
     * 左右是否对称
     */
    private boolean judge(TreeNode leftNode, TreeNode rightNode) {
        // 左右都为空节点
        if (leftNode == null && rightNode == null) {
            return true;
        }
        // 有一个空节点或值不相等
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }
        return judge(leftNode.left, rightNode.right) && judge(leftNode.right, rightNode.left);
    }

}
