package com.hh.leetcode.primary.array;

/**
 * 53. 最大子数组和
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * @author HaoHao
 * @date 2022/2/9 10:07 下午
 */
public class MaxSubArray {

    /**
     * 贪心算法
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {

            // 累加
            curSum += nums[i];
            // 如果>最大则替换
            if (curSum > max) {
                max = curSum;
            }
            if (curSum >= 0) {

            } else {
                // 如果<0,则从下一位开始从新计算curSum
                curSum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1}));
    }
}
