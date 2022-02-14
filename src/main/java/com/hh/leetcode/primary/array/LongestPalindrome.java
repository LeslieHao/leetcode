package com.hh.leetcode.primary.array;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvn3ke/
 *
 * @author HaoHao
 * @date 2020/8/31 7:37 下午
 */
public class LongestPalindrome {

    /**
     * 中心扩展
     *
     * @param s 目标串
     * @return 最长回文子串
     * @author haohao
     * @date 2020/8/31 8:05 下午
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        // 得到字符数组
        char[] chars = s.toCharArray();
        // 回文开始index
        int start = 0;
        // 回文结束index
        int end = 0;
        // 遍历
        for (int i = 0; i < chars.length; i++) {
            // 单中心点
            int lenthSignleCenter = getCurSteLenth(chars, i, i);
            // 双中心点
            int lenthDoubleCenter = getCurSteLenth(chars, i, i + 1);
            // 最长
            if (lenthSignleCenter > lenthDoubleCenter) {
                if (lenthSignleCenter > (end - start + 1)) {
                    start = i - lenthSignleCenter / 2;
                    end = i + lenthSignleCenter / 2;
                }
            } else {
                if (lenthDoubleCenter > (end - start + 1)) {
                    start = i - lenthDoubleCenter / 2 + 1;
                    end = i + lenthDoubleCenter / 2;
                }
            }
        }
        return s.substring(start, end+1);
    }


    private static int getCurSteLenth(char[] chars, int left, int right) {
        int l = left;
        int r = right;

        while (l >= 0 && r  < chars.length && chars[l] == chars[r]) {
            // 如果左右相等 则向外扩展
            l--;
            r++;
        }
        // 返回子串长度
        return r - l - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaa"));
    }




}
