package com.hh.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 * @author HaoHao
 * @date 2022/7/9 10:38 下午
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("bba", "ab"));
    }

    public static String minWindow(String s, String t) {
        // 存放s 中每个字符个数
        Map<Character, Integer> mapS = new HashMap<>();
        // 存放t 中每个字符个数
        Map<Character, Integer> mapT = new HashMap<>();

        // 先存入t 的对应个数
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (mapT.containsKey(c)) {
                mapT.put(c, mapT.get(c) + 1);
            } else {
                mapT.put(c, 1);
            }
        }
        String res = "";
        // t 已经被满足的字符个数
        int fillCount = 0;
        int left = 0;
        int minLen = 0;

        // 滑动窗口
        for (int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            mapS.put(chars, mapS.getOrDefault(chars, 0) + 1);
            if (mapT.containsKey(chars) && mapT.get(chars) >= mapS.get(chars)) {
                fillCount++;
            }
            // 收缩窗口,不需要的元素,或者多的元素
            while (left < i &&
                    (!mapT.containsKey(s.charAt(left)) || mapT.get(s.charAt(left)) < mapS.get(s.charAt(left)))) {
                mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);
                left++;
            }
            // 全部被满足
            if (fillCount >= t.length() && (minLen == 0 || (i - left + 1) < minLen)) {
                minLen = i - left + 1;
                res = s.substring(left, i + 1);
            }

        }
        return res;
    }
}
