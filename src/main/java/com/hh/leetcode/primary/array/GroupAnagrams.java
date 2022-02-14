package com.hh.leetcode.primary.array;

import java.util.*;

/**
 *
 * 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i]仅包含小写字母
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvaszc/
 * 来源：力扣（LeetCode）
 *
 * @author HaoHao
 * @date 2021/11/25 10:02 下午
 */
public class GroupAnagrams {


    /**
     * 由于互为字母异位词的两个字符串包含的字母相同，
     * 因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
     * 故可以将排序之后的字符串作为哈希表的键。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 异位词,排序后一定是相同的
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String k = new String(chars);
            List<String> list = map.getOrDefault(k, new ArrayList<>());
            list.add(str);
            map.put(k, list);
        }
        return new ArrayList<>(map.values());

    }
}
