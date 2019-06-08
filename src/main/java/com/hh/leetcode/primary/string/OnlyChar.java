package com.hh.leetcode.primary.string;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author HaoHao
 * @date 2019-06-06 18:04
 */
public class OnlyChar {

    public static int firstUniqChar(String s) {
        int arr[] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }

}
