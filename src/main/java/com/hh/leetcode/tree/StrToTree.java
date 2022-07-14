package com.hh.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 字符串生成二叉树
 * <p>
 * 示例:
 * 输入: "4(2(3)(1))(6(5))"
 * 输出: 返回代表下列二叉树的根节点:
 * <p>
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * <p>
 * 注意:
 * 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9'
 * 空树由 "" 而非"()"表示。
 *
 * @author HaoHao
 * @date 2021/12/1 10:16 下午
 */
public class StrToTree {


    /**
     * "4(2(3)(1))(6(5))"
     */
    public static TreeNode str2tree(String s) {
        if ("".equals(s)) {
            return null;
        }

        char[] arr = s.toCharArray();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(new TreeNode(Integer.parseInt(String.valueOf(arr[0]))));
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                TreeNode node ;
                if (arr[i - 1] == ')') {
                    node = new TreeNode(Integer.parseInt(String.valueOf(arr[i + 1])));
                    stack.peek().right = node;
                } else {
                    node = new TreeNode(Integer.parseInt(String.valueOf(arr[i + 1])));
                    stack.peek().left = node;
                }
                stack.push(node);
            } else if (c == ')') {
                stack.pop();
            }
        }

        return stack.getFirst();
    }

    public static void main(String[] args) {
        TreeNode node = str2tree("4(2(3)(1))(6(5))");
        TreeUtils.printTree(node);
    }

}
