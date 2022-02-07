package com.hh.leetcode;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 * @author HaoHao
 * @date 2022/2/3 4:50 下午
 */
public class ReplaceSpace {

    public static String replaceSpace(String s) {
        int length = s.length();
        // 预留空间的数组
        char[] arr = new char[length * 3];

        int idx = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                arr[idx++] = '%';
                arr[idx++] = '2';
                arr[idx++] = '0';
            } else {
                arr[idx++] = c;
            }
        }
        return new String(arr, 0, idx);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("we ar f"));
    }
}
