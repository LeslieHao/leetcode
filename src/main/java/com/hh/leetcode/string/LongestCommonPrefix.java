package com.hh.leetcode.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author HaoHao
 * @date 2020/3/30 3:31 下午
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 最常公共前缀一定是 最短字符串的前缀
        // 1. 先找到最短字符串
        String minStr = null;
        for (String str : strs) {
            if (minStr == null) {
                minStr = str;
            } else if (str.length() < minStr.length()) {
                minStr = str;
            }
        }
        // 2.从最短字符串第一个字符开始遍历
        StringBuilder sbCur = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < minStr.length(); i++) {
            sbCur.append(minStr.charAt(i));
            // 判断是否是其他字符串的前缀
            for (String str : strs) {
                if (!str.startsWith(sbCur.toString())) {
                    return sbResult.toString();
                }
            }
            sbResult.append(minStr.charAt(i));
        }
        return sbResult.toString();
    }
}
