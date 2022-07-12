package com.hh.leetcode.array;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author HaoHao
 * @date 2019-06-11 18:35
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        // 256个ASCII码 用来记录出现过的字符
        int[] dic = new int[256];

        int count = 0;

        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                count++;
                dic[chars[i]] = 1;
                continue;
            }
            right = i;
            if (dic[chars[i]] != 1) {
                dic[chars[i]] = 1;
            } else {
                left = i;
                dic = new int[256];
                dic[chars[i]] = 1;
            }
            count = Math.max(count, right - left + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcd"));
    }
}
