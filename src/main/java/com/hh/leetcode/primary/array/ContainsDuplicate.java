package com.hh.leetcode.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author HaoHao
 * @Description: 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @date 2018/7/21下午3:44
 */
public class ContainsDuplicate {

    /**
     * 排序后 遍历
     * O(nlogn)
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * hash表
     * <p>
     * O(n)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }


    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
