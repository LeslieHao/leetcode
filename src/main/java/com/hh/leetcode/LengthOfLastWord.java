package com.hh.leetcode;

/**
 * @author HaoHao
 * @date 2022/2/3 4:22 下午
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        // 去掉末尾空格
        while (s.charAt(index) == ' ') {
            index--;
        }

        int c = 0;
        // 遍历最后一个单词
        while (index >= 0 && s.charAt(index) != ' ') {
            c++;
            index--;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }
}