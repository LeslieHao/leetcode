package com.hh.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 219. 存在重复元素 II
 *
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 示例1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 * @author HaoHao
 * @date 2022/2/11 2:59 下午
 */
public class ContainsNearbyDuplicate {

    /**
     * hash 表
     *
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

    }
}
