package com.hh.leetcode.primary.string;

/**
 * 面试题 01.06. 字符串压缩
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * @author HaoHao
 * @date 2022/2/15 2:31 下午
 */
public class CompressString {

    public static String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        char[] chars = S.toCharArray();
        char cur = chars[0];
        int curCount = 1;
        StringBuilder sb = new StringBuilder(cur+"");
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                curCount++;
            } else {
                sb.append(curCount);
                cur = chars[i];
                sb.append(cur);
                curCount = 1;
            }
        }
        sb.append(curCount);
        if (sb.length() >= S.length()) {
            return S;
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(compressString("abbccd"));
    }
}
