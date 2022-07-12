package com.hh.leetcode.string;

/**
 * 541. 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * @author HaoHao
 * @date 2022/2/22 4:24 下午
 */
public class ReverseString2 {

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2 * k) {
            int r = i + k - 1;
            reverse(chars, i, Math.min(r, s.length() - 1));
        }
        return new String(chars);
    }

    public static void reverse(char[] arr, int l, int r) {
        while (l <= r) {
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 3));
    }

}


