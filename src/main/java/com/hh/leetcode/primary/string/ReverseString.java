package com.hh.leetcode.primary.string;

/**
 * 翻转字符串
 *
 * @author HaoHao
 * @date 2019-06-06 17:42
 */
public class ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'1', '2', '3', '4', '5'});
    }

    public static void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }

        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            end--;
            start++;
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }


}
