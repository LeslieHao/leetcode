package com.hh.leetcode.primary.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * @author HaoHao
 * @date 2020/3/23 3:38 下午
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));
    }

    public static int lengthOfLongestSubstring1(String s) {
        // 滑动窗口
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                // 出现重复,有两种情况
                // 1. 重复的点已经不在窗口内了
                // 2. 重复的点还在窗口内
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    static int lengthOfLongestSubstring(String s) {
        // ascii 数组,记录字符串中每一个字符的位置
        int[] ascii = new int[256];
        // 长度
        int res = 0;
        // 最左下标
        int leftIndex = 0;
        //  遍历
        for (int i = 0; i < s.length(); i++) {
            // 当前字符
            char c = s.charAt(i);
            // 当前字符的是否重复(从左下标开始算起)
            if (ascii[c] > leftIndex) {
                // 重复,从重复位置开始计算长度
                leftIndex = ascii[c];
            } else {
                // 当前子串长度
                int curLength = i - leftIndex + 1;
                if (curLength > res) {
                    res = curLength;
                }
            }
            // 讲字符下标+1 填充到ascii 表中,从1开始.
            ascii[c] = i + 1;
        }
        return res;
    }
}
