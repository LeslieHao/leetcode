package com.hh.leetcode.primary.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @author HaoHao
 * @date 2019-06-06 18:13
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        char[] chars = s.trim().toLowerCase().toCharArray();
        int lo = 0;
        int hi = chars.length - 1;
        while (lo < hi) {
            if ((chars[lo] > 'z' || chars[lo] < 'a') && chars[lo] > '9' || chars[lo] < '0') {
                lo++;
                continue;
            }

            if ((chars[hi] > 'z' || chars[hi] < 'a') && chars[hi] > '9' || chars[hi] < '0') {
                hi--;
                continue;
            };

            if (chars[lo] != chars[hi]) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "race a car";
        System.out.println(isPalindrome(str));
    }
}
