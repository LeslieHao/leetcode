package com.hh.leetcode.midium.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * @author HaoHao
 * @date 2021/12/9 9:53 下午
 */
public class GenerateParenthesis {

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("", n, n);
        return res;
    }

    private static void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0) {
            getParenthesis(str + "(", left - 1, right);
        }
        // 剩的右括号比左括号多,多余
        if (left < right) {
            getParenthesis(str + ")", left, right - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
