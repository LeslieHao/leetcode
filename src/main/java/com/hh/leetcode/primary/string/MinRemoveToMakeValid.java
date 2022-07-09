package com.hh.leetcode.primary.string;

/**
 * 1249. 移除无效的括号
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 * <p>
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 * <p>
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 可能是 '('、')' 或英文小写字母
 *
 * @author HaoHao
 * @date 2022/7/9 9:42 下午
 */
public class MinRemoveToMakeValid {


    public static String minRemoveToMakeValid(String s) {
        // 先统计右括号个数
        int rightCount = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                rightCount++;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号,如果还有右括号,消耗一对,并拼接字符,否则不加左括号,也不拼接
                if (rightCount > 0) {
                    leftCount++;
                    rightCount--;
                    str.append(s.charAt(i));
                }
            } else if (s.charAt(i) == ')') {
                // 右括号,如果还有左括号,消耗一堆,并拼接字符
                if (leftCount > 0) {
                    leftCount--;
                    str.append(s.charAt(i));
                } else {
                    rightCount--;
                }
            } else {
                // 非括号 直接拼接
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("123())"));
    }
}
