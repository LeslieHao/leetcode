package com.hh.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 *
 * @author HaoHao
 * @date 2022/7/19 9:31 下午
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString test = new DecodeString();
        System.out.println(test.decodeString("100[leetcode]"));

    }

    public String decodeString(String s) {

        Deque<Integer> numStack = new ArrayDeque<>();

        Deque<String> strStack = new ArrayDeque<>();

        int curNum = 0;

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                // 数字,上一位×10 + 当前
                curNum = curNum * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {
                // 左括号,数字入栈
                numStack.push(curNum);
                // 数字前面的字母串入栈
                strStack.push(str.toString());
                curNum = 0;
                str = new StringBuilder();
            } else if (c == ']') {
                // 栈顶数字
                int pop = numStack.pop();
                StringBuilder curStr = new StringBuilder();
                // 字符*pop
                for (int j = 0; j < pop; j++) {
                    curStr.append(str.toString());
                }
                // 当前字符替换为最新的
                String strPop = strStack.pop();
                str = new StringBuilder(strPop).append(curStr);
            } else {
                // 字母
                str.append(c);
            }
        }
        return str.toString();
    }

}
