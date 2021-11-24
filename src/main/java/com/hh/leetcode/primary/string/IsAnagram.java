package com.hh.leetcode.primary.string;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 *
 *
 * 示例1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t仅包含小写字母
 *
 *
 * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * 来源：力扣（LeetCode）
 *
 * @author HaoHao
 * @date 2021/11/24 9:28 下午
 */
public class IsAnagram {

    /**
     * 计算两个字符串中字符的差值
     * 先统计字符串s中每个字符的数量
     * 减去t中每个字符对应的数量
     *
     * 如果最后结果都是0，说明t是s的字母异位词。
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 26个小写字母,初始值都是0
        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            // 当前字符在s 压根没有,或者s中比较少
            if (charCount[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            charCount[t.charAt(i) - 'a']--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "a"));
    }
}
