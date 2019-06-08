package com.hh.leetcode.primary.array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author HaoHao
 * @date 2019-06-06 17:28
 */
public class OnlyOneTime {

    public int singleNumber(int[] nums) {
        // 循环异或
        int target = -1;
        for (int i = 0; i < nums.length; i++) {
            target = target ^ nums[i];
        }
        return target;
    }
}
