package com.hh.leetcode.primary.string;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * @author HaoHao
 * @date 2022/2/14 4:32 下午
 */
public class IsSubsequence {

    /**
     * 双指针
     */
    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int length = t.length();
        int sIndex = 0;
        for (int i = 0; i < length; i++) {
            if (sIndex >= s.length()) {
                break;
            }
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
        }
        return sIndex == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("b", "ahbgdc"));
    }
}