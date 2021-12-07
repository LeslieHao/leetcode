package com.hh.leetcode.midium.tree;

import com.hh.leetcode.TreeNode;

/**
 * 字符串生成二叉树
 *
 * 示例:
 * 输入: "4(2(3)(1))(6(5))"
 * 输出: 返回代表下列二叉树的根节点:
 *
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 *
 * 注意:
 * 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9'
 * 空树由 "" 而非"()"表示。
 *
 * @author HaoHao
 * @date 2021/12/1 10:16 下午
 */
public class StrToTree {

    /**
     * 遇到第一个"(“括号, 代表有左子树，遇到第二个”("括号代表有右子树。
     */
    TreeNode str2tree(String  s) {
        if ("".equals(s)) {
            return null;
        }
        return null;
    }

}
