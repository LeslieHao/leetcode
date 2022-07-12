package com.hh.leetcode.tree;

import com.hh.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * 通过次数32,231提交次数78,786
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2021/12/21 10:36 下午
 */
public class MaxWidth {

    /**
     * 层序遍历
     * 每个结点的值用不上，把值改成每个结点的序号索引，根据完全二叉树的性质进行编号，编号规则：
     * 根节点编号为0，左孩子编号为根节点编号2，右孩子编号为根节点编号2+1，逐层往下编号;
     * 每层编号的时候为了防止编号值过大，将每层第一个元素的值设置为offset偏移量，每层的后序结点的值减去这个offset，保持相对关系不变。
     * 每层遍历结束，更新res，res就是每层最后一个结点编号-第一个结点编号+1
     *
     */
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode first = queue.getFirst();
            TreeNode last = queue.getLast();
            // 每层的队尾和队首相减
            int temp = last.val - first.val + 1;
            if (temp > res) {
                res = temp;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    poll.left.val = poll.val * 2;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = poll.val * 2 + 1;
                    queue.add(poll.right);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        TreeNode transfer = TreeUtils.transfer(new Integer[]{1, 2, 3, 4});
        System.out.println(widthOfBinaryTree(transfer));
    }
}
