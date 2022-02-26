package com.hh.leetcode.primary.array;

/**
 * 209. 长度最小的子数组
 *
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author HaoHao
 * @date 2022/2/26 11:15 上午
 */
public class MinSubArrayLen {

    /**
     * 滑动窗口
     *
     * 初始状态下，start 和 end 都指向下标 00，sum 的值为 00。
     *
     * 每一轮迭代，将 nums[end] 加到 sum，如果sum≥s，则更新子数组的最小长度（此时子数组的长度是 -+1end−start+1）
     * 然后将 [start]nums从 sum 中减去并将 start 右移，直到 sum<s，在此过程中同样更新子数组的最小长度。
     * 在每一轮迭代的最后，将 end 右移
     *
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        int sum = 0;

        while (end < n) {
            sum = sum + nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans > n ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }
}
