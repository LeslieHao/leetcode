package com.hh.leetcode.midium.tree;

import com.hh.leetcode.TreeNode;

/**
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvix0d/
 * 来源：力扣（LeetCode）
 *
 * @author HaoHao
 * @date 2021/11/29 10:03 下午
 */
public class BuildTree {

    /**
     * 先序遍历的顺序是根节点，左子树，右子树。中序遍历的顺序是左子树，根节点，右子树。
     * <p>
     * 所以我们只需要根据先序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，右边就是右子树的节点。
     * <p>
     * 生成左子树和右子树就可以递归的进行了。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {

        // preorder 为空，直接返回 null
        if (preorderStart == preorderEnd) {
            return null;
        }

        // 当前子树根节点的值
        int rootValue = preorder[preorderStart];

        // 当前子树根节点
        TreeNode root = new TreeNode(rootValue);

        int inorderRootIndex = 0;
        // 在中序遍历数组中找到根节点位置,左面就是左子树,右面就是右子树
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                inorderRootIndex = i;
                break;
            }
        }

        // 左子树节点个数
        int leftNodeNum = inorderRootIndex - inorderStart;
        // 递归构造左子树
        root.left = buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftNodeNum + 1, inorder, inorderStart, inorderRootIndex);

        // 递归构造右子树
        root.right = buildTreeHelper(preorder, preorderStart + leftNodeNum + 1, preorderEnd, inorder, inorderRootIndex + 1, inorderEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }

}
