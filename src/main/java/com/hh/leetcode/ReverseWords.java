package com.hh.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个字符串s，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/28 2:08 下午
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        // 使用栈
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                // 碰到空格
                while (!stack.isEmpty()) {
                    chars[idx] = stack.pop();
                    idx++;
                }
                chars[idx] = ' ';
                idx++;
            } else if (i == chars.length - 1) {
                stack.push(chars[i]);
                // 最后一位
                while (!stack.isEmpty()) {
                    chars[idx] = stack.pop();
                    idx++;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("god king"));

    }


}
