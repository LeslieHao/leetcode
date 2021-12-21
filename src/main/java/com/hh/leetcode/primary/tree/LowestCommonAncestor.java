package com.hh.leetcode.primary.tree;

import com.hh.leetcode.TreeNode;
import com.hh.leetcode.hard.TreeUtils;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2021/12/19 11:40 下午
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findPorQ(root, p, q);
    }

    public static TreeNode findPorQ(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            // 目标在左子树
            return findPorQ(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            // 目标在右子树
            return findPorQ(root.right, p, q);
        }
        // root 就是目标
        return root;
    }

    public static TreeNode findPorQ2(TreeNode root, TreeNode p, TreeNode q) {
        // 非递归写法
        // 遍历
        TreeNode curRoot = root;
        while (true) {
            if (p.val < curRoot.val && q.val < curRoot.val) {
                // 目标在左子树
                curRoot = curRoot.left;
            } else if (p.val > curRoot.val && q.val > curRoot.val) {
                // 目标在右子树
                curRoot = curRoot.right;
            } else {
                // 一左一右 说明当前就是分叉点
                return curRoot;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode treeByArr = TreeUtils.transfer(arr);
        System.out.println(findPorQ2(treeByArr, treeByArr.left, treeByArr.left.right).val);
    }
}
