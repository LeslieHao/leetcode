package com.hh.leetcode.string;

/**
 * <p>
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 * <p>
 * 输入:s = "a"
 * 输入:1
 * 示例 3:
 * <p>
 * 输入:s = "bb"
 * 输入: 2
 *
 * @author HaoHao
 * @date 2022/2/14 5:00 下午
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] countC = new int[128];
        int length = s.length();
        // 记录每个字符出现的个数
        for (int i = 0; i < length; i++) {
            countC[s.charAt(i)]++;
        }
        int res = 0;
        for (int i : countC) {
            if (i % 2 == 0) {
                // 偶数个
                res += i;
            } else if (i > 2) {
                // 奇数个
                res += i - 1;
            }
        }
        if (res < s.length()) {
            res++;
        }
        return res;
    }
}
