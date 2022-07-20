package com.hh.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 16.26. 计算器
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * @author HaoHao
 * @date 2022/3/16 3:29 下午
 */
public class Calculate {

    public static void main(String[] args) {
        Calculate test = new Calculate();
        System.out.println(test.calculate("3+2*2"));
    }

    public int calculate(String s) {
        // 去掉空格
        s = s.replace(" ", "");
        Deque<Integer> deque = new ArrayDeque<>();

        // 记录上一个运算符,遇到下一个运算符的时候,由上一个运算符决定当前数字的操作,初始为+号因为第一个数要入栈
        char lastChar = '+';
        int curNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // 遇到数字 计算出当前数值
                curNum = curNum * 10 + (c - '0');
            }
            // 最后一位的时候也要执行计算
            if (!Character.isDigit(c) || i == s.length() - 1) {
                // 遇到+- 入栈(-号要入栈负数),还要考虑数字是多位的情况
                if (lastChar == '+') {
                    deque.push(curNum);
                } else if (lastChar == '-') {
                    deque.push(-curNum);
                } else if (lastChar == '*') {
                    // 遇到*/ 出栈计算再入栈
                    deque.push(deque.pop() * curNum);
                } else {
                    deque.push(deque.pop() / curNum);
                }
                lastChar = c;
                curNum = 0;
            }
        }

        // 出栈加和
        int res = 0;
        for (Integer integer : deque) {
            res += integer;
        }
        return res;
    }
}
