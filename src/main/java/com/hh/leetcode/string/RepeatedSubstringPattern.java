package com.hh.leetcode.string;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * @author HaoHao
 * @date 2022/7/10 11:32 下午
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        // s 一定包含 n 个子串,每个子串的最大长度为 s.len/2
        int size = s.length();
        // 枚举子串长度
        for (int len = 1; len * 2 <= size; len++) {
            if (size % len != 0) {
                continue;
            }
            boolean match = true;
            // 以当前子串长度 判断是否符合
            for (int i = len; i < size; i++) {
                if (s.charAt(i) != s.charAt(i - len)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;

    }
}
