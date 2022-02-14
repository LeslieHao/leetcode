package com.hh.leetcode;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * @author HaoHao
 * @date 2022/2/9 1:48 下午
 */
public class SearchNum {

    /**
     * 我们要找的就是数组中「第一个等于 target 的位置」（记为leftIdx）和「第一个大于 target 的位置减一」（记为 rightIdx）。
     * 当 target 在数组中存在时，target 在数组中出现的次数为 rightIdx−leftIdx+1。
     *
     */
    public int search(int[] nums, int target) {

        return -1;
    }
}
