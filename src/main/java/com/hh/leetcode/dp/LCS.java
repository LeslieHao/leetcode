package com.hh.leetcode.dp;

/**
 * NC127 最长公共子串
 * <p>
 * 描述
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * <p>
 * 输入：
 * "1AB2345CD","12345EF"
 * 返回值：
 * "2345"
 *
 * @author HaoHao
 * @date 2022/3/14 4:57 下午
 */
public class LCS {

    public static String LCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = 0;
        int rightIndex = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLength) {
                        maxLength = dp[i + 1][j + 1];
                        rightIndex = i;
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return str1.substring(rightIndex - maxLength + 1, rightIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(LCS("1AB2345CD", "12345EF"));
    }
}