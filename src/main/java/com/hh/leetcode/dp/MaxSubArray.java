package com.hh.leetcode.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author HaoHao
 * @date 2019-06-11 18:14
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        int max = nums[0];

        int sumNow = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
          sumNow = sumNow + nums[i];
            if (sumNow > max) {
                max = sumNow;
            }
            if (sumNow < 0) {
                sumNow = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-3, -2, 0, -1}));
    }

}
