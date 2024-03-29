package com.hh.leetcode.string;

/**
 * 389. 找不同
 * <p>
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * @author HaoHao
 * @date 2022/2/18 3:57 下午
 */
public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        int as = 0;
        int ts = 0;
        // ascii 求和,之后差值
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
            ts += t.charAt(i);
        }
        ts += t.charAt(t.length() - 1);
        return (char) (ts-as);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("123", "1234"));
    }
}
