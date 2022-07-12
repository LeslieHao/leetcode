package com.hh.leetcode.primary.array;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * @author HaoHao
 * @date 2022/7/10 10:07 下午
 */
public class SubarraySum {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 左边距
            // 循环寻找右边界
            int curSum = 0;
            for (int j = i; j <nums.length ; j++) {
                curSum += nums[j];
                if (curSum == k) {
                    count++;
                }
            }
        }
        return count;
    }


}
