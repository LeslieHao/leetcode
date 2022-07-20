package com.hh.leetcode.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * @author HaoHao
 * @date 2022/7/17 4:44 下午
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses("(()))"));
    }

    public int longestValidParentheses(String s) {
        // 栈的思路
        if (s == null || s.length() < 2) {
            return 0;
        }

        // 记录左括号下标
        Deque<Integer> stack = new ArrayDeque<>();

        int maxLength = 0;


        // 左端点
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // 左括号
            if (cur == '(') {
                stack.push(i);
            } else {
                // 右括号
                if (stack.isEmpty()) {
                    startIndex = i + 1;
                } else {
                    Integer pop = stack.pop();
                    if (stack.isEmpty()) {
                        // 到了右端点了
                        maxLength = Math.max(maxLength, i - startIndex + 1);
                    } else {
                        // pop 之后如果还有左括号说明当前还没到左又端点
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }

                }
            }

        }
        return maxLength;
    }

}
