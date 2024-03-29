package com.hh.leetcode.string;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * @author HaoHao
 * @date 2020/4/7 4:50 下午
 */
public class CheckInclusion {

    public static void main(String[] args) {
        CheckInclusion test = new CheckInclusion();
        System.out.println(test.checkInclusion("ab", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        // s1 长度为n, 以n 为窗口遍历s2,看每个字母出现的次数是否相当
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        // 记录26个字母出现的次数
        int[] countN = new int[26];
        int[] countM = new int[26];
        for (int i = 0; i < n; i++) {
            countN[s1.charAt(i) - 'a']++;
            countM[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(countM, countN)) {
            return true;
        }

        // s2 从n 开始往后滑动
        for (int i = n; i < m; i++) {
            countM[s2.charAt(i - n) - 'a']--;
            countM[s2.charAt(i) - 'a']++;
            if (Arrays.equals(countM, countN)) {
                return true;
            }
        }
        return false;
    }
}
